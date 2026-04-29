/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.DBConnection;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author aya
 */
public class BookDAO {
    public List<Integer> findAllBooksId(){
        List<Integer> booksIds = new ArrayList<>();
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            Statement stat = conn.createStatement();
            String sql = "SELECT book_id FROM books";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                
                int bookId = rs.getInt(1);
                booksIds.add(bookId);
            }
        } catch (SQLException ex) {
            System.getLogger(BookDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return booksIds;
    }
    
    
   
    
}
