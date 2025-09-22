# 💸 Split Group Expense Tracker (Backend)

**Tech Stack:** `Java` | `Spring Boot` | `H2 Database` | `JPA` | `Lombok` | `REST API`  

---

## 🚀 Project Overview
A backend service to manage **group expenses**, calculate individual balances, and generate **minimal transaction settlements**.  
Perfect for splitting bills, trips, or shared expenses among friends or teams.  

---

## ✨ Key Features

- **CRUD Operations**  
  - Create groups and users  
  - Add expenses with participants and payer  
  - List all groups and expenses  

- **Automated Balance Calculation**  
  - Computes net balances for each member in a group  
  - Handles multiple participants per expense  

- **Minimal Transaction Settlement Algorithm** ⚡  
  - Calculates **minimum number of payments** required to settle all debts  
  - Example:
    ```text
    Bob pays Alice: $30.00
    Charlie pays Alice: $20.00
    ```

- **Data Validation & Edge Case Handling**  
  - Ensures participants exist in group  
  - Prevents negative or invalid expense entries  

- **Preloaded Sample Data**  
  - Demo-ready groups and expenses for quick testing  

---

## 🔗 API Endpoints

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/groups` | GET | List all groups and members |
| `/api/balances/{groupId}` | GET | Compute balances for a group |
| `/api/settlements/{groupId}` | GET | Get minimal transactions to settle balances |
| `/api/expenses` | POST | Add a new expense |
| `/api/users` | POST | Add a new user |

---

## 📝 Example JSON Payloads

**Add User**
```json
{
  "name": "Alice"
}
