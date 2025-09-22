

````markdown
# 💸 Split Group Expense Tracker (Backend)

**Tech Stack:** `Java` | `Spring Boot` | `H2 Database` | `JPA` | `Lombok` | `REST API`  

---

## 🚀 Project Overview

A backend service to manage **group expenses**, calculate individual balances, and generate **minimal transaction settlements**.  
Designed to demonstrate **algorithmic thinking, optimization, and clean backend design**, suitable for SDE-2 resume.  

---

## ✨ Key Features

- **CRUD Operations**  
  - Create groups and users  
  - Add expenses with participants and payer  

- **Automated Balance Calculation**  
  - Computes net balances for each member in a group  

- **Minimal Transaction Settlement Algorithm** ⚡  
  - Optimized algorithm to calculate **minimum number of payments** required to settle all debts  
  - Example:
```text
Bob pays Alice: $30.00
Charlie pays Alice: $20.00
````

* **Data Validation & Edge Case Handling**

  * Ensures participants exist in group
  * Prevents negative or invalid expense entries

* **Preloaded Sample Data**

  * Demo-ready groups and expenses for quick testing

---

## 🔗 API Endpoints

| Endpoint                     | Method | Description                             |
| ---------------------------- | ------ | --------------------------------------- |
| `/api/groups`                | GET    | List all groups and members             |
| `/api/balances/{groupId}`    | GET    | Compute balances for a group            |
| `/api/settlements/{groupId}` | GET    | Minimal transactions to settle balances |
| `/api/expenses`              | POST   | Add a new expense                       |
| `/api/users`                 | POST   | Add a new user                          |

---

## 📝 Example JSON Payloads

**Add User**

```json
{
  "name": "Alice"
}
```

**Add Expense**

```json
{
  "description": "Lunch",
  "amount": 90.0,
  "paidById": 1,
  "participantIds": [1, 2, 3],
  "groupId": 1
}
```

---

## ⚡ Minimal Transaction Example

**Balances:**

```json
{
  "Alice": 50.0,
  "Bob": -30.0,
  "Charlie": -20.0
}
```

**Settlements Output:**

```
Bob pays Alice: $30.00
Charlie pays Alice: $20.00
```

---

## 📂 Project Structure

```
src/main/java/com/example/expense/
├── controller/
│   └── ExpenseController.java
├── entity/
│   ├── User.java
│   ├── GroupEntity.java
│   └── Expense.java
├── repository/
│   ├── UserRepository.java
│   ├── GroupRepository.java
│   └── ExpenseRepository.java
├── service/
│   └── ExpenseService.java
└── DataLoader.java
```

---

## 💡 SDE-2 Level Highlights

* **Optimized backend logic:** Minimal transaction settlement algorithm reduces number of operations
* **Clean architecture:** Separation of controllers, services, and repositories
* **Data modeling:** Proper JPA relationships (Many-to-Many, One-to-Many)
* **Edge case handling & validation:** Prevents invalid operations, ensures robustness
* **Demo-ready:** Preloaded sample data for immediate testing

---

## 📌 How to Run

1. Clone the repository
2. Open in IDE (IntelliJ/Eclipse)
3. Run `ExpenseTrackerApplication.java`
4. Access API via `http://localhost:8080/api/`
5. Test endpoints using **Postman** or **Swagger UI**

---

```

---



Do you want me to do that?
```
