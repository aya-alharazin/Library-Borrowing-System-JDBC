package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection instance;
    private static final String URL = "jdbc:mysql://localhost:3306/library-system";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Connection conn;

    private DBConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.getLogger(DBConnection.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }
    
    public static DBConnection getInstance(){
        if(instance == null)
            instance =new DBConnection();
        return instance;
    }
    
    public synchronized Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            }
            return conn;
        } catch (SQLException ex) {
            System.getLogger(DBConnection.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            throw new IllegalStateException("Unable to connect to database", ex);
        }
    }
    
}
