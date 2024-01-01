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

    private String URL = "";
    private String USERNAME = "";
    private String PASSWORD = "";
    private JPanel content_card;
    private CardLayout cardLayout;


    private DefaultTableModel model = new DefaultTableModel();

    public HomeFrame() {
        setTitle("主页|成绩管理系统");
        setSize(620, 480);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel homePanel = new JPanel();
        JLabel titleLabel0 = new JLabel("主页");
        titleLabel0.setFont(new Font("楷体", Font.BOLD, 24));
        titleLabel0.setHorizontalAlignment(JLabel.CENTER);
        homePanel.add(titleLabel0);



        JPanel queryPanel = new JPanel();
//        queryPanel.setLayout(new GridLayout(10, 1));
        JLabel titleLabel4 = new JLabel("查询成绩");
        titleLabel4.setFont(new Font("楷体", Font.BOLD, 24));
        queryPanel.add(titleLabel4);
        JPanel inputButtonPanel = new JPanel();
        inputButtonPanel.setLayout(new FlowLayout());
        JTextField jTextField4 = new JTextField(30);
        jTextField4.setPreferredSize(new Dimension(200, 20));
        inputButtonPanel.add(jTextField4);
        JButton jButton4 = new JButton("查询全部");
        inputButtonPanel.add(jButton4);
        queryPanel.add(inputButtonPanel);

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

        JMenu home = new JMenu("首页");
        JMenu function = new JMenu("功能");
        JMenu about = new JMenu("关于");

        JMenuItem menuItem1 = new JMenuItem("新增");
        JMenuItem menuItem2 = new JMenuItem("删除");
        JMenuItem menuItem3 = new JMenuItem("修改");
        JMenuItem menuItem4 = new JMenuItem("查询");

        function.add(menuItem1);
        function.add(menuItem2);
        function.add(menuItem3);
        function.add(menuItem4);

        menuBar.add(home);
        menuBar.add(function);
        menuBar.add(about);

        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(content_card, "home");
            }
        });
        about.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(HomeFrame.this, "Author:男一317全体都有\n王文俊 甘先懿 朱引航\n高猛猛 韦彭 李家辉\nDate:2023/12/30");
            }
        });
        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddFrame().setVisible(true);
            }
        });
        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteFrame().setVisible(true);
            }
        });
        menuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateFrame().setVisible(true);
            }
        });
        menuItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                cardLayout.show(content_card, "query");
            }
        });
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String sql = "SELECT * FROM grade";
                ResultSet resultSet = null;
                try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
                    resultSet = stmt.executeQuery();

                    JPanel tablePanel = new JPanel();
                    tablePanel.setPreferredSize(new Dimension(queryPanel.getWidth(), 375));
                    tablePanel.setLayout(new BorderLayout());
                    queryPanel.add(tablePanel, BorderLayout.SOUTH);

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

                    queryPanel.revalidate();
                    queryPanel.repaint();
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

        setJMenuBar(menuBar);


        content_card = new JPanel(new CardLayout());
        content_card.add(homePanel, "home");
        content_card.add(queryPanel, "query");

        cardLayout = (CardLayout) content_card.getLayout();


        getContentPane().add(content_card);

    }
}