package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login extends JFrame implements ActionListener {
    TextField aplic=new TextField();
    TextField pass=new TextField();
    JLabel lableap=new JLabel("Application No:");
    JLabel lablepass=new JLabel("Password:");
    JButton forget=new JButton("Forget Password");
    JButton log=new JButton("Log-In");
    String a="duu";
    String p="djndf";
    login(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,600);
        this.setLayout(null);

        lableap.setBounds(50,200,150,50);
        lableap.setFont(new Font("Arial",Font.BOLD,20));
        this.add(lableap);

        aplic.setBounds(200,215,200,30);
        aplic.setFont(new Font("Arial",Font.BOLD,15));
        this.add(aplic);
        //a= aplic.getInputContext().toString();

        lablepass.setBounds(50,300,130,50);
        lablepass.setFont(new Font("Arial",Font.BOLD,20));
        this.add(lablepass);



        pass.setBounds(200,315,200,30);
        pass.setFont(new Font("Arial",Font.BOLD,20));
        this.add(pass);
        //p=pass.getSelectedText().toString();

        forget.setBackground(Color.red);
        forget.setBounds(40,400,200,50);
        this.add(forget);

        log.setBackground(Color.green);
        log.setBounds(250,400,200,50);
        this.add(log);
        log.addActionListener(this);


        this.setVisible(true);
    }

    public static void main(String[] args) {
        login l=new login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==log){
            a= aplic.getText();
            p=pass.getText();
            String sql="select pin from sinuppage4 where card_number="+a+";";
            System.out.println(sql);
            System.out.println(a);
            System.out.println(p);
            if(pin(sql).equals(p)) {
                loginpage1 p=new loginpage1();
            }else {
                JOptionPane.showMessageDialog(null,"Worng pin or card number");
            }
        }
    }
    String pin(String sql){
        String pin="";
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:MySQL://127.0.0.1:3306/banksystem",
                    "root",
                    "1234"
            );
            Statement statement=connection.createStatement();

            ResultSet resultSet=statement.executeQuery(sql);
            resultSet.next();
 pin =resultSet.getString("pin");

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return pin;
    }

}
