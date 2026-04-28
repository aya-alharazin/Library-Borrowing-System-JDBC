# Library Management System (JavaFX)

This project is a desktop **Library Management System** built with **JavaFX** and **MySQL**.  
It focuses on managing the borrow/return workflow between students and books.

## Description

The application allows you to:
- Load and display all borrow records in a table.
- Add a new borrow transaction (student, book, borrow date).
- Return a borrowed book by setting return date and status.
- Delete a borrow record.
- Show only currently borrowed books.
- Search borrow records by student ID and book ID.

The UI is implemented with FXML, and database operations are handled through DAO classes.

## Project Structure

- `app/Main.java` - JavaFX application entry point.
- `views/Borrow.fxml` - Main UI layout.
- `controllers/BorrowController.java` - UI logic and event handlers.
- `dao/` - Data access layer (`BorrowDAO`, `BookDAO`, `StudentDAO`).
- `models/` - Domain models (`Borrow`, `Book`, `Student`).
- `config/DBConnection.java` - Singleton database connection manager.
- `styles/BorrowFormStyle.css` - UI styling.

## Tech Stack

- Java
- JavaFX
- MySQL
- JDBC
- Apache Ant (NetBeans project)

## Database Requirements

Default connection configuration is in `config/DBConnection.java`:
- URL: `jdbc:mysql://localhost:3306/library-system`
- User: `root`
- Password: `` (empty)

Make sure the database `library-system` exists and includes the required tables used by the DAOs:
- `books`
- `students`
- `borrow`

## How to Run

### From NetBeans
1. Open the project.
2. Ensure JavaFX SDK and MySQL JDBC driver are configured.
3. Run `app/Main.java`.

### With Ant
Use a command like:

```bash
ant -f C:\\Users\\aya\\Documents\\NetBeansProjects\\week9 -Dnb.internal.action.name=run.single -Djavac.includes=app/Main.java -Drun.class=app.Main run-single
```

## JavaFX Warning Note

If you see:

`WARNING: Use --enable-native-access=javafx.graphics`

it is a JavaFX runtime warning on newer Java versions.  
You can suppress it by adding this VM option:

`--enable-native-access=javafx.graphics`

## Notes

- The database connection is implemented using the Singleton pattern.
- The table view refreshes with `setAll(...)` to avoid duplicate rows on repeated view actions.
