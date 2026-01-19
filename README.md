# Rule Engine API – Spring Boot

## Overview
This project implements a dynamic rule engine using Spring Boot.
It evaluates financial transactions against configurable business rules
without using hardcoded conditions.

## Features
- Dynamic rule evaluation
- In-memory rule storage
- RESTful APIs
- Java 17 compatible
- Clean layered architecture

## Tech Stack
- Java 17
- Spring Boot
- Spring Web
- Spring Expression Language (SpEL)

## APIs

### Add Rules
POST /api/rules

Body:
[
  "amount > 1000 and type == 'CREDIT'",
  "amount < 200 and type == 'DEBIT'"
]

### Evaluate Transactions
POST /api/evaluate

Body:
[
  { "id": 1, "amount": 2500, "type": "CREDIT", "category": "electronics" }
]

## Design Notes
ScriptEngine was avoided due to Nashorn deprecation in modern Java versions.
SpEL provides safe and native dynamic expression evaluation.

## How to Run
mvn spring-boot:run
