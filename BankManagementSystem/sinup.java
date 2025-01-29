package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;

//import static jdk.internal.agent.Agent.getText;

public class sinup extends JFrame implements ActionListener {
JRadioButton male=new JRadioButton("Male");
JRadioButton female=new JRadioButton("Female");
JRadioButton other=new JRadioButton("Other");
    ButtonGroup gender1=new ButtonGroup();
    ButtonGroup status=new ButtonGroup();
    JRadioButton marid=new JRadioButton("Married");
    JRadioButton unmarried=new JRadioButton("Unmarried");
    JRadioButton other1=new JRadioButton("Other");
    JButton next=new JButton("Next");
    JButton back=new JButton("Back");
    textfild name=new textfild();
    textfild fathername=new textfild();
    textfild email=new textfild();
    textfild gender=new textfild();
    textfild marage=new textfild();
    textfild dob=new textfild("eg: DD-MM-YYYY");
    textfild address=new textfild();
    textfild city=new textfild();
    textfild state=new textfild();
    textfild pin=new textfild();
    Random r=new Random();
    int i;
    sinup(){


        i=r.nextInt(0,100);

        lable inst=new lable("Application Form No :"+i);
        inst.setFont(new Font("Arial",Font.BOLD,30));
        inst.setBounds(150,20,600,40);
        this.add(inst);

        lable page=new lable("Page 1 :Persional Details :");
        page.setBounds(200,80,600,30);
        this.add(page);

        lable name1=new lable("Name :");
        name1.setBounds(20,150,150,20);
        this.add(name1);
        name.setBounds(250,150,200,30);
        this.add(name);

        lable fathername1=new lable("Father Name :");
        fathername1.setBounds(20,200,150,20);
        this.add(fathername);
        fathername.setBounds(250,200,200,30);
        this.add(fathername1);

        lable dob1=new lable("Date of Birth :");
        dob1.setBounds(20,250,200,20);
        this.add(dob1);
        dob.setBounds(250,250,200,30);
        this.add(dob);


        lable gender2=new lable("Gender :");
        gender2.setBounds(20,300,200,20);
        this.add(gender2);
        male.setBounds(250,300,100,20);
        this.add(male);
        female.setBounds(350,300,100,20);
        this.add(female);
        other.setBounds(450,300,100,20);
        this.add(other);

        lable email1=new lable("Enter Email :");
        email1.setBounds(20,350,200,20);
        this.add(email1);
        email.setBounds(250,350,200,30);
        this.add(email);

        lable marage1=new lable("Marrage Status :");
        marage1.setBounds(20,400,200,20);
        this.add(marage1);
        marid.setBounds(250,400,100,20);
        this.add(marid);
        unmarried.setBounds(350,400,100,20);
        this.add(unmarried);
        other1.setBounds(450,400,100,20);
        this.add(other1);

        lable address1=new lable("Address : ");
        address1.setBounds(20,450,200,20);
        this.add(address1);
        address.setBounds(250,450,200,30);
        this.add(address);

        lable city1=new lable("City :");
        city1.setBounds(20,500,220,20);
        this.add(city1);

        city.setBounds(250,500,200,30);
        this.add(city);

        lable state1=new lable("State :");
        state1.setBounds(20,550,220,20);
        this.add(state1);
        state.setBounds(250,550,200,30);
        this.add(state);

        lable pin1=new lable("Pin code :");
        pin1.setBounds(20,600,220,20);
        this.add(pin1);

        pin.setBounds(250,600,200,30);
        this.add(pin);

        next.setBackground(Color.green);
        next.setBounds(450,700,80,40);
        next.setFont(new Font("Arial",Font.BOLD,15));
        this.add(next);

        back.setBackground(Color.red);
        back.setBounds(350,700,80,40);
        back.setFont(new Font("Arial",Font.BOLD,15));
        this.add(back);

        gender1.add(male);
        gender1.add(female);
        gender1.add(other);

        status.add(marid);
        status.add(unmarried);
        status.add(other1);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,800);
        this.setLayout(null);

        male.addActionListener(this);
        female.addActionListener(this);
        other.addActionListener(this);

        marid.addActionListener(this);
        unmarried.addActionListener(this);
        other1.addActionListener(this);
next.addActionListener(this);





        this.setVisible(true);
    }
    String sex;
    String st;
    String sql;
    @Override

    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==male){
            sex="Male";

        }
        if (e.getSource()==female){
            sex="Female";
        }
        if (e.getSource()==other){
            sex="Other";
        }
        if (e.getSource()==marid){
            st="Marid";
        }
        if (e.getSource()==unmarried){
            st="Unmarrid";
        }
        if (e.getSource()==other1){
            st="Other";
        }
        if (e.getSource() == next) {
            int p = 0;
            sql = "INSERT INTO page1 VALUES(" + i + ", '" + name.getText() + "', '" + fathername.getText() + "', '"
                    + dob.getText() + "', '" + sex + "', '" + email.getText() + "', '" + st + "', '"
                    + address.getText() + "', '" + city.getText() + "', '" + state.getText() + "', '"
                    + pin.getText() + "');";
            System.out.println(sql);
sui(sql);
sinuppage2 s=new sinuppage2(i);
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
sinup s=new sinup();
    }
}
