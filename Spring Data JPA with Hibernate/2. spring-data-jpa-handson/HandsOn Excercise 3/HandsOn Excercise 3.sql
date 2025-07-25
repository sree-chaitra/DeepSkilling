-- Create Department Table
CREATE TABLE IF NOT EXISTS department (
    dp_id INT AUTO_INCREMENT PRIMARY KEY,
    dp_name VARCHAR(45) NOT NULL
);

-- Create Employee Table
CREATE TABLE IF NOT EXISTS employee (
    em_id INT AUTO_INCREMENT PRIMARY KEY,
    em_name VARCHAR(45) NOT NULL,
    em_salary DECIMAL(10,2) NOT NULL,
    em_permanent BOOLEAN NOT NULL,
    em_date_of_birth DATE NOT NULL,
    em_dp_id INT,
    FOREIGN KEY (em_dp_id) REFERENCES department(dp_id)
);

-- Create Skill Table
CREATE TABLE IF NOT EXISTS skill (
    sk_id INT AUTO_INCREMENT PRIMARY KEY,
    sk_name VARCHAR(45) NOT NULL
);

-- Create Employee-Skill Mapping Table
CREATE TABLE IF NOT EXISTS employee_skill (
    es_id INT AUTO_INCREMENT PRIMARY KEY,
    es_em_id INT NOT NULL,
    es_sk_id INT NOT NULL,
    FOREIGN KEY (es_em_id) REFERENCES employee(em_id),
    FOREIGN KEY (es_sk_id) REFERENCES skill(sk_id)
);

-- Insert Sample Departments
INSERT INTO department (dp_name) VALUES 
('IT'), 
('HR'), 
('Finance');

-- Insert Sample Skills
INSERT INTO skill (sk_name) VALUES 
('Java'), 
('SQL'), 
('Python'), 
('Spring Boot');

-- Insert Sample Employees
INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES
('John Doe', 50000.00, TRUE, '1990-01-01', 1),
('Jane Smith', 60000.00, TRUE, '1992-05-15', 2),
('Mark Johnson', 55000.00, FALSE, '1988-09-23', 3);

-- Insert Employee-Skill Mappings
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES
(1, 1), -- John Doe - Java
(1, 2), -- John Doe - SQL
(2, 3), -- Jane Smith - Python
(3, 2), -- Mark Johnson - SQL
(3, 4); -- Mark Johnson - Spring Boot
