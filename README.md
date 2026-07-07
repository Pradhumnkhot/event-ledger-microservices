# Event Ledger Microservices

A Spring Boot microservices application that demonstrates event-driven financial transaction processing with production-ready features such as observability, resiliency, and REST-based communication.

---

## Project Overview

This project consists of three microservices:

1. **eventLedger**
   - Receives financial transaction events.
   - Validates incoming requests.
   - Persists event data.
   - Forwards transactions to the Account Service.
   - Implements observability and resiliency.

2. **accounthandle**
   - Creates and manages customer accounts.
   - Updates account balances.
   - Stores transaction history.
   - Exposes account REST APIs.

3. **service-register**
   - Eureka Service Registry for service discovery.
   - Registers all microservices.

---

# Technology Stack

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Spring Web
- MySQL
- Spring Actuator
- Spring Cloud Netflix Eureka
- Resilience4j
- Maven
- REST APIs

---

# Project Structure

```
event-ledger-microservices
│
├── eventLedger
│
├── accounthandle
│
├── service-register
│
└── README.md
```

---

# Features

- Event Processing
- Account Management
- REST Communication
- Service Discovery using Eureka
- Health Monitoring
- Metrics using Spring Boot Actuator
- Structured Logging
- Resilience using Circuit Breaker
- Production Ready Configuration

---

# Database

Create the following MySQL databases.

```sql
CREATE DATABASE event_ledger_gateway;

CREATE DATABASE account_service;
```

---

# Run Order

Start the services in the following order.

### 1. Eureka Service Registry

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

```
POST /accounts/{accountId}
```

Example

```
POST http://localhost:8081/accounts/ACC1001
```

---

### Get Account

```
GET /accounts/{accountId}
```

---

### Get Balance

```
GET /accounts/{accountId}/balance
```

---

### Apply Transaction

```
POST /accounts/{accountId}/transactions
```

Example Request

```json
{
    "eventId":"EVT001",
    "amount":500
}
```

---

## Event Ledger

### Create Event

```
POST /events
```

Example Request

```json
{
    "eventId":"EVT001",
    "accountId":"ACC1001",
    "type":"CREDIT",
    "amount":500,
    "currency":"INR"
}
```

---

# Observability

Spring Boot Actuator is enabled.

Available endpoints

```
/actuator/health

/actuator/info

/actuator/metrics
```

---

# Resiliency

The project uses Resilience4j Circuit Breaker to provide graceful handling when downstream services are unavailable.

---

# Logging

Structured logging is enabled for better observability.

---

# Build

For each project

```bash
mvn clean install
```

---

# Run

```bash
mvn spring-boot:run
```

---

# Future Improvements

- Kafka-based asynchronous communication
- Distributed Tracing
- Docker Support
- Kubernetes Deployment
- Centralized Logging
- OpenTelemetry Integration

---

# Author

**Pradyumna Dilip Khot**

GitHub

https://github.com/Pradhumnkhot/event-ledger-microservices
