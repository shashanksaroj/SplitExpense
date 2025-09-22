# Split Group Expense Tracker (Backend)

**Tech Stack:** Java | Spring Boot | H2 Database | JPA | Lombok | REST API  

---

## Project Overview

Backend service to manage group expenses, calculate individual balances, and generate minimal transaction settlements.  

an Minimal transaction settlement algorithm reduces unnecessary calculations and number of transactions


---

## Key Features

- CRUD operations: create groups, users, and expenses
- Automated balance calculation per group
- Minimal transaction settlement algorithm to reduce number of payments
- Data validation and edge-case handling
- Preloaded sample data for quick testing

---

## API Endpoints

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/groups` | GET | List all groups and members |
| `/api/balances/{groupId}` | GET | Compute balances for a group |
| `/api/settlements/{groupId}` | GET | Minimal transactions to settle balances |
| `/api/expenses` | POST | Add a new expense |
| `/api/users` | POST | Add a new user |

---

## Example Payloads

**Add User**
```json
{
  "name": "Alice"
}
