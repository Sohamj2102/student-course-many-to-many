# Student–Course Many-to-Many Spring Boot Project

## 📌 Project Overview
This project demonstrates a **Many-to-Many Bidirectional relationship** between **Student** and **Course** using **Spring Boot**, **Spring Data JPA**, and **REST APIs**.

It is designed as a **learning + interview-ready project**, following clean architecture and real-world best practices.

---

## 🧩 Relationship Design

- One **Student** can enroll in **multiple Courses**
- One **Course** can have **multiple Students**
- Implemented using a **join table** (`student_course`)
- Mapping is **bidirectional**
  - Student → Courses (Owning side)
  - Course → Students (Inverse side)

---

## 🏗️ Project Architecture

controller → REST Controllers
service → Business logic
repository → JPA repositories
entity → JPA entities
exception → Custom exceptions & global handler


---

## 🚀 Features

- Course CRUD operations
- Student CRUD operations
- Assign / update courses for a student using **IDs**
- Many-to-Many bidirectional mapping
- Global exception handling
- REST APIs tested using **Postman**
- Clean separation of concerns

---

## 🛠️ Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Eclipse IDE
- Git & GitHub

---

## 🔗 API Endpoints

### 📘 Course APIs
- `POST /courses` – Create a course
- `GET /courses` – Get all courses
- `GET /courses/{id}` – Get course by ID
- `PUT /courses/{id}` – Update course
- `DELETE /courses/{id}` – Delete course

### 🎓 Student APIs
- `POST /students?courseIds=1,2` – Create student with courses
- `GET /students` – Get all students
- `GET /students/{id}` – Get student by ID
- `PUT /students/{id}?courseIds=2,3` – Update student details and courses
- `DELETE /students/{id}` – Delete student
