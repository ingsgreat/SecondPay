package edu.guet.cn.ui;

import edu.guet.cn.util.Product;
import edu.guet.cn.util.Users;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class MainForm extends JFrame {
    public MainForm(JLabel label2) {
        this.label2 = label2;
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
                        label1.setVisible(true);//用户信息
                        scrollPane1.setVisible(true);//用户表
                        label2.setVisible(false);//桂电小卖部
                        label3.setVisible(false);//商品信息
                        scrollPane2.setVisible(false);//商品表
                        button1.setVisible(true);//刷新
                        button2.setVisible(true);//增加
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
        JMenuItem viewUserMenuItem1=new JMenuItem("查看库存");
        viewUserMenuItem1.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("鼠标点了我");
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        label1.setVisible(false);
                        scrollPane1.setVisible(false);
                        label2.setVisible(false);
                        button1.setVisible(false);
                        button2.setVisible(false);
                        label3.setVisible(true);
                        scrollPane2.setVisible(true);

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
        menu2.add(viewUserMenuItem1);

        //分隔符
        menu1.addSeparator();
        menu1.add(new JMenuItem("退出"));
        menuBar3 = new JMenuBar();
        menu3 = new JMenu("仓库管理");


        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label2 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        label3 = new JLabel();
        label3.setVisible(false);
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        table2.setVisible(false);

        DefaultTableModel tableModel = new DefaultTableModel(queryData(), uhead) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        DefaultTableModel ptableModel = new DefaultTableModel(pqueryData(), phead) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table1.setModel(tableModel);
        button1 = new JButton();//刷新
        button1.setVisible(false);
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DefaultTableModel tableModel = new DefaultTableModel(queryData(), uhead) {
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        table1.setModel(tableModel);
                    }
                }
        );

        table2.setModel(ptableModel);

        button2 = new JButton();//增加
        button2.setVisible(false);

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
        label1.setBounds(160, 10, 280, 55);
        label1.setVisible(false);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        scrollPane1.setVisible(false);
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(80, 80, 370, 190);

        //---- label2 ----
        label2.setText("\u6842\u7535\u5c0f\u5356\u90e8");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 50f));
        contentPane.add(label2);
        label2.setBounds(35, 65, 370, 212);

        //---- button1 ----
        button1.setText("\u5237\u65b0");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 10f));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(45, 290), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u589e\u52a0");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 10f));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(135, 290), button2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u5546\u54c1\u4fe1\u606f");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 40f));
        contentPane.add(label3);
        label3.setBounds(160, 0, 295, 75);

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(table2);
        }
        scrollPane2.setVisible(false);
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(35, 75, scrollPane2.getPreferredSize().width, 200);

        contentPane.setPreferredSize(new Dimension(530, 435));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    public Object[][] queryData() {

        java.util.List<Users> list=new ArrayList<Users>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@47.115.203.48:1521:orcl";
        Statement stmt = null;//SQL语句对象，拼SQL
        String sql = "SELECT * FROM users";
        System.out.println("即将执行的sql：" + sql);
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//
            conn = DriverManager.getConnection(url, "scott", "tiger");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            int i=0;
            while (rs.next()) {
                i++;
                //每循环一次，得到一个用户,并放入容器(List(有序可重复),Set(无序不可重复),Map(key,value))
                Users user=new Users();
                user.setId(rs.getInt("ID"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                list.add(user);
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
            data = new Object[list.size()][uhead.length];
            //把集合里的数据放入Object这个二维数组
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < uhead.length; j++) {
                    data[i][0] = list.get(i).getId();
                    data[i][1] = list.get(i).getUsername();
                    data[i][2] = list.get(i).getPassword();
                }
            }
        }
        return data;
    }

    public Object[][] pqueryData() {

        java.util.List<Product> list=new ArrayList<Product>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@47.115.203.48:1521:orcl";
        Statement stmt = null;//SQL语句对象，拼SQL
        String sql = "SELECT * FROM sproduct";
        System.out.println("即将执行的sql：" + sql);
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//
            conn = DriverManager.getConnection(url, "scott", "tiger");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            int i=0;
            while (rs.next()) {
                i++;
                //每循环一次，得到一个商品,并放入容器(List(有序可重复),Set(无序不可重复),Map(key,value))
                Product product=new Product();
                product.setPid(rs.getInt("PID"));
                product.setPname(rs.getString("PNAME"));
                product.setPrice(rs.getFloat("PRICE"));
                product.setAmount(rs.getInt("AMOUNT"));
                list.add(product);
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
            data = new Object[list.size()][phead.length];
            //把集合里的数据放入Object这个二维数组
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < phead.length; j++) {
                    data[i][0] = list.get(i).getPid();
                    data[i][1] = list.get(i).getPname();
                    data[i][2] = list.get(i).getPrice();
                    data[i][3] = list.get(i).getAmount();
                }
            }
        }
        return data;
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
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    private Object[][] data = null;
    private String uhead[] = {"id", "username", "password"};
    private String phead[] = {"id", "pname", "price","amount"};
    private JLabel label3;
    private JScrollPane scrollPane2;
    private JTable table2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
