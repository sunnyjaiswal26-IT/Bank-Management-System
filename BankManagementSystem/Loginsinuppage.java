package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loginsinuppage extends JFrame implements ActionListener {
    Loginsinuppage(){
        this.setTitle("Log-in and sing-up page of bank system");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,800);
        this.setLayout(null);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    public static void main(String[] args) {
        Loginsinuppage page1=new Loginsinuppage();
    }
}
