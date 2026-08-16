"# java-task-3" 
# 🏢 AppNexora

**AppNexora** is a Java-based Enterprise Human Resources Management System designed to manage employees, attendance, leave requests, payroll, authentication, and HR operations through a simple console interface.

The project demonstrates practical Java concepts including **Object-Oriented Programming (OOP), interfaces, service layers, enums, collections, validation, authentication, and Maven project structure**.

---

## 🚀 Features

### 🔐 Authentication

* Secure user sign-in
* Role-based access
* Forgot password
* Employee password reset
* Current password verification before changing password
* Password validation
* Hidden password input when supported by the terminal
* Login session management

Supported roles:

* **Admin**
* **HR**
* **Employee**

---

## 👨‍💼 Admin Dashboard

Administrators can:

* View all employees
* Add new employees
* Remove employees
* Review pending leave requests
* Approve leave requests
* Reject leave requests
* Enter rejection reasons
* View attendance records
* Logout

---

## 👩‍💼 HR Dashboard

HR users can:

* View employees
* Add new employees
* Review pending leave requests
* Approve or reject leave requests
* Mark employee attendance
* View attendance records
* Logout

---

## 👨‍💻 Employee Dashboard

Employees can:

* View their profile
* Submit leave requests
* View their leave requests
* View attendance history
* View payslip information
* Reset their password
* Logout

---

## 📅 Leave Management

Employees can submit different types of leave:

* Annual Leave
* Sick Leave
* Emergency Leave

The system validates:

* Leave type
* Number of requested days
* Available leave balance

Leave requests begin with:

```text
PENDING
```

HR or Admin can then change the status to:

```text
APPROVED
```

or:

```text
REJECTED
```

When a leave request is approved, the requested number of days is deducted from the employee's leave balance.

---

## ⏰ Attendance Management

HR can record employee attendance using:

```text
PRESENT
ABSENT
LATE
```

The system prevents attendance from being recorded more than once for the same employee on the same day.

Employees can also view their own attendance history.

---

## 💰 Payroll

Employees can view their payslip information, including:

```text
Base Salary
Allowances
Deductions
Net Salary
```

---

## 👥 Employee Management

Admin and HR can manage employee information.

Employee records contain information such as:

```text
Employee ID
Name
Email
Department
Position
Leave Balance
```

When adding an employee, the system performs validation including duplicate checks for employee names and email addresses.

---

## 🔑 Password Requirements

Passwords are validated using the following requirements:

* Minimum 8 characters
* At least one lowercase letter
* At least one uppercase letter
* At least one number
* At least one special character

Supported special characters include:

```text
@ # $ % ^ & + = !
```

Example:

```text
Employee@123
```

---

## 🏗️ Project Architecture

The project follows a layered structure:

```text
AppNexora
│
├── src
│   └── main
│       └── java
│           └── org
│               └── example
│                   │
│                   ├── Main.java
│                   │
│                   ├── Entities
│                   │   ├── Attendance.java
│                   │   ├── AttendanceStatus.java
│                   │   ├── Employee.java
│                   │   ├── LeaveRequest.java
│                   │   ├── LeaveStatus.java
│                   │   ├── Payroll.java
│                   │   ├── Role.java
│                   │   └── User.java
│                   │
│                   ├── Interfaces
│                   │   ├── AttendanceService.java
│                   │   ├── EmployeeService.java
│                   │   ├── LeaveService.java
│                   │   ├── PayrollService.java
│                   │   └── UserService.java
│                   │
│                   ├── Services
│                   │   ├── AttendanceServiceImpl.java
│                   │   ├── AuthService.java
│                   │   ├── EmployeeServiceImpl.java
│                   │   ├── LeaveServiceImpl.java
│                   │   ├── PayrollServiceImpl.java
│                   │   └── UserServiceImpl.java
│                   │
│                   └── Utils
│
├── .github
│   └── workflows
│
├── pom.xml
└── README.md
```

---

## 🧩 Main Components

### Entities

Entities represent the core data used by the system.

Examples:

```text
User
Employee
Attendance
LeaveRequest
Payroll
```

---

### Interfaces

Interfaces define the operations available within each part of the system.

Examples:

```text
EmployeeService
LeaveService
AttendanceService
PayrollService
UserService
```

---

### Services

Service implementation classes contain the main business logic.

Examples:

```text
EmployeeServiceImpl
LeaveServiceImpl
AttendanceServiceImpl
PayrollServiceImpl
UserServiceImpl
AuthService
```

---

## 🛠️ Technologies

The project uses:

* **Java 25**
* **Maven**
* **Object-Oriented Programming**
* **Java Collections**
* **Java Interfaces**
* **Enums**
* **Java Streams**
* **LocalDate**
* **JUnit**
* **Git**
* **GitHub**
* **GitHub Actions**

---

## 📋 Requirements

Before running the project, install:

### Java

Java **25** is configured in the Maven project.

Check your Java version:

```bash
java -version
```

### Maven

Check Maven:

```bash
mvn -version
```

### Git

Check Git:

```bash
git --version
```

---

## 📥 Installation

Clone the repository:

```bash
git clone https://github.com/engSulaimanMohammed/AppNexora.git
```

Enter the project folder:

```bash
cd AppNexora
```

---

## ▶️ Running the Project

You can open the project using:

* IntelliJ IDEA
* Eclipse
* VS Code with Java extensions

The main application class is:

```text
src/main/java/org/example/Main.java
```

Run:

```java
Main.java
```

Or compile the Maven project using:

```bash
mvn clean compile
```

---

## 🖥️ Main Menu

When the application starts:

```text
========================================
  Nexora Enterprise Management System
========================================

1. Sign In
2. Forgot Password
3. Exit
```

---

## 🔐 Example Login

The project currently contains sample user accounts for testing different roles.

Example usernames include:

```text
admin
hr
sara
ahmed
khaled
```

> The default accounts are intended for development and demonstration purposes only. Production applications should never store plain-text passwords or hard-code credentials inside source code.

---

## 💡 Example Employee Portal

```text
--- Employee Portal ---

1. My profile
2. Request leave
3. My leave requests
4. My attendance
5. My payslip
6. Reset Password
7. Logout
```

---

## 💡 Example HR Dashboard

```text
--- HR Dashboard ---

1. List employees
2. Add new employee
3. Review pending leave requests
4. Mark attendance
5. View attendance log
6. Logout
```

---

## 💡 Example Admin Dashboard

```text
--- Admin Panel ---

1. List employees
2. Add employee
3. Remove employee
4. Review leave requests
5. View attendance log
6. Logout
```

---

## 🎯 Project Objectives

AppNexora was created to demonstrate how a real HR management workflow can be modeled using Java.

The project focuses on:

* Clean code organization
* Object-Oriented Programming
* Encapsulation
* Abstraction
* Interfaces
* Service-based architecture
* Employee management
* Authentication
* Role-based authorization
* Business logic validation
* HR workflows

---

## 🔮 Future Improvements

Possible future versions of AppNexora may include:

* MySQL database integration
* Password hashing
* Spring Boot backend
* REST API
* Web dashboard
* JavaFX interface
* Employee account creation
* Email-based password recovery
* Attendance check-in/check-out
* Payroll generation
* Departments management
* Notifications
* Documents management
* Overtime management
* Employee search and filtering
* Reporting dashboard
* Audit logs
* Unit and integration tests
* Docker support

---

## ⚠️ Current Development Note

The current version mainly stores application data using in-memory Java collections.

This means data created while running the application may be lost after the program is closed.

Database persistence can be introduced in a future version.

---

## 🤝 Contributing

Contributions and improvements are welcome.

Recommended workflow:

```bash
git checkout -b feature/my-feature
```

Make your changes:

```bash
git add .
git commit -m "feat: add new feature"
```

Push the branch:

```bash
git push origin feature/my-feature
```

Then create a Pull Request.

---

## 📝 Commit Convention

Recommended commit message format:

```text
feat(server): add employee login
fix(server): fix leave approval logic
chore(project): update dependencies
docs(project): update README documentation
```

---

## 📌 Repository

**AppNexora**

GitHub:

```text
https://github.com/engSulaimanMohammed/AppNexora
```

---

## 📄 License

No license has currently been specified for this repository.

---

<div align="center">

# AppNexora

### Smart Enterprise & Human Resources Management

**Built with Java ☕**

</div>
