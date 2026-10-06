# TicketSupport

A mini RESTful API for managing support tickets, built with **Java 17** and **Spring Boot**.

The project demonstrates a layered backend architecture with database persistence, validation, exception handling, database migration, object mapping, API documentation, and cross-cutting concerns implemented with Spring AOP.

---

## Overview

**TicketSupport** is a backend service designed to provide a simple support-ticket management system through RESTful APIs.

The project was developed to practice and demonstrate common backend development concepts used in Spring-based applications, including:

* Layered architecture
* REST API development
* Database interaction with JPA
* Database migration with Liquibase
* Request validation
* Global exception handling
* Entity and DTO/model mapping
* Pagination
* API documentation with OpenAPI / Swagger
* Method execution-time monitoring with Spring AOP

---

## Technologies

| Technology               | Purpose                         |
| ------------------------ | ------------------------------- |
| **Java 17**              | Programming language            |
| **Spring Boot 4**        | Application framework           |
| **Spring Web MVC**       | REST API development            |
| **Spring Data JPA**      | Persistence and database access |
| **PostgreSQL**           | Relational database             |
| **Liquibase**            | Database schema migration       |
| **MapStruct**            | Entity-model mapping            |
| **Lombok**               | Boilerplate code reduction      |
| **Spring Validation**    | Request validation              |
| **Spring AOP / AspectJ** | Cross-cutting concerns          |
| **SpringDoc OpenAPI**    | Swagger API documentation       |
| **Maven**                | Dependency and build management |

---

## Features

* Create support tickets
* Retrieve a specific ticket by ID
* Retrieve tickets using pagination
* Update ticket status
* Request validation
* Centralized exception handling
* Unified error responses
* Database schema management with Liquibase
* Entity-to-model and model-to-entity mapping with MapStruct
* Custom AOP-based method execution-time monitoring
* Interactive API documentation with Swagger UI

---

## Architecture

The application follows a **layered architecture** to separate responsibilities between different parts of the application.

```text
Client
  │
  ▼
Controller
  │
  ▼
Service
  │
  ▼
Repository
  │
  ▼
PostgreSQL Database
```

Additional components support the main application flow:

```text
Model
  ↕
Mapper
  ↕
Entity

Exception
  └── Global Exception Handling

AOP
  └── Method Execution Time Monitoring
```

### Main Layers

* **Controller**
  Exposes RESTful API endpoints and handles HTTP requests and responses.

* **Service**
  Contains the application's business logic and coordinates operations between controllers and repositories.

* **Repository**
  Provides database access through Spring Data JPA.

* **Entity**
  Represents persistent data stored in the database.

* **Model**
  Represents API request and response data.

* **Mapper**
  Handles conversion between entities and API models using MapStruct.

* **Exception**
  Contains custom exceptions and centralized exception handling for consistent API error responses.

* **AOP**
  Implements cross-cutting functionality such as monitoring method execution time without mixing this logic with business code.

---

## Database

The application uses **PostgreSQL** as its relational database.

Database schema changes are managed using **Liquibase**, allowing database structure and changesets to be version-controlled alongside the application source code.

Before running the application, configure your database connection in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.username=your_username
spring.datasource.password=your_password
```

> Do not commit your actual database credentials to the repository.

---

## API Documentation

The project uses **SpringDoc OpenAPI** to provide interactive API documentation.

After starting the application, Swagger UI is available at:

```text
http://localhost:8080/swagger-ui/index.html
```

The `docs` directory contains example screenshots of the API endpoints and responses.

---

## Getting Started

### Prerequisites

Make sure the following are installed:

* Java 17 or later
* Maven
* PostgreSQL

### 1. Clone the repository

```bash
git clone https://github.com/Bta2000/TicketSupport.git
cd TicketSupport
```

### 2. Configure PostgreSQL

Create a PostgreSQL database and configure the connection properties in:

```text
src/main/resources/application.properties
```

### 3. Run the application

Using Maven:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

Once the application starts, the REST API and Swagger documentation will be available.

---

## Project Structure

```text
src
└── main
    ├── java
    │   └── com.codewithBita
    │       └── ticketsupport
    │           ├── aop
    │           ├── controller
    │           ├── entity
    │           ├── exception
    │           ├── mapper
    │           ├── model
    │           ├── repository
    │           └── service
    │
    └── resources
        ├── db
        │   └── changelog
        └── application.properties
```

---

## Learning Objectives

This project was built as a practical exercise to strengthen backend development skills with the Spring ecosystem.

The main goals were to practice:

* Designing RESTful APIs
* Applying layered architecture
* Working with Spring Data JPA
* Managing relational databases
* Implementing database migrations
* Separating API models from persistence entities
* Handling validation and application errors
* Using MapStruct for object mapping
* Documenting APIs with Swagger
* Applying AOP for cross-cutting concerns

---

## Documentation & Screenshots

API examples and Swagger UI screenshots are available in the:

```text
docs/
```

directory.

---

## Author

**Bita Shahani**

Java / Spring Boot Backend Developer

GitHub: [Bta2000](https://github.com/Bta2000)
