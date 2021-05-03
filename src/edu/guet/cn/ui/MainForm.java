package edu.guet.cn.ui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class MainForm extends JFrame {
    public MainForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu("用户管理");
        menu1.add(new JMenuItem("添加用户"));
        JMenuItem viewUserMenuItem=new JMenuItem("查看用户");
        viewUserMenuItem.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("鼠标点了我");
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        System.out.println("kkkkkk");
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                }
        );
        menu1.add(viewUserMenuItem);
        menu1.add(new JMenuItem("修改密码"));

        menuBar2 = new JMenuBar();
        menu2 = new JMenu("商品管理");
        menu2.add(new JMenuItem("添加商品"));
        menu2.add(new JMenuItem("查看库存"));

        //分隔符
        menu1.addSeparator();
        menu1.add(new JMenuItem("退出"));
        menuBar3 = new JMenuBar();
        menu3 = new JMenu("仓库管理");
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u7528\u6237\u7ba1\u7406");
            }
            menuBar1.add(menu1);

            //======== menuBar2 ========
            {

                //======== menu2 ========
                {
                    menu2.setText("\u5546\u54c1\u7ba1\u7406");
                }
                menuBar2.add(menu2);
            }
            menuBar1.add(menuBar2);

            //======== menuBar3 ========
            {

                //======== menu3 ========
                {
                    menu3.setText("\u4ed3\u5e93\u7ba1\u7406");
                }
                menuBar3.add(menu3);
            }
            menuBar1.add(menuBar3);
        }
        setJMenuBar(menuBar1);

        //---- label1 ----
        label1.setText("\u7528\u6237\u4fe1\u606f");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 39f));
        contentPane.add(label1);
        label1.setBounds(115, 5, 280, 55);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(35, 70, 370, 190);

        contentPane.setPreferredSize(new Dimension(455, 435));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuBar menuBar2;
    private JMenu menu2;
    private JMenuBar menuBar3;
    private JMenu menu3;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
