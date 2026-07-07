# Event Ledger Microservices

A production-ready Spring Boot microservices application demonstrating event-driven financial transaction processing with Observability, Resiliency, Service Discovery, and REST-based communication.

---

# Project Overview

This project consists of three Spring Boot microservices.

## 1. service-register

- Eureka Service Registry
- Service Discovery

Runs on:

```
http://localhost:8761
```

---

## 2. eventLedger

Responsibilities

- Accept financial events
- Validate requests
- Persist events
- Forward transactions to Account Service
- Circuit Breaker with Resilience4j
- Trace ID Propagation
- Custom Metrics
- Structured Logging

Runs on:

```
http://localhost:8080
```

---

## 3. accounthandle

Responsibilities

- Create accounts
- Process CREDIT/DEBIT transactions
- Update balances
- Store transaction history

Runs on:

```
http://localhost:8081
```

---

# Technology Stack

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Spring Web
- MySQL
- Spring Cloud Netflix Eureka
- Spring Boot Actuator
- Micrometer Metrics
- Resilience4j Circuit Breaker
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

# Features

## Functional

- Event Management
- Account Management
- Transaction Processing
- REST Communication
- Service Discovery

## Observability

- Spring Boot Actuator
- Custom Metrics using Micrometer
- Structured Logging
- Trace ID Propagation

## Resiliency

- Resilience4j Circuit Breaker
- Retry Mechanism
- Graceful Error Handling

## Production Ready

- Global Exception Handling
- Request Validation
- Idempotent Event Processing
- Health Monitoring

---

# Database

Create the following MySQL databases.

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

### 2. Account Service

```
accounthandle
```

### 3. Event Ledger

```
eventLedger
```

---

# REST APIs

## Account Service

### Create Account

```
POST /accounts/{id}
```

Example

```
POST http://localhost:8081/accounts/ACC1001
```

---

### Apply Transaction

```
POST /accounts/transaction
```

Example

```json
{
  "eventId": "EVT001",
  "accountId": "ACC1001",
  "type": "CREDIT",
  "amount": 500,
  "timestamp": "2026-07-08T10:30:00"
}
```

---

### Get Balance

```
GET /accounts/{id}/balance
```

Example

```
GET http://localhost:8081/accounts/ACC1001/balance
```

---

## Event Ledger

### Create Event

```
POST /events
```

Example

```json
{
  "eventId": "EVT001",
  "accountId": "ACC1001",
  "type": "CREDIT",
  "amount": 500,
  "currency": "INR",
  "eventTimestamp": "2026-07-08T10:30:00"
}
```

---

### Get Event By ID

```
GET /events/{id}
```

---

### Get Events By Account

```
GET /events?accountId=ACC1001
```

---

### Health Check

```
GET /events/health
```

---

# Actuator Endpoints

```
/actuator/health

/actuator/info

/actuator/metrics

/actuator/metrics/events.created
```

---

# Resilience

Implemented using **Resilience4j**.

- Circuit Breaker
- Retry
- Graceful Fallback

---

# Observability

Implemented using:

- Spring Boot Actuator
- Micrometer Metrics
- Trace ID Propagation
- Structured Logging

---

# Build

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

- Docker
- Kubernetes
- OpenTelemetry
- Distributed Tracing
- Prometheus
- Grafana

---

# Author

**Pradyumna Dilip Khot**

GitHub Repository

https://github.com/Pradhumnkhot/event-ledger-microservices
