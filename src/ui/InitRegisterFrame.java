package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class InitRegisterFrame extends JFrame {
    private JTextField userField;
    private JPasswordField pwdField;
    private JPasswordField pwdField2;
    private JLabel userLabel;
    private JLabel pwdLabel;
    private JLabel pwdLabel2;
    private JButton resetBtn;
    private JButton registerBtn;

    public InitRegisterFrame() {
        setTitle("注册|成绩管理系统");

        userLabel = new JLabel("用户名：");
        pwdLabel = new JLabel("密码：");
        pwdLabel2 = new JLabel("确认密码：");
        userField = new JTextField(20);
        pwdField = new JPasswordField(20);
        pwdField2 = new JPasswordField(20);
        resetBtn = new JButton("重置");
        registerBtn = new JButton("注册");

        pwdLabel2.setForeground(Color.WHITE);

        userLabel.setBounds(10,30,80,25);
        pwdLabel.setBounds(10,65,80,25);
        pwdLabel2.setBounds(10,100,80,25);
        userField.setBounds(70,30,165,25);
        pwdField.setBounds(70,65,165,25);
        pwdField2.setBounds(70,100,165,25);
        resetBtn.setBounds(75,135,60,25);
        registerBtn.setBounds(150,135,80,25);

        ImageIcon backGround=new ImageIcon("src/ui/0609.png");
        JLabel label=new JLabel(backGround);
        label.setSize(backGround.getIconWidth(),backGround.getIconHeight());

        JPanel panel = new JPanel();
        panel.setLayout(null);

        panel.add(userLabel);
        panel.add(pwdLabel);
        panel.add(pwdLabel2);
        panel.add(userField);
        panel.add(pwdField);
        panel.add(pwdField2);
        panel.add(resetBtn);
        panel.add(registerBtn);
        panel.add(label);

        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userField.setText("");
                pwdField.setText("");
                pwdField2.setText("");
                userField.requestFocus();
            }
        });

        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "t";
                String user = "";
                String pwd = "";

                String username = userField.getText();
                String password = new String(pwdField.getPassword());
                String confirmPassword = new String(pwdField2.getPassword());

                if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "要填完哦");
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "两次输入的密码不一样哦");
                    return;
                }

                Connection connection = null;
                PreparedStatement preparedStatement = null;

                try {
                    connection = DriverManager.getConnection(url, user, pwd);
                    String sql = "INSERT INTO user (name, pwd) VALUES (?, ?)";
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);

                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "注册成功");
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "注册失败");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        if (preparedStatement != null) {
                            preparedStatement.close();
                        }
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });


        add(panel);

        setSize(270, 220);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
