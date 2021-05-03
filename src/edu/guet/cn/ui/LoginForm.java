package edu.guet.cn.ui;

import edu.guet.cn.util.MD5;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Mon May 03 10:21:07 CST 2021
 */



/**
 * @author 1
 */
public class LoginForm extends JFrame {
    public static void main(String[] args) {
        new LoginForm();
    }

    public LoginForm() {
        initComponents();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField("liwei");//username
        label2 = new JLabel();
        textField2 = new JTextField("lw1234");//password
        button1 = new JButton();//登录按钮
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String username = textField1.getText();
                        String password = textField2.getText();
                        Statement stmt = null;
                        String sql = "SELECT password FROM users WHERE username='"+username+"'";
                        Connection conn = null;
                        String url = "jdbc:oracle:thin:@47.115.203.48:1521:orcl";
                        ResultSet rs = null;
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            conn = DriverManager.getConnection(url,"scott", "tiger");
                            stmt = conn.createStatement();

                            rs = stmt.executeQuery(sql);
                            rs.next();
                            String encodePassword=rs.getString(1);
                            boolean isSuccess= MD5.checkpassword(password,encodePassword);
                            if (isSuccess) {
                                System.out.println("登陆成功");
                                MainForm mf=new MainForm(label2);
                                mf.setVisible(true);
                                setVisible(false);
                            } else {
                                System.out.println("登录失败");
                            }

                        } catch (ClassNotFoundException throwables) {
                            throwables.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        } catch (NoSuchAlgorithmException ex) {
                            ex.printStackTrace();
                        } catch (UnsupportedEncodingException ex) {
                            ex.printStackTrace();
                        }finally {
                            try {
                                rs.close();
                                stmt.close();
                                conn.close();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
        );

        button2 = new JButton();//退出按钮


        //======== this ========
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d");
        contentPane.add(label1);
        label1.setBounds(95, 85, 56, label1.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(new Rectangle(new Point(220, 85), textField1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u5bc6\u7801");
        contentPane.add(label2);
        label2.setBounds(95, 130, 55, label2.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(new Rectangle(new Point(220, 125), textField2.getPreferredSize()));

        //---- button1 ----
        button1.setText("\u767b\u5f55");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(95, 205), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u9000\u51fa");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(220, 205), button2.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(395, 295));
        pack();
        setLocationRelativeTo(getOwner());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
