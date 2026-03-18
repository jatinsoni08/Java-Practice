# JDBC User Registration System

A web-based user registration system built using **Java Servlets and JDBC**. It collects user data through a form and stores it in a MySQL database.

---

## Features

- User registration form
- Database connectivity using JDBC
- Success and error handling pages
- Clean MVC-based structure

---

## Tech Stack

- **Java (Servlets)**
- **JDBC**
- **MySQL**
- **HTML / CSS**
- **Apache Tomcat**

---

## Project Structure

```
JDBC-User-Registration-System/
│
├── src/
│   └── main/
│       ├── java/com/jatin/RegisterServlet.java
│       ├── webapp/
│           ├── index.html
│           ├── success.html
│           ├── error.html
│           ├── WEB-INF/web.xml
│
├── README.md
├── .gitignore
```

---

## How It Works

1. User fills the registration form
2. Data is sent to the **RegisterServlet**
3. Servlet connects to MySQL using JDBC
4. Data is stored in the database
5. User is redirected to:
   - ✅ `success.html` (on success)
   - ❌ `error.html` (on failure)

---

1. Clone the repository
2. Open project in **Eclipse / IntelliJ**
3. Configure **MySQL database**
4. Add **MySQL Connector J (JDBC Driver)** manually
5. Deploy project on **Apache Tomcat Server**
6. Run and access via browser

---

## Learning Outcomes

- JDBC workflow and database connectivity
- Handling HTTP requests using Servlets
- Basic web application structure

---

## 🙌 Author

**Jatin Soni**

---

⭐ If you found this project helpful, consider giving it a star!
