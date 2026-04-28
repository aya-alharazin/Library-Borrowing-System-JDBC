/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;


/**
 *
 * @author aya
 */
public class Borrow {

    private int     borrowId;
    private int     studentId;
    private int     bookId;
    private LocalDate  borrowDate;    // or LocalDate
    private LocalDate  returnDate;    // null until returned
    private boolean  status;

    // ─── Constructors ───────────────────────────────────────────

    public Borrow() {}

    

    public Borrow(int borrowId, int studentId, int bookId,
                  LocalDate borrowDate, LocalDate returnDate, boolean status) {
        this.borrowId   = borrowId;
        this.studentId  = studentId;
        this.bookId     = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status     = status;
    }

    // ─── Getters & Setters ──────────────────────────────────────

    public int getBorrowId()                      { return borrowId; }
    public void setBorrowId(int borrowId)         { this.borrowId = borrowId; }

    public int getStudentId()                     { return studentId; }
    public void setStudentId(int studentId)       { this.studentId = studentId; }

    public int getBookId()                        { return bookId; }
    public void setBookId(int bookId)             { this.bookId = bookId; }

    public LocalDate getBorrowDate()                 { return borrowDate; }
    public void setBorrowDate(LocalDate borrowDate)  { this.borrowDate = borrowDate; }

    public LocalDate getReturnDate()                 { return returnDate; }
    public void setReturnDate(LocalDate returnDate)  { this.returnDate = returnDate; }

    public boolean getStatus()                     { return status; }
    public void setStatus(boolean status)          { this.status = status; }

    // ─── toString ───────────────────────────────────────────────

    @Override
    public String toString() {
        return "Borrow{" +
               "borrowId="    + borrowId   +
               ", studentId=" + studentId  +
               ", bookId="    + bookId     +
               ", borrowDate='"+ borrowDate + '\'' +
               ", returnDate='"+ returnDate + '\'' +
               ", status="    + status     +
               '}';
}
}