package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class TestFrame extends JFrame {
    public TestFrame() {
        // 设置窗口标题和大小
        setTitle("表格示例");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建一个表格模型
        DefaultTableModel model = new DefaultTableModel();

        // 添加列名
        model.addColumn("id");
        model.addColumn("名字");

        try {
            // 加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 建立数据库连接
            Connection connection = DriverManager.getConnection("", "", "");

            // 创建Statement对象
            Statement statement = connection.createStatement();

            // 执行SQL查询
            ResultSet resultSet = statement.executeQuery("SELECT * FROM grade");

            // 遍历结果集，将数据添加到表格模型中
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String 名字 = resultSet.getString("名字");
                model.addRow(new Object[]{id, 名字});
            }

            // 关闭资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 创建一个表格，并将模型设置为刚刚创建的模型
        JTable table = new JTable(model);

        // 将表格添加到滚动面板中，然后将滚动面板添加到窗口的内容面板中
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
    }

}


//
//package ui;
//
//        import javax.swing.*;
//        import javax.swing.table.DefaultTableModel;
//        import java.awt.*;
//        import java.awt.event.ActionEvent;
//        import java.awt.event.ActionListener;
//        import java.awt.event.MouseAdapter;
//        import java.awt.event.MouseEvent;
//        import java.sql.*;
//
//public class HomeFrame extends JFrame{
//
//    private String URL = "jdbc:mysql://124.221.138.245:3306/train_student?useSSL=false";
//    private String USERNAME = "train";
//    private String PASSWORD = "train20231230";
//    private JPanel content_card;
//    private CardLayout cardLayout;
//
//    public HomeFrame() {
//        setTitle("主页|成绩管理系统");
//        setSize(620, 480);
//        setLocationRelativeTo(null);
//        setResizable(false);
//
//        JPanel homePanel = new JPanel();
//        JLabel titleLabel0 = new JLabel("主页");
//        titleLabel0.setFont(new Font("楷体", Font.BOLD, 24)); // 设置字体大小
//        titleLabel0.setHorizontalAlignment(JLabel.CENTER); // 设置水平居中对齐
//        homePanel.add(titleLabel0);
//
//        JPanel addPanel = new JPanel();
//        JLabel titleLabel1 = new JLabel("添加成绩");
//        titleLabel1.setFont(new Font("楷体", Font.BOLD, 24)); // 设置字体大小
//        titleLabel1.setHorizontalAlignment(JLabel.CENTER); // 设置水平居中对齐
//        addPanel.add(titleLabel1);
//
//        JPanel deletePanel = new JPanel();
//        JLabel titleLabel2 = new JLabel("删除成绩");
//        titleLabel2.setFont(new Font("楷体", Font.BOLD, 24)); // 设置字体大小
//        titleLabel2.setHorizontalAlignment(JLabel.CENTER); // 设置水平居中对齐
//        deletePanel.add(titleLabel2);
//
//        JPanel updatePanel = new JPanel();
//        JLabel titleLabel3 = new JLabel("修改成绩");
//        titleLabel3.setFont(new Font("楷体", Font.BOLD, 24)); // 设置字体大小
//        titleLabel3.setHorizontalAlignment(JLabel.CENTER); // 设置水平居中对齐
//        updatePanel.add(titleLabel3);
//
//        JPanel queryPanel = new JPanel();
////        queryPanel.setLayout(new GridLayout(10, 1)); // 使用GridLayout布局管理器，两行一列
//        JLabel titleLabel4 = new JLabel("查询成绩");
//        titleLabel4.setFont(new Font("楷体", Font.BOLD, 24));
//        queryPanel.add(titleLabel4); // 标题标签添加到第一行
//        JPanel inputButtonPanel = new JPanel();
//        inputButtonPanel.setLayout(new FlowLayout()); // 使用FlowLayout布局管理器，默认居左对齐
//        JTextField jTextField4 = new JTextField(30);
//        jTextField4.setPreferredSize(new Dimension(200, 20)); // 输入框的固定尺寸
//        inputButtonPanel.add(jTextField4); // 输入框添加到输入按钮面板
//        JButton jButton4 = new JButton("查询全部");
//        inputButtonPanel.add(jButton4); // 按钮添加到输入按钮面板
//        queryPanel.add(inputButtonPanel); // 输入按钮面板添加到第二行
//
//
//
//
//
//
//        JMenuBar menuBar = new JMenuBar();
//
//        JMenu home = new JMenu("首页");
//        JMenu function = new JMenu("功能");
//        JMenu about = new JMenu("关于");
//
//        JMenuItem menuItem1 = new JMenuItem("新增");
//        JMenuItem menuItem2 = new JMenuItem("删除");
//        JMenuItem menuItem3 = new JMenuItem("修改");
//        JMenuItem menuItem4 = new JMenuItem("查询");
//
//        function.add(menuItem1);
//        function.add(menuItem2);
//        function.add(menuItem3);
//        function.add(menuItem4);
//
//        menuBar.add(home);
//        menuBar.add(function);
//        menuBar.add(about);
//
//        home.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                cardLayout.show(content_card, "home");
//            }
//        });
//        about.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                JOptionPane.showMessageDialog(HomeFrame.this, "这是一个消息对话框");
//            }
//        });
//
//        menuItem1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                cardLayout.show(content_card, "add");
//            }
//        });
//        menuItem2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                cardLayout.show(content_card, "delete");
//            }
//        });
//        menuItem3.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                cardLayout.show(content_card, "update");
//            }
//        });
//        menuItem4.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                cardLayout.show(content_card, "query");
//            }
//        });
//        jButton4.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // 清空表格模型的数据
//                String sql = "SELECT * FROM grade";
//                ResultSet resultSet = null;
//                try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//                     PreparedStatement stmt = conn.prepareStatement(sql)) {
//                    resultSet = stmt.executeQuery();
//                    DefaultTableModel model = new DefaultTableModel();
//
//                    model.addColumn("id");
//                    model.addColumn("名字");
//                    while (resultSet.next()) {
//                        int id = resultSet.getInt("id");
//                        String 名字 = resultSet.getString("名字");
//                        model.addRow(new Object[]{id, 名字});
//                    }
//
//                    JTable table = new JTable(model);
//                    JScrollPane scrollPane = new JScrollPane(table);
//                    getContentPane().add(scrollPane);
//
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                } finally {
//                    try {
//                        if (resultSet != null) {
//                            resultSet.close();
//                        }
//                    } catch (SQLException ex) {
//                        ex.printStackTrace();
//                    }
//                }
//            }
//        });
//
//        setJMenuBar(menuBar);
//
//
//        content_card = new JPanel(new CardLayout());
//        content_card.add(homePanel, "home");
//        content_card.add(addPanel, "add");
//        content_card.add(deletePanel, "delete");
//        content_card.add(updatePanel, "update");
//        content_card.add(queryPanel, "query");
//
//        cardLayout = (CardLayout) content_card.getLayout();
//
//
//        getContentPane().add(content_card);
//
//    }
//}
