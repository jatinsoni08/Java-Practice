# Patient Management System (JDBC + Console-Based)

This project is a console-based Patient Management System built using Java, JDBC, and MySQL.  
The main goal is to implement CRUD operations with a structured and maintainable approach.

---

## 📌 Overview

The application allows managing patient records through a console interface.  
It performs database operations using JDBC and follows a clean separation of logic.

---

## ⚙️ Features

- Add new patient
- View patient details
- Update patient information
- Delete patient record
- Secure database interaction using PreparedStatement

---

## 🧠 Concepts Used

- JDBC (Java Database Connectivity)
- CRUD Operations (Create, Read, Update, Delete)
- PreparedStatement (SQL Injection prevention)
- Layered approach (Controller → Service → DAO)
- Exception Handling

---

## 🧱 Project Structure

PatientManagementSystem

- Controller (Main class)
- Service Layer (Business logic)
- DAO Layer (Database interaction)
- Utility (DB connection)

---

## 🔄 Execution Flow

1. User enters data from console
2. Controller calls Service Layer
3. Service processes logic
4. DAO executes SQL using PreparedStatement
5. Data is stored/retrieved from database
6. Response shown to user

---

## 📌 Business Logic

- Validates input before DB operations
- Uses PreparedStatement for secure queries
- Separates logic and database interaction

---

## ▶️ How to Run

1. Open project in Eclipse / IntelliJ
2. Configure database credentials in utility class
3. Run main class
4. Perform CRUD operations via console

---

## 📊 Sample Output

Patient inserted successfully  
Patient details fetched  
Patient updated successfully  
Patient deleted successfully

---

## 🎯 Learning Outcome

- Hands-on experience with JDBC
- Understanding database interaction in Java
- Writing clean and modular backend code
- Implementing CRUD in real-world structure

---

## 🙏 Acknowledgment

Special thanks to my mentor for guiding me in JDBC and backend development concepts.

---

## 📌 Note

This project is part of my learning journey in backend development.
