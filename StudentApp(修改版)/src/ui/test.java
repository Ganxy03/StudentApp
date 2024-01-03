//package ui;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class HomeFrame extends JFrame {
////    private static final String PANEL1 = "增加";
////    private static final String PANEL2 = "删除";
////    private static final String PANEL3 = "修改";
////    private static final String PANEL4 = "查询";
////    private static final String PANEL5 = "关于";
//    private JPanel content_card;
//    private CardLayout cardLayout;
//
//    public HomeFrame() {
//        setTitle("主页|成绩管理系统");
//        setSize(480, 360);
//        setLocationRelativeTo(null);
//        setResizable(false);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JMenuBar menuBar = new JMenuBar(); // menuBar导航条
//        JMenu addMenu = new JMenu("增加"); // 创建菜单
//        JMenu delMenu = new JMenu("删除");
//        JMenu updateMenu = new JMenu("修改");
//        JMenu searchMenu = new JMenu("查询");
//        JMenu aboutMenu = new JMenu("关于");
//
////        JPanel addPanel = new JPanel();
////        JPanel delPanel = new JPanel();
////        JPanel updatePanel = new JPanel();
//        JPanel searchPanel = new JPanel();
//        JPanel inputButtonPanel = new JPanel();
//
////        JLabel titleLabel1 = new JLabel("增加");
////        JLabel titleLabel2 = new JLabel("删除");
////        JLabel titleLabel3 = new JLabel("修改");
//        JLabel titleLabel4 = new JLabel("查询");
//        JButton jButton4 = new JButton("查询全部");
//
//        JTextField jTextField4 = new JTextField(30);
//        jTextField4.setPreferredSize(new Dimension(200, 20));
//
//        inputButtonPanel.add(jTextField4);
//        inputButtonPanel.add(jButton4);
//
//        searchPanel.add(inputButtonPanel);
//
//
//
//        content_card = new JPanel(new CardLayout());
//        content_card.add(searchPanel, "search");
//        cardLayout = (CardLayout) content_card.getLayout();
//        searchPanel.add(titleLabel4);
//        getContentPane().add(content_card);
//
//
//        menuBar.add(addMenu);
//        menuBar.add(delMenu);
//        menuBar.add(updateMenu);
//        menuBar.add(searchMenu);
//        menuBar.add(aboutMenu);
//
//        searchPanel.add(titleLabel4);
//
//
//        JPanel jPanel = new JPanel();
//        jPanel.setLayout(null);
//        jPanel.add(menuBar);
//
//        setJMenuBar(menuBar);
//        add(jPanel);
//
//        searchMenu.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                model.setRowCount(0);
//                cardLayout.show(content_card, "search");
//            }
//        });
//
//    }
//}
