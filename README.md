

markdown
# 🎓 Student Management System

A simple and powerful **Student Management System** built with **Spring Boot**, designed to manage student records through a clean and intuitive web interface. This application supports full CRUD operations, connecting to a MySQL database.

## 📌 Features

- ➕ Add new student records  
- ✏️ Update existing student information  
- ❌ Delete students from the system  
- 📄 View all students in a structured list  
- 🔍 Search students by name (optional)  
- ✅ Server-side validation and error handling  
- 🧩 Layered architecture (Controller, Service, Repository)

## 🛠 Tech Stack

| Layer        | Technology                         |
|--------------|------------------------------------|
| Backend      | Java, Spring Boot, Spring MVC, Spring Data JPA |
| Frontend     | HTML, CSS, Bootstrap (optional)    |
| Database     | MySQL                              |
| Build Tool   | Maven                              |
| IDE          | Spring Tool Suite / IntelliJ / VS Code |

## 🚀 Getting Started

### Prerequisites
- Java 17+
- MySQL Server
- Maven
- IDE (STS, IntelliJ, VS Code)

### Setup Instructions

1. **Clone the Repository**
   bash
   git clone https://github.com/patushinde14/student_management.git
   cd student-management-system

2. **Configure MySQL Database**
   - Create a database:
     sql
     CREATE DATABASE studentdb;
     
   - Update the database credentials in src/main/resources/application.properties:
     properties
     spring.datasource.url=jdbc:mysql://localhost:3306/studentdb
     spring.datasource.username=your_mysql_username
     spring.datasource.password=your_mysql_password
     spring.jpa.hibernate.ddl-auto=update
     

3. **Run the Application**
   bash
   mvn spring-boot:run
   
   Or run the main class from your IDE.

4. **Access the App**
   
   http://localhost:8080/students
   

## 📁 Project Structure


src
├── controller         # Handles web requests
├── service            # Business logic layer
├── repository         # Data access layer (JPA)
├── model              # Student entity class
└── templates (JSP or Thymeleaf views)



## 🙋‍♂️ Author

**Prathmesh Shinde**  
📍 Pune, Maharashtra  
💼 Full Stack Java Developer  
📧 patushinde7447@gmail.com  


## 💡 Motivation

This project was developed as part of learning Spring Boot and building real-world web applications with clean architecture and database integration. It showcases how to build scalable, maintainable applications using modern Java frameworks.

## 📃 License

This project is open source and available under the [MIT License](LICENSE).


