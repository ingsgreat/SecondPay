package edu.guet.cn.ui;

import edu.guet.cn.util.Users;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


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

        DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(tableModel);

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
    public Object[][] queryData() {

        java.util.List<Users> list=new ArrayList<Users>();
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
            data = new Object[list.size()][head.length];
            //把集合里的数据放入Object这个二维数组
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < head.length; j++) {
                    data[i][0] = list.get(i).getId();
                    data[i][1] = list.get(i).getUsername();
                    data[i][2] = list.get(i).getPassword();
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
    private Object[][] data = null;
    private String head[] = {"id", "username", "password"};
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
