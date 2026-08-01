# Employee Task Management System

A backend REST API application built using **Java**, **Spring Boot**, and **MySQL** for managing employees and their assigned tasks. This project was developed as part of my internship at **Sopra Steria** to demonstrate backend development using a layered architecture and RESTful web services.

---

## 🚀 Features

### Employee Management

* Create a new employee
* Retrieve all employees
* Retrieve an employee by ID
* Update employee details
* Delete an employee

### Task Management

* Create a new task
* Retrieve all tasks
* Retrieve a task by ID
* Update task details
* Delete a task

### Additional Features

* Assign tasks to employees
* Get all tasks assigned to a specific employee
* Get tasks based on status
* Input validation using Bean Validation
* Global exception handling
* Interactive API documentation using Swagger UI

---

## 🛠️ Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Lombok
* Swagger / OpenAPI
* Postman

---

## 📁 Project Structure

```
src
├── controller
├── service
├── repository
├── entity
├── dto
├── mapper
├── exception
├── config
└── EmployeeTaskManagementApplication.java
```

---

## 🗄️ Database

### Employee

| Field      | Type   |
| ---------- | ------ |
| id         | Long   |
| name       | String |
| email      | String |
| department | String |

### Task

| Field       | Type               |
| ----------- | ------------------ |
| id          | Long               |
| title       | String             |
| description | String             |
| status      | String             |
| dueDate     | LocalDate          |
| employee_id | Long (Foreign Key) |

Relationship:

* One Employee can have many Tasks.
* One Task belongs to one Employee.

---

## 📡 REST API Endpoints

### Employee APIs

| Method | Endpoint                        | Description              |
| ------ | ------------------------------- | ------------------------ |
| POST   | `/employees`                    | Create Employee          |
| GET    | `/employees`                    | Get All Employees        |
| GET    | `/employees/{id}`               | Get Employee By ID       |
| PUT    | `/employees/{id}`               | Update Employee          |
| DELETE | `/employees/{id}`               | Delete Employee          |
| GET    | `/employees/{employeeId}/tasks` | Get Tasks of an Employee |

### Task APIs

| Method | Endpoint                 | Description         |
| ------ | ------------------------ | ------------------- |
| POST   | `/tasks`                 | Create Task         |
| GET    | `/tasks`                 | Get All Tasks       |
| GET    | `/tasks/{id}`            | Get Task By ID      |
| PUT    | `/tasks/{id}`            | Update Task         |
| DELETE | `/tasks/{id}`            | Delete Task         |
| GET    | `/tasks/status/{status}` | Get Tasks By Status |

---

## ✅ Validation

The project validates incoming request data using Bean Validation.

Examples:

* Name cannot be blank
* Email must be valid
* Department cannot be blank
* Task title cannot be blank
* Due date cannot be null

---

## ⚠️ Exception Handling

Custom exceptions are implemented using a global exception handler.

Examples:

* Employee Not Found
* Task Not Found
* Duplicate Employee
* Validation Errors

---

## 📖 API Documentation

Swagger UI is integrated into the project.

After running the application, open:

```
http://localhost:8080/swagger-ui/index.html
```

---

## ▶️ Running the Project

### Clone the repository

```bash
git clone <repository-url>
```

### Navigate to the project

```bash
cd Employee-Task-Management-System
```

### Configure MySQL

Update the following properties in `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Run the application

```
mvn spring-boot:run
```

---

## 🧪 API Testing

The APIs can be tested using:

* Swagger UI
* Postman

---

## 🔮 Future Enhancements

* JWT Authentication
* Role-Based Authorization
* Pagination
* Sorting
* Unit Testing using JUnit & Mockito
* Docker Deployment
* CI/CD Integration

---

## 👨‍💻 Author

**Shobhit Gupta**

Internship Project – Sopra Steria

Backend developed using Java, Spring Boot, REST APIs, and MySQL.
