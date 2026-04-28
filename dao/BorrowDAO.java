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
import models.Borrow;

/**
 *
 * @author aya
 */
public class BorrowDAO {
    public List<Borrow> findAll(){
        Connection conn = DBConnection.getInstance().getConnection();
        List<Borrow> borrows = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            String sql = "SELECT * FROM borrows";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                
                int borrowId = rs.getInt(1);
                int studentId = rs.getInt(2);
                int bookId = rs.getInt(3);
                String borrowDate = rs.getString(4);
                boolean status = rs.getBoolean(5);
                
                Borrow b =new Borrow(borrowId, studentId, bookId, borrowDate, borrowDate, status);
                borrows.add(b);
            }
        } catch (SQLException ex) {
            System.getLogger(BookDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return borrows;
    }
}
