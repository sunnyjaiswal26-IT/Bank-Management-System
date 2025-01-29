package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class balanceinqury extends JFrame implements ActionListener {
    JButton dc=new JButton("Back");
    ImageIcon img=new ImageIcon("sui.jpg");
    JPanel p=new JPanel();
    JPanel p1=new JPanel();
    JLabel l=new JLabel(img);
    String pin;
    JLabel l1;
    balanceinqury(String pi){
        this.setTitle("Service Avaliable");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,975);
        this.setLayout(null);
        p1=new JPanel(null);
        pin=pi;

        p.setBounds(0,0,1200,975);
        p.setOpaque(true);
        p.add(l);
String s="";
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:MySQL://127.0.0.1:3306/banksystem",
                    "root",
                    "1234"
            );
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select balance from balance1 where pin='"+pin+"';");
            resultSet.next();
            s="Balance in your Account is : "+resultSet.getInt("balance");
        }catch(SQLException e) {
            e.printStackTrace();
        }
        l1=new JLabel(s);
        l1.setBounds(20,50,500,40);
        l1.setForeground(Color.white);
        l1.setFont(new Font("Arial",Font.BOLD,20));

        p1.add(l1);

        dc.setBounds(180,300,200,50);
        p1.add(dc);



        p1.setBounds(150,180,520,380);
        p1.setOpaque(true);
        p1.setBackground(Color.gray);
        l.add(p1);

        this.add(p);
        dc.addActionListener(this);

        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==dc){
loginpage1 l=new loginpage1("1234");
        }
    }


    public static void main(String[] args) {
        balanceinqury b=new balanceinqury("1234");
    }
}
