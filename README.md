# 📚 Library Management System
> A JavaFX + JDBC desktop application for managing library book borrowing operations

![Java](https://img.shields.io/badge/Java-17%2B-orange?style=flat-square&logo=java)
![JavaFX](https://img.shields.io/badge/JavaFX-21-blue?style=flat-square)
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?style=flat-square&logo=mysql)
![JDBC](https://img.shields.io/badge/JDBC-Driver-green?style=flat-square)
![License](https://img.shields.io/badge/License-MIT-yellow?style=flat-square)

---

## 📖 Description

The **Library Management System** is a desktop application built with **JavaFX** and **JDBC** that demonstrates real-world database interaction through a clean, modern dark-themed UI. It manages the core library workflow — students borrowing and returning books — using a proper **Many-to-Many** relational database design.

This project was designed as a **teaching tool** for JDBC concepts, covering everything from basic CRUD operations to transactions, JOIN queries, and the DAO design pattern.

---

## ✨ Features

- 📖 **Borrow a Book** — creates a borrow record and decreases available copies (uses DB Transaction)
- 🔄 **Return a Book** — marks borrow as returned and restores available copies (uses DB Transaction)
- 🗑️ **Delete a Borrow** — removes a borrow record from the database
- 👁️ **View Record** — fetch a specific borrow by Book ID and Student ID
- 📋 **All Borrowed Books** — JOIN query showing all currently borrowed books with student info
- 🎓 **All Students Borrowing** — shows all students with active borrows
- 🔍 **Search by Genre** — filter borrow records by book genre
- 🔎 **Search by IDs** — find borrow records using Book ID + Student ID

---

## 🗂️ Project Structure

```
LibraryManagementSystem/
│
├── src/
│   ├── model/
│   │   ├── Book.java            # Book entity
│   │   ├── Student.java         # Student entity
│   │   └── Borrow.java          # Borrow junction entity
│   │
│   ├── dao/
│   │   ├── BookDAO.java         # CRUD operations for Book
│   │   ├── StudentDAO.java      # CRUD operations for Student
│   │   └── BorrowDAO.java       # Borrow logic + Transactions + JOINs
│   │
│   ├── ui/
│   │   ├── BorrowForm.fxml      # Main borrow management UI
│   │   ├── BorrowForm.css       # Dark theme stylesheet
│   │   └── BorrowController.java# UI logic and event handling
│   │
│   ├── util/
│   │   └── DBConnection.java    # Singleton DB connection utility
│   │
│   └── Main.java                # Application entry point
│
├── database/
│   └── library_db.sql           # Database schema + sample data
│
└── README.md
```

---

## 🗃️ Database Schema

```sql
-- Students table
CREATE TABLE student (
    student_id     INT PRIMARY KEY AUTO_INCREMENT,
    name           VARCHAR(100) NOT NULL,
    email          VARCHAR(100) UNIQUE,
    phone          VARCHAR(15),
    enrollment_date DATE
);

-- Books table
CREATE TABLE book (
    book_id          INT PRIMARY KEY AUTO_INCREMENT,
    title            VARCHAR(200) NOT NULL,
    author           VARCHAR(100),
    isbn             VARCHAR(20) UNIQUE,
    genre            VARCHAR(50),
    total_copies     INT DEFAULT 1,
    available_copies INT DEFAULT 1
);

-- Borrow table (M-N junction)
CREATE TABLE borrow (
    borrow_id   INT PRIMARY KEY AUTO_INCREMENT,
    student_id  INT NOT NULL,
    book_id     INT NOT NULL,
    borrow_date DATE NOT NULL,
    return_date DATE,
    status      ENUM('BORROWED', 'RETURNED', 'OVERDUE') DEFAULT 'BORROWED',
    FOREIGN KEY (student_id) REFERENCES student(student_id),
    FOREIGN KEY (book_id)    REFERENCES book(book_id)
);
```

### Entity Relationship

```
Student ──────────< Borrow >────────── Book
(1 student borrows many books)   (1 book borrowed by many students)
```

---

## ⚙️ JDBC Concepts Covered

| Concept | Where Used |
|--------|-----------|
| `Connection` | `DBConnection.java` — connects to MySQL |
| `PreparedStatement` | All DAO insert/update/delete operations |
| `ResultSet` | Reading data and populating the TableView |
| `Transactions` | Borrow & Return operations (atomic) |
| `JOIN Queries` | All Borrowed Books, All Students Borrowing |
| `SQLException` | Try-catch error handling in all DAOs |
| DAO Pattern | `BookDAO`, `StudentDAO`, `BorrowDAO` |

---

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- JavaFX 21 SDK
- MySQL 8.0
- MySQL JDBC Driver (`mysql-connector-j-8.x.jar`)
- IDE: IntelliJ IDEA or Eclipse

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/library-management-system.git
cd library-management-system
```

### 2. Set Up the Database

```bash
mysql -u root -p
source database/library_db.sql
```

### 3. Configure DB Connection

Edit `src/util/DBConnection.java`:

```java
private static final String URL      = "jdbc:mysql://localhost:3306/library_db";
private static final String USER     = "root";
private static final String PASSWORD = "your_password";
```

### 4. Add JDBC Driver

Add `mysql-connector-j-8.x.jar` to your project's classpath/libraries.

### 5. Run the Application

Run `Main.java` from your IDE.

---

## 🔄 Core Business Logic

### Borrow a Book (Transaction)
```
1. Check available_copies > 0
2. Check student doesn't already have this book
3. INSERT into borrow table
4. UPDATE book SET available_copies = available_copies - 1
5. COMMIT — or ROLLBACK if any step fails
```

### Return a Book (Transaction)
```
1. Find open borrow record (status = BORROWED)
2. UPDATE borrow SET return_date = today, status = RETURNED
3. UPDATE book SET available_copies = available_copies + 1
4. COMMIT — or ROLLBACK if any step fails
```

---

## 🎨 UI Design

- **Framework:** JavaFX with FXML (Scene Builder compatible)
- **Theme:** Dark Navy (`#0f172a`) with Blue accent (`#3b82f6`)
- **Layout:** Split-pane — Form panel (left) + TableView (right)
- **Styling:** External CSS file (`BorrowForm.css`)

---

## 📋 Status Indicators

| Status | Meaning |
|--------|---------|
| 🔵 `BORROWED` | Book is currently with the student |
| 🟢 `RETURNED` | Book has been returned |
| 🟡 `OVERDUE` | Return date passed, not yet returned |

---

## 👨‍🏫 Educational Purpose

This project was developed as a **JDBC teaching example** covering:

- Relational DB design with M-N relationships
- Java Model classes (POJO)
- DAO design pattern
- JDBC CRUD operations
- Database Transactions
- JOIN queries with ResultSet
- JavaFX + FXML UI integration

---

## 📄 License

This project is licensed under the MIT License — feel free to use it for educational purposes.

---

> Built with ❤️ for JDBC students — Learn by building something real.
