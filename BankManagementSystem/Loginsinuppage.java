package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loginsinuppage extends JFrame implements ActionListener {
    JLabel welcomelable=new JLabel("Welcome to our ABCD Bank ");
    JButton sinu=new JButton("Sing-Up");
    JButton login=new JButton("Log-in");
    ImageIcon img=new ImageIcon("bank.jpg");
    //ImageIcon img=new ImageIcon("img3.png");
    Loginsinuppage(){
        this.setTitle("Log-in and sing-up page of bank system");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,800);
        this.setLayout(null);
        this.setIconImage(img.getImage());



        welcomelable.setFont(new Font("Arial",Font.BOLD,25));
        welcomelable.setBounds(200,0,400,200);
        welcomelable.setHorizontalTextPosition(JLabel.CENTER);
        this.add(welcomelable);

        sinu.setBackground(Color.blue);
        sinu.setForeground(Color.white);
        sinu.setFocusable(false);
        sinu.setFont(new Font("Arial",Font.BOLD,20));
        sinu.setBounds(100,500,200,50);
        this.add(sinu);
        sinu.addActionListener(this);

        login.setBackground(Color.blue);
        login.setForeground(Color.white);
        login.setFont(new Font("Arial",Font.BOLD,20));
        login.setFocusable(false);
        login.setBounds(400,500,200,50);
        this.add(login);
        login.addActionListener(this);


        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==sinu){
            sinup sinup=new sinup();
        }else if (e.getSource()==login){
            login logingo=new login();
        }
    }



    public static void main(String[] args) {
        Loginsinuppage page1=new Loginsinuppage();
    }
}
