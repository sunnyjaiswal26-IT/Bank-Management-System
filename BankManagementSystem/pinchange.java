package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class pinchange extends JFrame implements ActionListener {
        JButton dc=new JButton("Back");
    JButton cha=new JButton("Chaange");

        ImageIcon img=new ImageIcon("sui.jpg");
        JPanel p=new JPanel();
        JPanel p1=new JPanel();
        JLabel l=new JLabel(img);
    JLabel l1=new JLabel("Enter old pin : ");
    JLabel np=new JLabel("Enter new pin :");
    JLabel anp=new JLabel("Enter new pin again : ");

    JTextField f1=new JTextField();
    JTextField f2=new JTextField();
    JTextField f3=new JTextField();
        String pin;

        pinchange(String pi){
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

            l1.setBounds(20,50,500,40);
            l1.setForeground(Color.white);
            l1.setFont(new Font("Arial",Font.BOLD,20));
            p1.add(l1);

            np.setBounds(20,100,500,40);
            np.setForeground(Color.white);
            np.setFont(new Font("Arial",Font.BOLD,20));
            p1.add(np);

            anp.setBounds(20,150,500,40);
            anp.setForeground(Color.white);
            anp.setFont(new Font("Arial",Font.BOLD,20));
            p1.add(anp);

            f1.setBounds(250,50,200,30);
            f1.setFont(new Font("Arial",Font.BOLD,20));
            p1.add(f1);

            f2.setBounds(250,100,200,30);
            f2.setFont(new Font("Arial",Font.BOLD,20));
            p1.add(f2);
            f3.setBounds(250,150,200,30);
            f3.setFont(new Font("Arial",Font.BOLD,20));
            p1.add(f3);

            dc.setBounds(50,300,100,50);
            p1.add(dc);

            cha.setBounds(180,300,100,50);

            p1.add(cha);

            p1.setBounds(150,180,520,380);
            p1.setOpaque(true);
            p1.setBackground(Color.gray);
            l.add(p1);

            cha.addActionListener(this);
            this.add(p);
            dc.addActionListener(this);

            this.setVisible(true);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==cha && f1.getText().equals(pin) && f2.equals(f3)){
                String sql="update balance1 set pin='"+f2.getText()+"' where pin='"+pin+"';";
                c(sql);
            }else{
                JOptionPane.showMessageDialog(null,"somthing went wrong");
            }
            if (e.getSource()==dc){
                loginpage1 l=new loginpage1("1234");
            }
        }
        void c(String s){
            try{
                Connection connection = DriverManager.getConnection(
                        "jdbc:MySQL://127.0.0.1:3306/banksystem",
                        "root",
                        "1234"
                );
                Statement statement=connection.createStatement();
                System.out.println(s);
                int aa=statement.executeUpdate(s);
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }


        public static void main(String[] args) {
            pinchange p=new pinchange("9999");
        }
}
