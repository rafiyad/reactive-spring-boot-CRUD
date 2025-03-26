# reactive-spring-boot-CRUD

This project is a simple example of a reactive Spring Boot CRUD (Create, Read, Update, Delete) application using Java 21 and Maven. The application demonstrates the use of Spring WebFlux for reactive programming and provides basic operations for managing resources.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [License](#license)

## Prerequisites

Before you begin, make sure you have the following installed:

- Java 21 (or newer)
- Maven 3.8+ 
- IDE of your choice (e.g., IntelliJ IDEA, Eclipse, VSCode)
- Git (optional, for version control)

## Technologies

This project uses the following technologies:

- **Spring Boot 3.x** with WebFlux (for reactive programming)
- **Java 21** (latest LTS version)
- **Maven** (for dependency management and building)
- **Spring Data MongoDB Reactive** (for interacting with MongoDB reactively)
- **Spring WebFlux** (for reactive REST API development)
- **Project Lombok** (for boilerplate code reduction)

## Getting Started

### Clone the repository

```bash
git clone https://github.com/rafiyad/reactive-spring-boot-CRUD.git
cd reactive-spring-boot-CRUD
```


mvn clean install
mvn spring-boot:run
mvn test

## API Endpoints
The application exposes the following RESTful API endpoints:

1. Create a Resource
POST /api/resources

Request Body: JSON object representing the resource to be created.

Response: JSON object of the created resource.

Example:

json
Copy
{
  "name": "Sample Resource",
  "description": "This is a sample resource."
}
2. Get All Resources
GET /api/resources

Response: JSON array of all resources.

3. Get a Single Resource by ID
GET /api/resources/{id}

Response: JSON object representing the resource.

4. Update a Resource
PUT /api/resources/{id}

Request Body: JSON object representing the updated resource.

Response: JSON object of the updated resource.

5. Delete a Resource
DELETE /api/resources/{id}

Response: Status of the deletion.

mongod

spring.data.mongodb.uri=mongodb://localhost:27017/reactive-crud


This `README.md` provides an overview of setting up, configuring, and running a basic reactive Spring Boot CRUD application. It includes sections on prerequisites, technologies used, API endpoints, and running the application.
