# Java-Practice

This repository contains my structured **Java practice** covering  
**Core Java**, **Object-Oriented Programming**, **Java Collections Framework**,  
and **Java 8 features**.

It is maintained for **continuous learning**, **hands-on practice**,  
and **interview preparation**.

---

## 📌 Core Java Fundamentals

- Object class methods  
  - toString(), equals(), hashCode()  
  - == vs equals()  
  - getClass()
- Static keyword  
  - Class-level variables and methods  
  - Different ways to access static members  
  - Static vs non-static (memory perspective)  
  - Static methods in interfaces (Java 8+)
- Access Modifiers  
  - public, private, protected, default  
  - Same package vs different package access  
  - Inheritance-based access rules

---

## 🧵 String Handling in Java

This section focuses on **immutability, mutability, memory usage, and performance**.

### String
- Immutable nature of String
- String Constant Pool (SCP)
- String literal vs new keyword
- concat() and `+` operator behavior
- New object creation on modification
- Thread-safe due to immutability

### StringBuffer
- Mutable string class
- Thread-safe (synchronized methods)
- append(), insert(), replace(), reverse()
- Slightly slower due to synchronization
- Suitable for multi-threaded environments

### StringBuilder
- Mutable and non-synchronized
- Faster than StringBuffer
- append(), replace(), reverse() usage
- Preferred in single-threaded scenarios

---

## 📦 Arrays & Constructors

### Array
- Declaration and initialization
- Different ways to create arrays
- Index-based element access
- Iteration using for loop and enhanced for-each loop
- Fixed size and length property

### Constructors
- Purpose of constructors
- Default and no-argument constructors
- Parameterized constructors
- Private constructors
- Constructor overloading
- Constructor rules and interview points

---

## 🚨 Exception Handling

- Meaning of exceptions and runtime disruption
- Exception hierarchy (Throwable, Error, Exception)
- Checked vs unchecked exceptions
- Common runtime exceptions  
  - NullPointerException  
  - ArithmeticException  
  - ArrayIndexOutOfBoundsException
- try-catch-finally usage
- try-with-resources (Java 7+)
- Custom exception creation
- JVM errors  
  - OutOfMemoryError  
  - StackOverflowError
- Interview-focused examples and best practices

---

## 🧱 Collections Framework

- ArrayList with custom objects  
  - Understanding equals() and indexOf()
- Set interface  
  - HashSet behavior (no duplicates, one null, no order)
- Object ordering  
  - Comparable (natural ordering)  
  - Comparator (custom ordering using lambda)

---

## ⚠️ Fail-Fast vs Fail-Safe Iterators

- **Fail-Fast**  
  - Throws `ConcurrentModificationException` on structural modification  
  - Works on original collection (`ArrayList`, `HashMap`)  
  - Not thread-safe

- **Fail-Safe**  
  - No exception on modification  
  - Works on a snapshot (`CopyOnWriteArrayList`)  
  - Thread-safe but slower

**Key Point:** Fail-Fast = original collection, Fail-Safe = snapshot copy

---

## ⚙️ Java 8 Features

- Functional Interfaces
- Lambda Expressions
- Predicate
- Stream API
- Date & Time (Legacy API)  
  - java.util.Date  
  - java.sql.Date and conversions

---

## 🧩 Wrapper Classes & Memory Concepts

- Wrapper Classes
- Autoboxing and Unboxing  
  - Internal working of boxing and unboxing  
  - Wrapper usage in collections  
  - Performance considerations and pitfalls

---

## 🧠 OOPS Concepts

### Encapsulation
- Data hiding using private fields
- Controlled access via getters and setters
- Constructor-based initialization
- Use of `this` keyword
- Multiple object instances with independent state

### Inheritance
- Simple inheritance
- Multiple inheritance using interfaces
- super keyword usage
- Aggregation and Composition relationships

### Polymorphism
- Meaning: one interface, many implementations
- Compile-time polymorphism (method overloading)
- Runtime polymorphism (method overriding)
- Dynamic method dispatch (JVM behavior)
- Method overriding vs method hiding
- Static methods and polymorphism limitation
- Bicycle, MountainBike, RoadBike example

### Abstraction
- Meaning: focus on **what** an object does, not **how** it does it
- Achieved using abstract classes and interfaces
- Abstract class may contain abstract and non-abstract methods
- Interfaces define a contract and support multiple inheritance
- Abstract classes cannot be instantiated
- Used to hide implementation details and expose essential behavior
- Improves code flexibility, scalability, and maintainability

---

## 🎯 Goal of This Repository

- Strengthen **Core Java fundamentals**
- Build **concept clarity**, not just syntax knowledge
- Maintain **interview-ready explanations**
- Practice **clean, readable, and correct Java code**

Examples are written with a focus on **clarity**, **real-world usage**,  
and **correct Java practices**.
