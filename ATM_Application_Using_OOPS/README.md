# ATM Banking System (Core Java)

This project is a console-based ATM simulation system developed using Core Java.  
The main goal of this project is to apply Object-Oriented Programming (OOP) concepts in a real-world scenario.

---

## Overview

The application simulates basic ATM operations such as deposit and withdrawal while maintaining business rules like minimum balance and tracking total transactions.

It is designed with a clean OOP structure instead of using a single-class or procedural approach.

---

## Features

- Deposit money into account
- Withdraw money with minimum balance validation
- Display account details and current balance
- Track total number of transactions using static variable
- Simple and structured console-based interaction

---

## Concepts Used

This project focuses on applying core OOP concepts:

- Abstraction  
  Implemented using an abstract class `BankAccount`

- Inheritance  
  `SavingsAccount` extends `BankAccount`

- Polymorphism  
  Parent reference used to handle child object

- Encapsulation  
  Controlled access using protected variables

- Static Concepts  
  Static variable for transaction count and static block initialization

---

## Project Structure

org.bankApplication

- BankAccount.java (Abstract class)
- SavingsAccount.java (Business logic implementation)
- ATM.java (Transaction handler)
- BankDriver.java (Main class)

---

## Execution Flow

1. Create account object (SavingsAccount)
2. Pass object to ATM class
3. Perform transaction (deposit / withdraw)
4. Apply business rules (minimum balance check)
5. Update balance and transaction count
6. Display result in console

---

## Business Logic

- Withdrawal is allowed only if balance remains above minimum limit
- Deposit increases account balance
- Each transaction increments a global counter
- Invalid operations are handled safely

---

## How to Run

1. Open project in Eclipse or any Java IDE
2. Run `BankDriver.java`
3. View output in console

---

## Sample Output

ATM System Initiated  
Withdrawal Amount of 200.0 is Successful  
Current Balance: 800.0

Deposited 1000.0 in Your Account  
Current Balance: 1800.0

Total Transaction: 2

---

## Learning Outcome

- Learned how to structure code using OOP
- Understood real-world use of abstraction and inheritance
- Improved code readability and maintainability
- Practiced implementing business logic

---

## Acknowledgment

Special thanks to my mentor for guidance and helping me understand OOP concepts clearly.

---

## Note

This project is part of my learning journey in Java and backend development.
More improvements and features will be added in future.
