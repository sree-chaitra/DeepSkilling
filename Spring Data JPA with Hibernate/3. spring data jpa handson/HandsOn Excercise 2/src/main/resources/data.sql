INSERT INTO DEPARTMENT (id, name) VALUES (1, 'IT');
INSERT INTO DEPARTMENT (id, name) VALUES (2, 'HR');

INSERT INTO EMPLOYEE (id, name, salary, permanent, em_dp_id) VALUES (1, 'John Doe', 50000, true, 1);
INSERT INTO EMPLOYEE (id, name, salary, permanent, em_dp_id) VALUES (2, 'Jane Smith', 40000, false, 2);
INSERT INTO EMPLOYEE (id, name, salary, permanent, em_dp_id) VALUES (3, 'Mike Brown', 60000, true, 1);

INSERT INTO SKILL (id, name) VALUES (1, 'Java');
INSERT INTO SKILL (id, name) VALUES (2, 'Spring Boot');
INSERT INTO SKILL (id, name) VALUES (3, 'SQL');

INSERT INTO EMPLOYEE_SKILL (es_em_id, es_sk_id) VALUES (1, 1);
INSERT INTO EMPLOYEE_SKILL (es_em_id, es_sk_id) VALUES (1, 2);
INSERT INTO EMPLOYEE_SKILL (es_em_id, es_sk_id) VALUES (3, 2);
INSERT INTO EMPLOYEE_SKILL (es_em_id, es_sk_id) VALUES (3, 3);