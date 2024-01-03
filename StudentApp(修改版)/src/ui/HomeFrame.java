

package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class HomeFrame extends JFrame{

    private String URL = "jdbc:mysql://47.115.203.103:3306/train_student";
    private String USERNAME = "train";
    private String PASSWORD = "20240103";
    private JPanel content_card;
    private CardLayout cardLayout;


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


    private DefaultTableModel model = new DefaultTableModel();

    public HomeFrame() {
        setTitle("主页|成绩管理系统");
        setSize(620, 520);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel addPanel = new JPanel();
        addPanel.setLayout(null);
        JLabel snoLabel = new JLabel("学号：");
        JLabel nameLabel = new JLabel("名字：");
        JLabel sexLabel = new JLabel("性别：");
        JLabel classLabel = new JLabel("班级：");
        JLabel Label1 = new JLabel("修读课程：");
        JLabel Label2 = new JLabel("未通过课程：");
        JLabel Label3 = new JLabel("修读学分：");
        JLabel Label4 = new JLabel("获得学分：");
        JLabel Label5 = new JLabel("绩点：");
        JLabel Label6 = new JLabel("学分绩点：");
        JLabel Label7 = new JLabel("平均学分绩点：");
        JLabel Label8 = new JLabel("加权平均成绩：");
        JLabel averageLabel = new JLabel("平均成绩：");
        JLabel gradeLabel = new JLabel("总成绩：");

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

        JButton resetBtn = new JButton("重置");
        JButton addBtn = new JButton("添加");

        snoLabel.setBounds(100,5,80,25);
        nameLabel.setBounds(100,35,80,25);
        sexLabel.setBounds(100,65,80,25);
        classLabel.setBounds(100,95,80,25);
        Label1.setBounds(100,125,80,25);
        Label2.setBounds(100,155,80,25);
        Label3.setBounds(100,185,80,25);
        Label4.setBounds(100,215,80,25);
        Label5.setBounds(100,245,80,25);
        Label6.setBounds(100,275,80,25);
        Label7.setBounds(100,305,80,25);
        Label8.setBounds(100,335,80,25);
        averageLabel.setBounds(100,365,80,25);
        gradeLabel.setBounds(100,395,80,25);

        snoField.setBounds(200,5,165,25);
        nameField.setBounds(200,35,165,25);
        sexField.setBounds(200,65,165,25);
        classField.setBounds(200,95,165,25);
        Field1.setBounds(200,125,165,25);
        Field2.setBounds(200,155,165,25);
        Field3.setBounds(200,185,165,25);
        Field4.setBounds(200,215,165,25);
        Field5.setBounds(200,245,165,25);
        Field6.setBounds(200,275,165,25);
        Field7.setBounds(200,305,165,25);
        Field8.setBounds(200,335,165,25);
        averageField.setBounds(200,365,165,25);
        gradeField.setBounds(200,395,165,25);

        resetBtn.setBounds(205,430,60,25);
        addBtn.setBounds(280,430,80,25);

        addPanel.add(snoLabel);
        addPanel.add(nameLabel);
        addPanel.add(sexLabel);
        addPanel.add(classLabel);
        addPanel.add(Label1);
        addPanel.add(Label2);
        addPanel.add(Label3);
        addPanel.add(Label4);
        addPanel.add(Label5);
        addPanel.add(Label6);
        addPanel.add(Label7);
        addPanel.add(Label8);
        addPanel.add(averageLabel);
        addPanel.add(gradeLabel);

        addPanel.add(snoField);
        addPanel.add(nameField);
        addPanel.add(sexField);
        addPanel.add(classField);
        addPanel.add(Field1);
        addPanel.add(Field2);
        addPanel.add(Field3);
        addPanel.add(Field4);
        addPanel.add(Field5);
        addPanel.add(Field6);
        addPanel.add(Field7);
        addPanel.add(Field8);
        addPanel.add(averageField);
        addPanel.add(gradeField);

        addPanel.add(resetBtn);
        addPanel.add(addBtn);





        JPanel delPanel = new JPanel();
        JLabel idLabel01 = new JLabel("要删除的id:");
        JTextField idField = new JTextField(10);
        JButton deleteButton = new JButton("删除");
        delPanel.add(idLabel01);
        delPanel.add(idField);
        delPanel.add(deleteButton);

        JPanel updatePanel = new JPanel();
        JLabel idLabel02 = new JLabel("要更新的id:");
        JTextField idField02 = new JTextField(10);
        JButton searchButton2 = new JButton("查询");
        updatePanel.add(idLabel02);
        updatePanel.add(idField02);
        updatePanel.add(searchButton2);



        JPanel searchPanel = new JPanel();
        JPanel inputButtonPanel02 = new JPanel();
        JLabel idLabel03 = new JLabel("要查询的id:");
        inputButtonPanel02.setLayout(new FlowLayout());
        JTextField jTextField4 = new JTextField(10);
        jTextField4.setPreferredSize(new Dimension(200, 20));
        JButton searchByID = new JButton("查询");
        JButton searchAll = new JButton("查询全部");
        inputButtonPanel02.add(idLabel03);
        inputButtonPanel02.add(jTextField4);
        inputButtonPanel02.add(searchAll);
        inputButtonPanel02.add(searchByID);
        searchPanel.add(inputButtonPanel02);

        model.addColumn("id");
        model.addColumn("学号");
        model.addColumn("名字");
        model.addColumn("性别");
        model.addColumn("班级");
        model.addColumn("修读课程");
        model.addColumn("未通过课程");
        model.addColumn("修读学分");
        model.addColumn("获得学分");
        model.addColumn("绩点");
        model.addColumn("学分绩点");
        model.addColumn("平均学分绩点");
        model.addColumn("加权平均成绩");
        model.addColumn("平均成绩");
        model.addColumn("总成绩");




        JMenuBar menuBar = new JMenuBar();

        JMenu menuItem1 = new JMenu("新增");
        JMenu menuItem2 = new JMenu("删除");
        JMenu menuItem3 = new JMenu("修改");
        JMenu menuItem4 = new JMenu("查询");
        JMenu about = new JMenu("关于");

//        JMenuItem menuItem1 = new JMenuItem("新增");
//        JMenuItem menuItem2 = new JMenuItem("删除");
//        JMenuItem menuItem3 = new JMenuItem("修改");
//        JMenuItem menuItem4 = new JMenuItem("查询");
//
//        function.add(menuItem1);
//        function.add(menuItem2);
//        function.add(menuItem3);
//        function.add(menuItem4);

        menuBar.add(menuItem1);
        menuBar.add(menuItem2);
        menuBar.add(menuItem3);
        menuBar.add(menuItem4);
        menuBar.add(about);

        menuItem1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(content_card, "add");
            }
        });
        menuItem2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(content_card, "del");
            }
        });
        menuItem3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(content_card, "update");
            }
        });
        menuItem4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(content_card, "search");
            }
        });
        about.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(HomeFrame.this, "Author:Ganxy\nDate:2024/01/03");
            }
        });

        setJMenuBar(menuBar);


        content_card = new JPanel(new CardLayout());
        content_card.add(addPanel, "add");
        content_card.add(delPanel, "del");
        content_card.add(updatePanel, "update");
        content_card.add(searchPanel, "search");

        cardLayout = (CardLayout) content_card.getLayout();


        getContentPane().add(content_card);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addGradeToDatabase();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                deleteDataById(id);
            }
        });

        searchButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField02.getText());

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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


        searchAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "SELECT * FROM grade";
                ResultSet resultSet = null;
                try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
                    resultSet = stmt.executeQuery();

                    JPanel tablePanel = new JPanel();
                    tablePanel.setPreferredSize(new Dimension(searchPanel.getWidth(), 415));
                    tablePanel.setLayout(new BorderLayout());
                    searchPanel.add(tablePanel, BorderLayout.SOUTH);

                    model.setRowCount(0);

                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String 学号 = resultSet.getString("学号");
                        String 名字 = resultSet.getString("名字");
                        String 性别 = resultSet.getString("性别");
                        String 班级 = resultSet.getString("班级");
                        int 修读课程 = resultSet.getInt("修读课程");
                        int 未通过课程 = resultSet.getInt("未通过课程");
                        double 修读学分 = resultSet.getInt("修读学分");
                        double 获得学分 = resultSet.getInt("获得学分");
                        double 绩点 = resultSet.getInt("绩点");
                        double 学分绩点 = resultSet.getInt("学分绩点");
                        double 平均学分绩点 = resultSet.getInt("平均学分绩点");
                        double 加权平均成绩 = resultSet.getInt("加权平均成绩");
                        double 平均成绩 = resultSet.getInt("平均成绩");
                        double 总成绩 = resultSet.getInt("总成绩");
                        model.addRow(new Object[]{id, 学号, 名字, 性别, 班级, 修读课程, 未通过课程, 修读学分, 获得学分, 绩点, 学分绩点, 平均学分绩点, 加权平均成绩, 平均成绩, 总成绩});
                    }
                    JTable table = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(table);
                    tablePanel.add(scrollPane, BorderLayout.CENTER);

                    searchPanel.revalidate();
                    searchPanel.repaint();
                    JOptionPane.showMessageDialog(HomeFrame.this, "查询成功");
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

        searchByID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int searchID = Integer.parseInt(jTextField4.getText());
                String sql = "SELECT * FROM grade WHERE id = ?";
                ResultSet resultSet = null;
                try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, searchID);
                    resultSet = stmt.executeQuery();
                    JPanel tablePanel = new JPanel();
                    tablePanel.setPreferredSize(new Dimension(searchPanel.getWidth(), 415));
                    tablePanel.setLayout(new BorderLayout());
                    searchPanel.add(tablePanel, BorderLayout.SOUTH);

                    model.setRowCount(0);

                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String 学号 = resultSet.getString("学号");
                        String 名字 = resultSet.getString("名字");
                        String 性别 = resultSet.getString("性别");
                        String 班级 = resultSet.getString("班级");
                        int 修读课程 = resultSet.getInt("修读课程");
                        int 未通过课程 = resultSet.getInt("未通过课程");
                        double 修读学分 = resultSet.getInt("修读学分");
                        double 获得学分 = resultSet.getInt("获得学分");
                        double 绩点 = resultSet.getInt("绩点");
                        double 学分绩点 = resultSet.getInt("学分绩点");
                        double 平均学分绩点 = resultSet.getInt("平均学分绩点");
                        double 加权平均成绩 = resultSet.getInt("加权平均成绩");
                        double 平均成绩 = resultSet.getInt("平均成绩");
                        double 总成绩 = resultSet.getInt("总成绩");
                        model.addRow(new Object[]{id, 学号, 名字, 性别, 班级, 修读课程, 未通过课程, 修读学分, 获得学分, 绩点, 学分绩点, 平均学分绩点, 加权平均成绩, 平均成绩, 总成绩});
                    }
                    JTable table = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(table);
                    tablePanel.add(scrollPane, BorderLayout.CENTER);

                    searchPanel.revalidate();
                    searchPanel.repaint();
                    JOptionPane.showMessageDialog(HomeFrame.this, "查询成功");
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

    private void addGradeToDatabase() {

        try {

            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "INSERT INTO grade (学号, 名字, 性别, 班级, 修读课程, 未通过课程, 修读学分, 获得学分, 绩点, 学分绩点, 平均学分绩点, 加权平均成绩, 平均成绩, 总成绩) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            if (snoField.getText().isEmpty() || nameField.getText().isEmpty() || sexField.getText().isEmpty() || classField.getText().isEmpty() || Field1.getText().isEmpty() || Field2.getText().isEmpty() || Field3.getText().isEmpty() || Field4.getText().isEmpty() || Field5.getText().isEmpty() || Field6.getText().isEmpty() || Field7.getText().isEmpty() || Field8.getText().isEmpty() || averageField.getText().isEmpty() || gradeField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "没填完哦");
                return;
            }

            preparedStatement.setString(1, snoField.getText());
            preparedStatement.setString(2, nameField.getText());
            preparedStatement.setString(3, sexField.getText());
            preparedStatement.setString(4, classField.getText());
            preparedStatement.setString(5, Field1.getText());
            preparedStatement.setString(6, Field2.getText());
            preparedStatement.setString(7, Field3.getText());
            preparedStatement.setString(8, Field4.getText());
            preparedStatement.setString(9, Field5.getText());
            preparedStatement.setString(10, Field6.getText());
            preparedStatement.setString(11, Field7.getText());
            preparedStatement.setString(12, Field8.getText());
            preparedStatement.setString(13, averageField.getText());
            preparedStatement.setString(14, gradeField.getText());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "添加成功");
            } else {
                JOptionPane.showMessageDialog(this, "添加失败");
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteDataById(int id) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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