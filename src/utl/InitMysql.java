//package utl;
//import java.sql.*;
//
//public class InitMysql {
//    private static final String URL = "jdbc:mysql://124.221.138.245:3306/train_student?useSSL=false";
//    private static final String USERNAME = "train";
//    private static final String PASSWORD = "train20231230";
//
//    public ResultSet executeQuery(String sql, String username, String password) {
//        ResultSet resultSet = null;
//        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setString(1, username);
//            stmt.setString(2, password);
//
//            resultSet = stmt.executeQuery();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return resultSet;
//    }
//
//
//
//
//
//
////    public static void main(String[] args) throws ClassNotFoundException, SQLException{
////        Class.forName("com.mysql.cj.jdbc.Driver");
////
////        String url = "jdbc:mysql://124.221.138.245:3306/train_student";
////
//////        作业账号
////        String username = "train";
////        String password = "train20231230";
////
////        Connection connection = DriverManager.getConnection(url, username, password);
////
////        Statement statement = connection.createStatement();
////
////        String sql = "SELECT * FROM user";
////
////        ResultSet resultSet = statement.executeQuery(sql);
////
////        while (resultSet.next()){
//////            System.out.println("id = " + resultSet.getObject("id"));
//////            System.out.println("name = " + resultSet.getObject("name"));
//////            System.out.println("pwd = " + resultSet.getObject("pwd"));
////            System.out.println("成功连接到数据库");
////        }
////
////        resultSet.close();
////        statement.close();
////        connection.close();
////    }
//}
