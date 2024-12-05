package com.example.crdemo.service;

import com.example.crdemo.model.Branch;
import org.springframework.stereotype.Service;

import java.util.logging.Logger; // Import the Logger class

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class BranchService {

    private static final Logger logger = Logger.getLogger(BranchService.class.getName()); // Initialize the logger outside the code block

    public List<Branch> getBranches() {
        List<Branch> branches = new ArrayList<>();

        logger.info("checkConn:started"); // Use the logger instance

        Properties connectionProperties = new Properties();
        connectionProperties.put("user", "root");
        connectionProperties.put("password", "anurag");
        connectionProperties.put("socketFactory", "com.google.cloud.sql.mysql.socketFactory");
        connectionProperties.put("cloudSqlInstance", "my-project-001-442813:us-central1:test-mysql1");

        // Establish the connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql:///branchdb", connectionProperties)) {
            logger.info("connection successful"); // Use the logger instance

            String query = "SELECT * FROM branch";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {

                while (resultSet.next()) {
                    int branchId = resultSet.getInt("branch_id");
                    String branchName = resultSet.getString("branch_name");
                    String location = resultSet.getString("location");
                    String managerName = resultSet.getString("manager_name");

                    Branch branch = new Branch(branchId, branchName, location, managerName);
                    branches.add(branch);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            logger.severe("Error connecting to database: " + e.getMessage()); // Use the logger for error messages
        }

        logger.info("checkConn:ended"); // Use the logger instance

        return branches;
    }
}