package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class withrowal extends JFrame implements ActionListener {
    JButton dc=new JButton("Withrow cash");
    ImageIcon img=new ImageIcon("sui.jpg");
    JPanel p=new JPanel();
    JPanel p1=new JPanel();
    JLabel l=new JLabel(img);
    TextField ff=new TextField();
    String pin;
    withrowal(String pi){
        this.setTitle("Service Avaliable");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,975);
        this.setLayout(null);
        p1=new JPanel(null);
        pin=pi;

        p.setBounds(0,0,1200,975);
        p.setOpaque(true);
        p.add(l);

        JLabel l1=new JLabel("Enter the amount you want to withrow");
        l1.setBounds(20,50,500,40);
        l1.setForeground(Color.white);
        l1.setFont(new Font("Arial",Font.BOLD,20));

        ff.setBounds(200,200,150,30);
        ff.setFont(new Font("Arial",Font.BOLD,20));
        p1.add(ff);

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
        String x=ff.getText();
        int a=0;
        int p=1;
        for(int i=x.length()-1;i>=0;i--){
            int s=(int)x.charAt(i)-48;
            a +=s*p;
            p=p*10;
        }
        d(a);
        if (e.getSource()==dc && x.length()<7){
            JOptionPane.showMessageDialog(null,"Money withrow Sucessfully ");
        }else{
            JOptionPane.showMessageDialog(null,"Enter Amount less then 100000");
        }
    }
    void d(int a){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:MySQL://127.0.0.1:3306/banksystem",
                    "root",
                    "1234"
            );
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select balance from balance1 where pin='"+pin+"';");
            resultSet.next();
            a=resultSet.getInt("balance")-a;
            int aa=statement.executeUpdate("update balance1 set balance='"+a+"'where pin='"+pin+"';");
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        withrowal w=new withrowal("1234");
    }
}
