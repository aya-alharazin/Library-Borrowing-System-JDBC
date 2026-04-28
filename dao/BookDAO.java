/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.DBConnection;
import java.util.List;
import models.Book;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author aya
 */
public class BookDAO {
    public static List<Book> findAllBooks(){
        Connection conn = DBConnection.getInstance().getConnection();
        try {
            Statement stat = conn.createStatement();
            String sql = "SELECT * FROM books";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                Book book = new Book();
                int bookId = rs.getInt(1);
                String title = rs.getString(2);
                String genre =rs.getString(3);
                Integer totalCopies=rs.getInt(4);
                
                
                
            }
        } catch (SQLException ex) {
            System.getLogger(BookDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        
        
        
        
        
        
    }
}
