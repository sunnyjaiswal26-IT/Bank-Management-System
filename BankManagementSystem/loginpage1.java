package BankManagementSystem;

import GUI.Jpanel;

import javax.swing.*;
import java.awt.*;

public class loginpage1 extends JFrame{
    JButton dc=new JButton("Deposite");
    JButton cw=new JButton("Cash Wethrowal");
    JButton fc=new JButton("Fast Cash");
    JButton ms=new JButton("Mini Statement");
    JButton pc=new JButton("Pin change");
    JButton be=new JButton("Balance Inquery");
    JButton e=new JButton("Exit");
    ImageIcon img=new ImageIcon("sui.jpg");
    JPanel p=new JPanel();
    JPanel p1=new JPanel();
    JLabel l=new JLabel(img);
    loginpage1(){
        this.setTitle("Service Avaliable");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,975);
        this.setLayout(null);

        p.setBounds(0,0,1200,975);

        p.setOpaque(true);
        p.add(l);

        p1=new JPanel(null);
        cw.setBounds(40,50,180,50);
        p1.add(cw);
                dc.setBounds(260,50,180,50);
        p1.add(dc);
        fc.setBounds(40,120,180,50);
        p1.add(fc);
        ms.setBounds(260,120,180,50);
        p1.add(ms);
        pc.setBounds(40,190,180,50);
        p1.add(pc);
        be.setBounds(260,190,180,50);
        p1.add(be);
        e.setBounds(150,250,180,50);
        p1.add(e);




        p1.setBounds(150,180,520,380);
        p1.setOpaque(true);
        p1.setBackground(Color.gray);
        l.add(p1);

        this.add(p);

        this.setVisible(true);

    }

    public static void main(String[] args) {
        loginpage1 l=new loginpage1();
    }
}
