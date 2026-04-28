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

/**
 *
 * @author aya
 */
public class StudentDAO {
    public List<Integer> findAllStudentsIds(){
        Connection conn = DBConnection.getInstance().getConnection();
        List<Integer> studentsids = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            String sql = "SELECT student_id FROM students";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                
                int studentId = rs.getInt(1);
                studentsids.add(studentId);
            }
        } catch (SQLException ex) {
            System.getLogger(BookDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        
        return studentsids;
    }
}
