package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection instance;
    private static Connection conn ;
    private DBConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localHost:3306/library-system";
            conn = DriverManager.getConnection(url, "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            System.getLogger(DBConnection.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }
    
    public static DBConnection getInstance(){
        if(instance == null)
            instance =new DBConnection();
        return instance;
    }
    
    public Connection getConnection(){
        return conn;
    }
    
}
