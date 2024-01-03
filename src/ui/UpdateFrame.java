// UpdateFrame.java
package ui;

import db.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateFrame extends JFrame {
    private JLabel idLabel;
    private JTextField idField;
    private JButton searchButton;

    public UpdateFrame() {
        setTitle("修改|成绩管理系统");
        setSize(360, 220);
        setLocationRelativeTo(null);
        setResizable(false);

        idLabel = new JLabel("要修改的id:");
        idField = new JTextField(10);
        searchButton = new JButton("查找");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
//                String url = "";
//                String user = "";
//                String password = "";

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
//                    Connection connection = DriverManager.getConnection(url, user, password);
                    Connection connection = DBConnection.getInstance().getConnection();
                    String sql = "SELECT * FROM grade WHERE id = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        toUpdateFrame updateFrame = new toUpdateFrame();
                        updateFrame.fillData(resultSet);
                        updateFrame.setVisible(true);
                    } else {
//                        JOptionPane.showMessageDialog(this, "未找到相关信息");
                    }
                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    // JOptionPane.showMessageDialog(this, "删除失败");
                }
            }
        });

        setLayout(new FlowLayout());
        add(idLabel);
        add(idField);
        add(searchButton);
    }
}
