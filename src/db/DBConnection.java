package db;
import javax.swing.*;
import java.sql.*;

public class DBConnection {

    private static DBConnection instance;
    private Connection connection;
    private String url;
    private String user;
    private String password;
    private DBConnection() {
        url = "jdbc:mysql://124.221.138.245:3306/train_student";
        user = "train";
        password = "train20231230";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据库连接失败");
        }
    }
    public static synchronized DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
    public Connection getConnection() {
        return connection;
    }
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
