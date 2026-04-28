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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Borrow;

/**
 *
 * @author aya
 */
public class BorrowDAO {
   
    public List<Borrow> findAll() {

        List<Borrow> borrows = new ArrayList<>();
        String sql = "SELECT * FROM borrow";

        Connection conn = DBConnection.getInstance().getConnection();
             Statement stat;
        try {
            stat = conn.createStatement();
        
             ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {

                int borrowId = rs.getInt("borrow_id");
                int studentId = rs.getInt("student_id");
                int bookId = rs.getInt("book_id");

                LocalDate borrowDate = rs.getDate("borrow_date").toLocalDate();

                java.sql.Date sqlReturn = rs.getDate("return_date");
                LocalDate returnDate = (sqlReturn != null)
                        ? sqlReturn.toLocalDate()
                        : null;

                boolean status = rs.getBoolean("status");

                Borrow b = new Borrow(
                        borrowId,
                        studentId,
                        bookId,
                        borrowDate,
                        returnDate,
                        status
                );

                borrows.add(b);
            }
            } catch (SQLException ex) {
            System.getLogger(BorrowDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }


        return borrows;
}
    
}
