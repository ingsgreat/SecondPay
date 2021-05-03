/*
 * Created by JFormDesigner on Mon May 03 10:28:46 CST 2021
 */

package edu.guet.cn.ui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author 1
 */
public class MainForm extends JFrame {
    public MainForm() {
        initComponents();
    }
    public Object[][] queryData() {
        //因为Swing里也有一个组件叫List
        Connection conn = null;
        String url = "jdbc:oracle:thin:@120.77.242.136:1521:orcl";
        Statement stmt = null;//SQL语句对象，拼SQL
        String sql = "SELECT * FROM users";
        System.out.println("即将执行的sql：" + sql);
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//
            conn = DriverManager.getConnection(url, "scott", "tiger");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {//rs.next的作用？让游标向下移动

            }
        } catch (ClassNotFoundException ee) {
            ee.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //释放资源：数据库连接很昂贵
            try {
                rs.close();
                stmt.close();
                conn.close();//关连接
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        /*data = new Object[list.size()][head.length];
        //把集合里的数据放入Obejct这个二维数组
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = list.get(i).getId();
                data[i][1] = list.get(i).getUsername();
                data[i][2] = list.get(i).getPassword();
            }
        }*/
        return data;
    }

    private void initComponents() {
        JMenuBar mb = new JMenuBar();
        JMenu mHero = new JMenu("用户管理");
        JMenu mItem = new JMenu("商品管理");
        // 菜单项
        mHero.add(new JMenuItem("添加用户"));
        JMenuItem viewUserMenuItem = new JMenuItem("查看用户");
        viewUserMenuItem.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("鼠标点了我");
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        System.out.println("kkkkkkk");
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

        mHero.add(viewUserMenuItem);
        mHero.add(new JMenuItem("修改密码"));

        mItem.add(new JMenuItem("添加商品"));
        mItem.add(new JMenuItem("查看库存"));

        // 分隔符
        mHero.addSeparator();
        mHero.add(new JMenuItem("退出"));
        mb.add(mHero);
        mb.add(mItem);

        this.setJMenuBar(mb);
        table1 = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(tableModel);

        Container contnetPane = getContentPane();
        contnetPane.setLayout(null);

        contnetPane.setPreferredSize(new Dimension(650, 450));
        pack();
        setLocationRelativeTo(getOwner());
    }
    private JTable table1;
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    private Object[][] data=null;
    private String head[]={"id","username","password"};
}