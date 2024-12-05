package com.example.crdemo.controller;

import com.example.crdemo.model.Employee;
import com.example.crdemo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import java.net.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        logger.info("getAllEmployees Start");
        logger.info("getAllEmployees End");
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        logger.info("getEmployeeById called");
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        logger.info("addEmployee called");
        employeeService.addEmployee(employee);
        return new ResponseEntity<>("Employee created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        logger.info("deleteEmployee called");
        boolean removed = employeeService.deleteEmployee(id);
        if (removed) {
            return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
        }
    }

    @Value("${PAYROLL_URL:#{null}}")
    private String PAYROLL_URL;

    @GetMapping("/salary/{employeeId}")
    public String getSalary(@PathVariable long employeeId) throws URISyntaxException, IOException, InterruptedException {
        try {
            logger.info("getSalary called");

            // Retrieve employee by ID from EmployeeService
            Optional<Employee> employee = employeeService.getEmployeeById(employeeId);

            if (employee.isPresent()) {
                // Extract salary from the employee object (assuming a 'salary' field)
                double salary = employee.get().getSalary();
                return "The salary of emp id " + employeeId + " is USD " + salary;
            } else {
                return "Employee with ID " + employeeId + " not found.";
            }
        } catch (Exception e) {
            // Handle other exceptions
            return "Error retrieving salary: " + e.getMessage();
        }
    }

}