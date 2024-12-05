CREATE TABLE IF NOT EXISTS employee (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    salary DECIMAL
);

-- Clear the existing data from the employee table
delete from employee;

-- Insert new employee records
INSERT INTO employee (id, name, salary) VALUES (1, 'John Doe', 50000);
INSERT INTO employee (id, name, salary) VALUES (2, 'Jane Smith', 60000);
INSERT INTO employee (id, name, salary) VALUES (3, 'Bob Johnson', 70000);
INSERT INTO employee (id, name, salary) VALUES (4, 'Emily Watson', 55000);
INSERT INTO employee (id, name, salary) VALUES (5, 'William Jones', 80000);
INSERT INTO employee (id, name, salary) VALUES (6, 'Samantha Brown', 65000);
INSERT INTO employee (id, name, salary) VALUES (7, 'David Lee', 75000);
INSERT INTO employee (id, name, salary) VALUES (8, 'Linda Chen', 90000);
INSERT INTO employee (id, name, salary) VALUES (9, 'Michael Kim', 72000);
INSERT INTO employee (id, name, salary) VALUES (10, 'Karen Wu', 68000);


-- Commit the transaction
commit;
