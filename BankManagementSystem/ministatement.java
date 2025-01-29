package BankManagementSystem;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ministatement extends JFrame {
    JLabel l1=new JLabel("Card Number :");
    JLabel l2=new JLabel("Transiction Type");
    JLabel l3=new JLabel("Date and Time ");
    JLabel l4=new JLabel("Amount");

    JLabel balance=new JLabel();
    ministatement(String pin){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,500);
        this.setLayout(null);

        l1.setBounds(10,10,200,30);
        this.add(l1);
        l2.setBounds(20,50,200,30);
        this.add(l2);
        l3.setBounds(160,50,200,30);
        this.add(l3);
        l4.setBounds(300,50,200,30);
        this.add(l4);
        String b="";
        List p=new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:MySQL://127.0.0.1:3306/banksystem",
                    "root",
                    "1234"
            );
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from balance1");

            while (resultSet.next()) {
                int balance11 = resultSet.getInt("balance");
                p.add(balance11);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        while(p.size()!=0){
            b=b+p.get(0);
            b=b+"\n";
            p.remove(0);
        }
        int[]a={22};
        int bd[]=a.clone();
        System.out.println(b);
        balance=new JLabel(b);
        balance.setBounds(300,50,100,200);
        this.add(balance);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        ministatement m=new ministatement("1234");
        String x="suii "+"\n"+" djnd";
        System.out.println(x);
    }
}
