/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import dao.BookDAO;
import dao.BorrowDAO;
import dao.StudentDAO;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Borrow;

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
    private CheckBox status;
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

    private void showInfoAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showWarningAlert(String title, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private boolean showConfirmationAlert(String title, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }
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
        
        
        
        
        
        
        table.getSelectionModel().selectedItemProperty().addListener(
    (observable, oldValue, newValue) -> {
         if (newValue == null) {
            return;
        }
        booksCombobox.setValue(newValue.getBookId());
        studentsCombobox.setValue(newValue.getStudentId());
        borrowDate.setValue(LocalDate.parse(newValue.getBorrowDate()));
        String rd = newValue.getReturnDate();
        if(rd!=null)
            returnDate.setValue(LocalDate.parse(rd));
        else
            returnDate.setValue(null);
        status.setSelected(newValue.getStatus()); 
        
    }
);
        
    }    

    @FXML
    private void viewHandle(ActionEvent event) {
        // Replace current rows with fresh DB results on each click.
        table.getItems().setAll(borrowDAO.findAll());
    }

    @FXML
    private void borrowHandle(ActionEvent event) {
        if(borrowValidator()){
        Integer bookId = booksCombobox.getSelectionModel().getSelectedItem();
        Integer StudentId = studentsCombobox.getSelectionModel().getSelectedItem();
        String bd = borrowDate.getValue().toString();
        Borrow borrow = new Borrow(StudentId, bookId, bd);
        borrowDAO.insertOne(borrow);
        viewHandle(event);
        clear();
        showInfoAlert("Success", "Book borrowed successfully!");
        }else{
            showWarningAlert(
                    "Invalid Input",
                    "Missing Data",
                    "Please select both student and book and borrow date!"
            );
        }
    }

    @FXML
    private void returnHandle(ActionEvent event) {
        
        Borrow b = table.getSelectionModel().getSelectedItem();
        if(b != null){
            b.setReturnDate(returnDate.getValue().toString());
            b.setStatus(status.isSelected());
            borrowDAO.updateOne(b);
            viewHandle(event);
        }else{
            showWarningAlert(
                    "No Selection",
                    "No Record Selected",
                    "Please select a borrow record from the table."
            );
        }
        
        
        
        
    }

    @FXML
    private void deleteHandle(ActionEvent event) {
        Borrow b = table.getSelectionModel().getSelectedItem();
        if(b != null){
            if (showConfirmationAlert(
                    "Delete Confirmation",
                    "Are you sure?",
                    "Do you want to delete this borrow record?"
            )) {
                borrowDAO.deleteOne(b);
                viewHandle(event);
            } else {
                // user cancelled
                System.out.println("Delete cancelled");
            }
            
        }else{
            showWarningAlert(
                    "No Selection",
                    "No Record Selected",
                    "Please select a borrow record from the table."
            );
        }
    }

    @FXML
    private void borrowedBooksHandle(ActionEvent event) {
        List<Borrow> borrows = borrowDAO.findBorrowedBooks();
        table.getItems().setAll(borrows);
    }


    
    public void clear(){
        booksCombobox.getItems().clear();
        studentsCombobox.getItems().clear();
        borrowDate.setValue(null);
        returnDate.setValue(null);
        status.setSelected(false);
    }

    @FXML
    private void searchbyIds(ActionEvent event) {
        if(booksCombobox.getValue() == null || studentsCombobox.getValue()==null){
            showWarningAlert(
                    "Invalid Input",
                    "Missing Data",
                    "Please select both student and book and borrow date!"
            );
            return;
        }
        Integer stdId = studentsCombobox.getValue();
        Integer bookId = booksCombobox.getValue();
        List<Borrow> borrows = borrowDAO.searchByIds(stdId,bookId);
        table.getItems().setAll(borrows);
    }
    
    public boolean borrowValidator(){
        if(booksCombobox.getValue() == null || studentsCombobox.getValue() == null
                ||borrowDate.getValue() == null){
            return false;
        }
        return true;
    }

   
    
}
