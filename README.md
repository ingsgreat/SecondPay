#### 电子小卖部
## 1、为了用户信息方便显示，创建Users.java文件，并加入id,useranme,password等三个属性（alt+insert）

## 2、增加“桂电小卖部”
```java
//---- label2 ----
        label2.setText("\u6842\u7535\u5c0f\u5356\u90e8");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 50f));
        contentPane.add(label2);
        label2.setBounds(35, 65, 370, 212);
```

## 3、增加 刷新和增加 两个按钮
```java
button1 = new JButton();
        button2 = new JButton();



//---- button1 ----
        button1.setText("\u5237\u65b0");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 10f));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(110, 290), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u589e\u52a0");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 10f));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(235, 290), button2.getPreferredSize()));


    private JButton button1;
    private JButton button2;
```
## 4、测试刷新功能
```sql
insert into users values(888000,'sgc','sgc1234');
insert into users values(000000,'sgc','sgc1234');
```
