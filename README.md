Loan Management System (LMS) — Spring Boot Backend
A backend application for managing customers, loans, repayments, and reports. Built using Java, Spring Boot, JPA, JWT, and PostgreSQL, this system is designed for financial operations.

Features that we have in this are:
1.Customer Management

Add new customers that include name, email, contact, address
We can update existing customer details.
We can view individual customer data.

2.Loan Application

Customer can apply for a loan by adding customer, amount, duration, purpose.
Admin can Approv and reject loan based on amount.
Interest calculation using a fixed simple interest formula.

3.Loan Repayment

Customers can repay loans.
Customers can make a repayment for an active loan.
View repayment history by loan ID.
Automatically update overdue loan statuses.
Secured access with JWT and role-based authorization.

4.Loan Status & Reports

We can track Loan based on status: PENDING, APPROVED, REPAID, OVERDUE.
Reports:
Loan history per customer.
Pending loans with amounts.

5.JWT Authentication

Admin & User login functionality by login with username password and get a secret token.
Admin can manage all customers, loans, repayments, and access reports securely.
Role-based access ADMIN vs USER



Technologies and tools:
Java 19, Spring Boot, JPA, PostgreSQL, JWT, Maven, IntelliJ, Postman

How to set up?
git clone https://github.com/your-username/loan-management-system.git
cd loan-management-system


Configure Your DB as I deployed on my local system
spring.datasource.url=jdbc:postgresql://localhost:5432/lms
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
server.port = 3333

then we can simply build and run.


Note-: We can aslo make it like username based accessable in which we just need to pass the token in header and we can fetch username from token and we don't need to pass id's in our all request like for fetching 
data of a particuler user by sending id in url, we can automatically retrive the data of logged in user.

