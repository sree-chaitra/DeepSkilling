# BankMonolith

A simple monolithic Spring Boot RESTful application that simulates a bank's account balance operation. Intended to demonstrate architectural issues in monoliths under high load.

## How to Run
- Import the project in Eclipse
- Run `BankMonolithApplication.java`
- Access endpoint: `http://localhost:8080/api/account/1/balance`

## Simulated Problem
This monolith can become slow under load due to shared memory and blocking calls, similar to real-world banking applications during peak times.
