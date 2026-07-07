# Event Ledger Microservices

A Spring Boot microservices application demonstrating event-driven financial transaction processing using Spring Boot, Spring Data JPA, Eureka Service Registry, and MySQL.

---

# Project Overview

This project consists of three microservices:

## 1. service-register
- Eureka Server
- Service Discovery for all microservices

## 2. eventLedger
- Accepts event requests
- Stores event details
- Retrieves events
- Provides event health endpoint

## 3. accounthandle
- Creates customer accounts
- Processes transactions
- Maintains account balances
- Stores transaction history

---

# Technology Stack

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Spring Web
- MySQL
- Spring Cloud Netflix Eureka
- Spring Boot Actuator
- Maven

---

# Project Structure

```
event-ledger-microservices
│
├── service-register
│
├── eventLedger
│
├── accounthandle
│
└── README.md
```

---

# Database Setup

Create the following databases in MySQL.

```sql
CREATE DATABASE event_ledger_gateway;

CREATE DATABASE account_service;
```

---

# Running the Application

Start the applications in the following order.

### 1. Eureka Server

```
service-register
```

Runs on

```
http://localhost:8761
```

---

### 2. Account Service

```
accounthandle
```

Runs on

```
http://localhost:8081
```

---

### 3. Event Ledger Service

```
eventLedger
```

Runs on

```
http://localhost:8080
```

---

# REST APIs

## Account Service

### Create Account

**POST**

```
/accounts/{id}
```

Example

```
POST http://localhost:8081/accounts/ACC1001
```

---

### Apply Transaction

**POST**

```
/accounts/transaction
```

Example Request

```json
{
    "eventId": "EVT001",
    "accountId": "ACC1001",
    "amount": 500,
    "timestamp": "2026-07-08T10:30:00"
}
```

---

### Get Account Balance

**GET**

```
/accounts/{id}/balance
```

Example

```
GET http://localhost:8081/accounts/ACC1001/balance
```

---

## Event Ledger Service

### Create Event

**POST**

```
/events
```

Example Request

```json
{
    "eventId": "EVT001",
    "accountId": "ACC1001",
    "balance": 500
}
```

---

### Get Event By ID

**GET**

```
/events/{id}
```

Example

```
GET http://localhost:8080/events/EVT001
```

---

### Get Events By Account

**GET**

```
/events?accountId=ACC1001
```

---

### Health Check

**GET**

```
/events/health
```

---

# Features

- Spring Boot Microservices
- Eureka Service Discovery
- REST APIs
- Account Management
- Event Management
- Transaction Processing
- MySQL Database
- Spring Data JPA
- Spring Boot Actuator
- Structured Logging

---

# Build

For each project:

```bash
mvn clean install
```

---

# Run

```bash
mvn spring-boot:run
```

---

# Future Enhancements

- Kafka Integration
- Resilience4j Circuit Breaker
- Docker Support
- Kubernetes Deployment
- Distributed Tracing
- Centralized Logging

---

# Author

**Pradyumna Dilip Khot**

GitHub Repository:

https://github.com/Pradhumnkhot/event-ledger-microservices
