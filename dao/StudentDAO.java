/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Book;

/**
 *
 * @author aya
 */
public class StudentDAO {
    public static List<Book> findAllStudents(){
        Connection conn = DBConnection.getInstance().getConnection();
        List<Book> books = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            String sql = "SELECT * FROM students";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                
                int studentId = rs.getInt(1);
                String name = rs.getString(2);
                Student book = new Student(studentId,name);
                books.add(book);
            }
        } catch (SQLException ex) {
            System.getLogger(BookDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        
        return books;
        
        
        
        
    }
}
