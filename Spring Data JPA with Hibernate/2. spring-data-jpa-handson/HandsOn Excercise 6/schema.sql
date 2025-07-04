
CREATE TABLE IF NOT EXISTS skill (
    sk_id INT AUTO_INCREMENT PRIMARY KEY,
    sk_name VARCHAR(45)
);

CREATE TABLE IF NOT EXISTS employee_skill (
    es_id INT AUTO_INCREMENT PRIMARY KEY,
    es_em_id INT,
    es_sk_id INT,
    FOREIGN KEY (es_em_id) REFERENCES employee(em_id),
    FOREIGN KEY (es_sk_id) REFERENCES skill(sk_id)
);

INSERT INTO skill (sk_name) VALUES ('Java'), ('SQL'), ('Python');
