package ui;

import db.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DeleteFrame extends JFrame {
    private JLabel idLabel;
    private JTextField idField;
    private JButton deleteButton;

    public DeleteFrame() {
        setTitle("删除|成绩管理系统");
        setSize(360, 220);
        setLocationRelativeTo(null);
        setResizable(false);

        idLabel = new JLabel("要删除的id:");
        idField = new JTextField(10);
        deleteButton = new JButton("删除");

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                deleteDataById(id);
            }
        });

        setLayout(new FlowLayout());
        add(idLabel);
        add(idField);
        add(deleteButton);
    }

    private void deleteDataById(int id) {
//        String url = "";
//        String user = "";
//        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection connection = DriverManager.getConnection(url, user, password);
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "DELETE FROM grade WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "删除成功");
            } else {
                JOptionPane.showMessageDialog(this, "找不到对象");
            }
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "删除失败");
        }
    }
}
