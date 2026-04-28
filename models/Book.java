/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author aya
 */
public class Book {
    private int bookId;
    private String title;
    private String genre;
    private int totalCopies;
    private int availableCopies;

    
    public Book() {}

    public Book(String title,String genre,
            int totalCopies, int availableCopies) {
        this.title           = title;
        this.genre           = genre;
        this.totalCopies     = totalCopies;
        this.availableCopies = availableCopies;
    }

    public Book(int bookId, String title,
                String genre, int totalCopies, int availableCopies) {
        this.bookId          = bookId;
        this.title           = title;
        this.genre           = genre;
        this.totalCopies     = totalCopies;
        this.availableCopies = availableCopies;
    }


    public int getBookId()                        { return bookId; }
    public void setBookId(int bookId)             { this.bookId = bookId; }

    public String getTitle()                      { return title; }
    public void setTitle(String title)            { this.title = title; }

    public String getGenre()                      { return genre; }
    public void setGenre(String genre)            { this.genre = genre; }

    public int getTotalCopies()                   { return totalCopies; }
    public void setTotalCopies(int totalCopies)   { this.totalCopies = totalCopies; }

    public int getAvailableCopies()               { return availableCopies; }
    public void setAvailableCopies(int n)         { this.availableCopies = n; }


    @Override
    public String toString() {
        return "Book{" +
               "bookId="           + bookId          +
               ", title='"         + title           + '\'' +
               ", genre='"         + genre           + '\'' +
               ", totalCopies="    + totalCopies     +
               ", availableCopies="+ availableCopies +
               "}\n";
    }
    
}
