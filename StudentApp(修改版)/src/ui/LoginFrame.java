package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginFrame extends JFrame {

    private JTextField userField;
    private JPasswordField pwdField;
    private JLabel userLabel;
    private JLabel pwdLabel;
    private JButton loginBtn;
    private JButton resetBtn;
    private JButton registerBtn;
    private String URL = "jdbc:mysql://47.115.203.103:3306/train_student";
    private String USERNAME = "train";
    private String PASSWORD = "20240103";

    public LoginFrame() {
        setTitle("登陆|成绩管理系统");

        setSize(300, 188);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userLabel = new JLabel("用户名：");
        pwdLabel = new JLabel("密码：");
        userField = new JTextField(20);
        pwdField = new JPasswordField(20);
        loginBtn = new JButton("登录");
        resetBtn = new JButton("重置");
        registerBtn = new JButton("注册");

        userLabel.setBounds(10,35,80,25);
        pwdLabel.setBounds(10,65,80,25);
        userField.setBounds(100,35,165,25);
        pwdField.setBounds(100,65,165,25);
        loginBtn.setBounds(10,100,80,25);
        resetBtn.setBounds(105,100,60,25);
        registerBtn.setBounds(180,100,80,25);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        panel.add(userLabel);
        panel.add(pwdLabel);
        panel.add(userField);
        panel.add(pwdField);
        panel.add(loginBtn);
        panel.add(resetBtn);
        panel.add(registerBtn);

        add(panel);

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userField.getText();
                String pwd = new String(pwdField.getPassword());
                String sql = "SELECT * FROM user WHERE name = ? AND pwd = ?";

                ResultSet resultSet = null;
                try (
                        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, user);
                    stmt.setString(2, pwd);
                    resultSet = stmt.executeQuery();
                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(null, "登录成功");
                        new HomeFrame().setVisible(true);
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "登录失败");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        if (resultSet != null) {
                            resultSet.close();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }





}
