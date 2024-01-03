package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutExample {
    private static final String PANEL1 = "增加";
    private static final String PANEL2 = "删除";
    private static final String PANEL3 = "修改";
    private static final String PANEL4 = "查询";
    private static final String PANEL5 = "关于";

    public static void main(String[] args) {
        JFrame frame = new JFrame("CardLayout 示例");
        JPanel contentPane = new JPanel(new CardLayout());
        // 创建不同的面板作为视图
        JPanel panel1 = createPanel(PANEL1, Color.RED);
        JPanel panel2 = createPanel(PANEL2, Color.GREEN);
        JPanel panel3 = createPanel(PANEL3, Color.BLUE);
        JPanel panel4 = createPanel(PANEL4, Color.YELLOW);
        JPanel panel5 = createPanel(PANEL5, Color.BLACK);
        // 添加面板到容器中
        contentPane.add(panel1, PANEL1);
        contentPane.add(panel2, PANEL2);
        contentPane.add(panel3, PANEL3);
        contentPane.add(panel4, PANEL4);
        contentPane.add(panel5, PANEL5);

        // 创建菜单栏
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("菜单");
        // 创建菜单项并添加事件监听器
        JMenuItem item1 = new JMenuItem(PANEL1);
        JMenuItem item2 = new JMenuItem(PANEL2);
        JMenuItem item3 = new JMenuItem(PANEL3);
        JMenuItem item4 = new JMenuItem(PANEL4);
        JMenuItem item5 = new JMenuItem(PANEL5);
        item1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, PANEL1);
            }
        });
        item2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, PANEL2);
            }
        });
        item3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, PANEL3);
            }
        });
        // 添加菜单项到菜单
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        // 添加菜单到菜单栏
        menuBar.add(menu);
        // 设置菜单栏
        frame.setJMenuBar(menuBar);
        // 设置内容面板
        frame.setContentPane(contentPane);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    private static JPanel createPanel(String name, Color color) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        JLabel label = new JLabel(name);
        label.setFont(label.getFont().deriveFont(30.0f));
        panel.add(label);
        return panel;
    }
}
