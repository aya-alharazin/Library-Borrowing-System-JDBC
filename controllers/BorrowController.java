/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import dao.BookDAO;
import dao.BorrowDAO;
import dao.StudentDAO;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Book;
import models.Borrow;
import models.Student;

/**
 * FXML Controller class
 *
 * @author aya
 */
public class BorrowController implements Initializable {

    @FXML
    private ComboBox<Integer> booksCombobox;
    @FXML
    private ComboBox<Integer> studentsCombobox;
    @FXML
    private DatePicker borrowDate;
    @FXML
    private DatePicker returnDate;
    @FXML
    private ComboBox<String> genre;
    @FXML
    private CheckBox status;
    @FXML
    private Button viewbtn;
    @FXML
    private Button borrowbtn;
    @FXML
    private Button returnbtn;
    @FXML
    private Button deletebtn;
    @FXML
    private Button borrowedBooks;
    @FXML
    private Button borrowingStudentsbtn;
    @FXML
    private Button searchbyGenrebtn;
    @FXML
    private Button searchbyIdbtn;
    @FXML
    private TableView<Borrow> table;
    @FXML
    private TableColumn<Borrow, Integer> borrowIdTC;
    @FXML
    private TableColumn<Borrow, Integer> bookIdTC;
    @FXML
    private TableColumn<Borrow, Integer> studentIdTC;
    @FXML
    private TableColumn<Borrow, String> borrowDateTC;
    @FXML
    private TableColumn<Borrow, String> returnDateTC;
    @FXML
    private TableColumn<Borrow, Boolean> statusTC;
    BookDAO bookDAO =new BookDAO();
    StudentDAO studentDAO = new StudentDAO();
    BorrowDAO borrowDAO = new BorrowDAO();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        borrowIdTC.setCellValueFactory(new PropertyValueFactory<>("borrowId"));
        bookIdTC.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        studentIdTC.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        borrowDateTC.setCellValueFactory(new PropertyValueFactory<>("borrowDate"));
        returnDateTC.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));
        List<Integer> booksIds  = bookDAO.findAllBooksId();
        List<Integer> studentIds  = studentDAO.findAllStudentsIds();
        booksIds.stream().
                forEach(id->booksCombobox.getItems().add(id));
        studentIds.stream()
                .forEach(id->studentsCombobox.getItems().add(id));
        
        List<String> genres = bookDAO.getDistinctGenres();
        genres.stream().forEach(genere->genre.getItems().add(genere));
    }    

    @FXML
    private void viewHandle(ActionEvent event) {
        table.getItems().addAll(borrowDAO.findAll());
    }

    @FXML
    private void borrowHandle(ActionEvent event) {
    }

    @FXML
    private void returnHandle(ActionEvent event) {
    }

    @FXML
    private void deleteHandle(ActionEvent event) {
    }

    @FXML
    private void borrowedBooksHandle(ActionEvent event) {
    }

    @FXML
    private void borrowingStudentsHandle(ActionEvent event) {
    }

    @FXML
    private void searchbyGenreHandle(ActionEvent event) {
    }

    @FXML
    private void searchbyIdHandle(ActionEvent event) {
    }
    
}
