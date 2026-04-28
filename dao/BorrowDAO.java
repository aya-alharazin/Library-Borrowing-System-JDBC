/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Borrow;
import java.sql.PreparedStatement;
import java.time.LocalDate;

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
            String sql = "SELECT * FROM borrow";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                
                int borrowId = rs.getInt(1);
                int studentId = rs.getInt(2);
                int bookId = rs.getInt(3);
                String borrowDate = rs.getString(4);
                String returnDate = rs.getString(5);
                boolean status = rs.getBoolean(6);
                
                Borrow b =new Borrow(borrowId, studentId, bookId, borrowDate, returnDate, status);
                borrows.add(b);
            }
        } catch (SQLException ex) {
            System.getLogger(BookDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return borrows;
    }
    
    
    public boolean insertOne(Borrow borrow){
        Connection conn = DBConnection.getInstance().getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO borrow(student_id,book_id,borrow_date,return_date,status)"
                    + " VALUES(?,?,?,?,?)");
            ps.setInt(1, borrow.getStudentId());
            ps.setInt(2, borrow.getBookId());
            ps.setString(3, borrow.getBorrowDate());
            ps.setString(4, borrow.getReturnDate());
            ps.setBoolean(5, borrow.getStatus());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.getLogger(BorrowDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            
        }
        
        return false;
    }
    
    
    public boolean updateOne(Borrow borrow){
        String sql = "UPDATE borrow SET return_date = ?, status = ? WHERE borrow_id = ?";
        try{
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setDate(1, Date.valueOf(borrow.getReturnDate()));
        
        ps.setBoolean(2, borrow.getStatus());

        ps.setInt(3, borrow.getBorrowId());

        // execute
        int rows = ps.executeUpdate();

        return rows > 0;

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return false;
        
        
        
    }
    
    
    
}
