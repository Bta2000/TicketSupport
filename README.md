# TicketSupport

A mini RESTful API service for managing support tickets, developed using Spring Boot.
The project provides ticket creation, retrieval, status management, validation,
exception handling, database migration and execution time monitoring.

---

## Technologies

- Java 17
- Spring Boot 4
- Spring Data JPA
- PostgreSQL
- Liquibase
- MapStruct
- Lombok
- Swagger OpenAPI
- Spring Validation
- Spring AOP

---

## Features

- Create a new support ticket
- Retrieve ticket details by ID
- Retrieve paginated list of tickets
- Update ticket status
- Request validation
- Global exception handling with unified error response
- Database migration using Liquibase
- Entity and Model mapping using MapStruct
- Custom AOP annotation for logging method execution time

---

## Project Structure
controller → REST API endpoints
service → Business logic
repository → Database access
entity → Database entities
model → API models
mapper → Entity-model conversion
exception → Exception handling
aop → Cross-cutting concerns


---

## Database Configuration

The project uses PostgreSQL.

Database migration is handled automatically using Liquibase.

Before running the application, configure your database credentials in:

application.properties


Before running the application, please configure your own database credentials in the `application.properties` file.

Example:

```properties
spring.datasource.username=your_username
spring.datasource.password=your_password


---

## Swagger Documentation

After running the application, Swagger UI is available at:
http://localhost:8080/swagger-ui/index.html

Example screenshots of API endpoints and responses are available in the `docs` directory.
