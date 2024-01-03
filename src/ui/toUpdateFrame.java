package ui;

import db.DBConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class toUpdateFrame extends JFrame {

    private JLabel snoLabel;
    private JLabel nameLabel;
    private JLabel sexLabel;
    private JLabel classLabel;
    private JLabel Label1;
    private JLabel Label2;
    private JLabel Label3;
    private JLabel Label4;
    private JLabel Label5;
    private JLabel Label6;
    private JLabel Label7;
    private JLabel Label8;
    private JLabel averageLabel;
    private JLabel gradeLabel;

    private JTextField snoField;
    private JTextField nameField;
    private JTextField sexField;
    private JTextField classField;
    private JTextField Field1;
    private JTextField Field2;
    private JTextField Field3;
    private JTextField Field4;
    private JTextField Field5;
    private JTextField Field6;
    private JTextField Field7;
    private JTextField Field8;
    private JTextField averageField;
    private JTextField gradeField;


    private JButton resetBtn;
    private JButton sureBtn;

    public toUpdateFrame() {
        setTitle("添加|成绩管理系统");
        setSize(300, 500);
        setLocationRelativeTo(null);
        setResizable(false);


        snoLabel = new JLabel("学号：");
        nameLabel = new JLabel("名字：");
        sexLabel = new JLabel("性别：");
        classLabel = new JLabel("班级：");
        Label1 = new JLabel("修读课程：");
        Label2 = new JLabel("未通过课程：");
        Label3 = new JLabel("修读学分：");
        Label4 = new JLabel("获得学分：");
        Label5 = new JLabel("绩点：");
        Label6 = new JLabel("学分绩点：");
        Label7 = new JLabel("平均学分绩点：");
        Label8 = new JLabel("加权平均成绩：");
        averageLabel = new JLabel("平均成绩：");
        gradeLabel = new JLabel("总成绩：");

        snoField = new JTextField(20);
        nameField = new JTextField(20);
        sexField = new JTextField(20);
        classField = new JTextField(20);
        Field1 = new JTextField(20);
        Field2 = new JTextField(20);
        Field3 = new JTextField(20);
        Field4 = new JTextField(20);
        Field5 = new JTextField(20);
        Field6 = new JTextField(20);
        Field7 = new JTextField(20);
        Field8 = new JTextField(20);
        averageField = new JTextField(20);
        gradeField = new JTextField(20);

        resetBtn = new JButton("重置");
        sureBtn = new JButton("修改");


        snoLabel.setBounds(10, 5, 80, 25);
        nameLabel.setBounds(10, 35, 80, 25);
        sexLabel.setBounds(10, 65, 80, 25);
        classLabel.setBounds(10, 95, 80, 25);
        Label1.setBounds(10, 125, 80, 25);
        Label2.setBounds(10, 155, 80, 25);
        Label3.setBounds(10, 185, 80, 25);
        Label4.setBounds(10, 215, 80, 25);
        Label5.setBounds(10, 245, 80, 25);
        Label6.setBounds(10, 275, 80, 25);
        Label7.setBounds(10, 305, 80, 25);
        Label8.setBounds(10, 335, 80, 25);
        averageLabel.setBounds(10, 365, 80, 25);
        gradeLabel.setBounds(10, 395, 80, 25);

        snoField.setBounds(100, 5, 165, 25);
        nameField.setBounds(100, 35, 165, 25);
        sexField.setBounds(100, 65, 165, 25);
        classField.setBounds(100, 95, 165, 25);
        Field1.setBounds(100, 125, 165, 25);
        Field2.setBounds(100, 155, 165, 25);
        Field3.setBounds(100, 185, 165, 25);
        Field4.setBounds(100, 215, 165, 25);
        Field5.setBounds(100, 245, 165, 25);
        Field6.setBounds(100, 275, 165, 25);
        Field7.setBounds(100, 305, 165, 25);
        Field8.setBounds(100, 335, 165, 25);
        averageField.setBounds(100, 365, 165, 25);
        gradeField.setBounds(100, 395, 165, 25);

        resetBtn.setBounds(105, 430, 60, 25);
        sureBtn.setBounds(180, 430, 80, 25);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        panel.add(snoLabel);
        panel.add(nameLabel);
        panel.add(sexLabel);
        panel.add(classLabel);
        panel.add(Label1);
        panel.add(Label2);
        panel.add(Label3);
        panel.add(Label4);
        panel.add(Label5);
        panel.add(Label6);
        panel.add(Label7);
        panel.add(Label8);
        panel.add(averageLabel);
        panel.add(gradeLabel);

        panel.add(snoField);
        panel.add(nameField);
        panel.add(sexField);
        panel.add(classField);
        panel.add(Field1);
        panel.add(Field2);
        panel.add(Field3);
        panel.add(Field4);
        panel.add(Field5);
        panel.add(Field6);
        panel.add(Field7);
        panel.add(Field8);
        panel.add(averageField);
        panel.add(gradeField);

        panel.add(resetBtn);
        panel.add(sureBtn);

        sureBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                addGradeToDatabase();
                updateDataInDatabase();
                setVisible(false);
            }
        });

        add(panel);
    }

    public void fillData(ResultSet resultSet) throws SQLException {
        snoField.setText(String.valueOf(resultSet.getInt("id")));
        nameField.setText(resultSet.getString("学号"));
        nameField.setText(resultSet.getString("名字"));
        sexField.setText(resultSet.getString("性别"));
        classField.setText(resultSet.getString("班级"));
        Field1.setText(resultSet.getString("修读课程"));
        Field2.setText(resultSet.getString("未通过课程"));
        Field3.setText(String.valueOf(resultSet.getDouble("修读学分")));
        Field4.setText(String.valueOf(resultSet.getDouble("获得学分")));
        Field5.setText(String.valueOf(resultSet.getDouble("绩点")));
        Field6.setText(String.valueOf(resultSet.getDouble("学分绩点")));
        Field7.setText(String.valueOf(resultSet.getDouble("平均学分绩点")));
        Field8.setText(String.valueOf(resultSet.getDouble("加权平均成绩")));
        averageField.setText(String.valueOf(resultSet.getDouble("平均成绩")));
        gradeField.setText(String.valueOf(resultSet.getDouble("总成绩")));
    }

    public void updateDataInDatabase() {

//        String url = "";
//        String user = "";
//        String password = "";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
//            connection = DriverManager.getConnection(url, user, password);
            connection = DBConnection.getInstance().getConnection();

            String sql = "UPDATE grade SET 名字 = ?, 性别 = ?, 班级 = ?, 修读课程 = ?, 未通过课程 = ?, 修读学分 = ?, 获得学分 = ?, 绩点 = ?, 学分绩点 = ?, 平均学分绩点 = ?,加权平均成绩 = ?,平均成绩 = ?,总成绩 = ? where 学号 = '" + snoField.getText() + "'";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, nameField.getText());
            preparedStatement.setString(2, sexField.getText());
            preparedStatement.setString(3, classField.getText());
            preparedStatement.setString(4, Field1.getText());
            preparedStatement.setString(5, Field2.getText());
            preparedStatement.setString(6, Field3.getText());
            preparedStatement.setString(7, Field4.getText());
            preparedStatement.setString(8, Field5.getText());
            preparedStatement.setString(9, Field6.getText());
            preparedStatement.setString(10, Field7.getText());
            preparedStatement.setString(11, Field8.getText());
            preparedStatement.setString(12, averageField.getText());
            preparedStatement.setString(13, gradeField.getText());
//            preparedStatement.setString(14, snoField.getText());

            JOptionPane.showMessageDialog(this, "修改成功");
//            int rowsAffected = preparedStatement.executeUpdate();
//            if (rowsAffected > 0) {
///
//            } else {
//                JOptionPane.showMessageDialog(this, "修改失败");
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}