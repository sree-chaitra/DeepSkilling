
CREATE TABLE IF NOT EXISTS department (
    dp_id INT AUTO_INCREMENT PRIMARY KEY,
    dp_name VARCHAR(45)
);

CREATE TABLE IF NOT EXISTS employee (
    em_id INT AUTO_INCREMENT PRIMARY KEY,
    em_name VARCHAR(45),
    em_salary DECIMAL(10,2),
    em_permanent BOOLEAN,
    em_date_of_birth DATE,
    em_dp_id INT,
    FOREIGN KEY (em_dp_id) REFERENCES department(dp_id)
);

INSERT INTO department (dp_name) VALUES ('IT'), ('HR'), ('Finance');

INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES ('John Doe', 50000, TRUE, '1990-01-01', 1);
