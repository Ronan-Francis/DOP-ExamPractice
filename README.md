
# **Library Management System**

A Java-based library management system using **Data-Oriented Programming (DOP)** principles. Members can borrow and return books while enforcing business rules like loan limits and book availability.

---

## **Features**
- **Manage Books**: Borrow and return books.
- **Manage Members**: Track members and their active loans.
- **Loan Records**: Record book loans with relevant details.
- **Data-Oriented Design**: Uses Java `record`, `enum`, and stateless methods.

---

## **Technologies Used**
- **Java 17+**
- **Data-Oriented Programming (DOP)**

---

## **Example Output**
```
Loan{Book='1984', Member='John Doe', LoanDate='2024-12-10'}
Loan{Book='Dune', Member='John Doe', LoanDate='2024-10-12'}
Book returned: 1984
Current loans for member John Doe: [Loan{Book='Dune', Member='John Doe', LoanDate='2024-10-12'}]
```

---
