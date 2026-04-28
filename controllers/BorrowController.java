/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.net.URL;
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

/**
 * FXML Controller class
 *
 * @author aya
 */
public class BorrowController implements Initializable {

    @FXML
    private ComboBox<?> booksCombobox;
    @FXML
    private ComboBox<?> studentsCombobox;
    @FXML
    private DatePicker borrowDate;
    @FXML
    private DatePicker returnDate;
    @FXML
    private ComboBox<?> genre;
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
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> borrowIdTC;
    @FXML
    private TableColumn<?, ?> bookIdTC;
    @FXML
    private TableColumn<?, ?> studentIdTC;
    @FXML
    private TableColumn<?, ?> borrowDateTC;
    @FXML
    private TableColumn<?, ?> returnDateTC;
    @FXML
    private TableColumn<?, ?> statusTC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void viewHandle(ActionEvent event) {
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
