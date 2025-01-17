package BankManagementSystem;

import GUI.Joptionpane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class sinuppage3 extends JFrame implements ActionListener {
    JRadioButton sa=new JRadioButton("Saving Account");
    JRadioButton fda=new JRadioButton("Fixed Deposit Account");
    JRadioButton ca=new JRadioButton("Current Account");
    JRadioButton rda=new JRadioButton("Recurring Diposit Account");
    ButtonGroup at=new ButtonGroup();


    JButton next=new JButton("submit");
    JButton back=new JButton("cancle");

    JCheckBox ac=new JCheckBox("ATM CARD");
   JCheckBox ie=new JCheckBox("Internate Banking");
    JCheckBox mb=new JCheckBox("Mobile banking");
    JCheckBox esa=new JCheckBox("emai and sms alert");
    JCheckBox cb=new JCheckBox("Check Book");
    JCheckBox es=new JCheckBox("E-Statement");
    JCheckBox d=new JCheckBox("Here I declare all the filled data is correct from my point of view");

    textfild panno=new textfild();
    textfild aadharno=new textfild();
    Random rr=new Random();
    long x;
    int i;
    int pp;
    int p;
    sinuppage3(int ii){
i=ii;
        x=rr.nextLong(1000000000000000L,9999999999999999L);
pp=rr.nextInt(1000,9999);
 p= (int) (x%10000);
        lable inst=new lable("Application Form No :"+i);
        inst.setFont(new Font("Arial",Font.BOLD,30));
        inst.setBounds(150,20,600,40);
        this.add(inst);

        lable page=new lable("Page 3 :Account Details :");
        page.setBounds(200,80,600,30);
        this.add(page);

        lable name1=new lable("Account Type :");
        name1.setBounds(20,150,150,20);
        this.add(name1);
        at.add(sa);
        at.add(fda);
        at.add(rda);
        at.add(ca);

        sa.setBounds(50,200,150,20);
        fda.setBounds(250,200,250,20);
        rda.setBounds(250,250,250,20);
        ca.setBounds(50,250,150,20);
        sa.addActionListener(this);
        fda.addActionListener(this);
        ca.addActionListener(this);
        rda.addActionListener(this);
        this.add(sa);
        this.add(rda);
        this.add(ca);
        this.add(fda);




        lable gender2=new lable("Card Number :         XXXX-XXXX-XXXX-"+p);
        gender2.setBounds(20,300,600,20);
        this.add(gender2);
        JLabel gender3=new JLabel("Your 16 digit Card Number ");
        gender3.setBounds(20,320,200,20);
        this.add(gender3);
        lable gender4=new lable("Pin code :              XXXX");
        gender4.setBounds(20,370,600,20);
        this.add(gender4);
        JLabel gender5=new JLabel("Your four digit pin code");
        gender5.setBounds(20,390,200,20);
        this.add(gender5);


        lable marage1=new lable("Service Required :");
        marage1.setBounds(20,450,200,20);
        this.add(marage1);

        ac.setBounds(20,500,160,20);
        ie.setBounds(20,550,160,20);
        mb.setBounds(20,600,160,20);
        es.setBounds(200,500,200,20);
        esa.setBounds(200,550,200,20);
        cb.setBounds(200,600,200,20);
        d.setBounds(100,650,500,20);

        this.add(ac);
        this.add(ie);
        this.add(mb);
        this.add(es);
        this.add(esa);
        this.add(cb);
        this.add(d);



        next.setBackground(Color.green);
        next.setBounds(450,700,120,40);
        next.setFont(new Font("Arial",Font.BOLD,15));
        this.add(next);

        back.setBackground(Color.red);
        back.setBounds(250,700,120,40);
        back.setFont(new Font("Arial",Font.BOLD,15));
        this.add(back);





        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,800);
        this.setLayout(null);

        next.addActionListener(this);

        this.setVisible(true);
    }
    String act;
    String act1;
    String sql;
    String sql1="";
    @Override

    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==fda){
            act="Fixrd Diposite Account";
        }
        if (e.getSource()==rda){
            act="Recurring Diposit Account";
        }
        if (e.getSource()==sa){
            act="Saving Account";
        }
        if (e.getSource()==ca){
            act="Current Account";
        }
        if (ac.isSelected()){
            act1 += "ATM CARD ,";
        }
        if (ie.isSelected()){
            act1 += "Internate Banking ," ;
        }
        if (mb.isSelected()){
            act1 +="Mobile banking ,";
        }
        if (esa.isSelected()){
            act1 +="emai and sms alert ,";
        }
        if (cb.isSelected()){
            act1 +="Check Book ,";
        }
        if (es.isSelected()){
            act1 +="E-Statement ";
        }
        if(d.isSelected()){
        if (e.getSource() == next) {
            int p = 0;
            sql = "INSERT INTO sinuppage3 VALUES(" + i + ", '" + act + "','" + act1 + ".'" + ");";
            sql1 = "INSERT INTO sinuppage4 VALUES(" + i + ", '" + x + "','" + pp +"');";
            System.out.println(sql);
            System.out.println(sql1);
            sui(sql);
            sui(sql1);
            String ans="Registration done successfully \nCard Number :"+x +"\nPin No:" +pp;
            JOptionPane.showMessageDialog(null,ans);
        }
        }

    }
    void sui(String sql){
        try (Connection connection = DriverManager.getConnection(
                "jdbc:MySQL://127.0.0.1:3306/banksystem",
                "root",
                "1234");
             Statement statement = connection.createStatement()) {
            connection.setAutoCommit(true);
            int a=statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    class textfild extends TextField{
        textfild(){
            super();
            this.setFont(new Font("Arial",Font.BOLD,20));
        }
        textfild(String s){

            super(s);
            this.setText(s);
            this.setForeground(Color.gray);
            this.setFont(new Font("Arial",Font.BOLD,20));
        }
    }
    public class lable extends JLabel {
        lable(String s) {
            super(s);
            this.setFont(new Font("Arial", Font.BOLD, 20));
        }
    }

    public static void main(String[] args) {
       // sinuppage3 s=new sinuppage3(7);
    }
}
