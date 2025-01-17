package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Random;

public class sinuppage2 extends JFrame implements ActionListener{

        JRadioButton Yes=new JRadioButton("Yes");
        JRadioButton No=new JRadioButton("No");
    JRadioButton Yes1=new JRadioButton("Yes");
    JRadioButton No1=new JRadioButton("No");
        ButtonGroup yesno=new ButtonGroup();
    ButtonGroup yesno1=new ButtonGroup();


        JButton next=new JButton("Next");
        JButton back=new JButton("Back");
    JComboBox rilision;
    JComboBox catagry;
    JComboBox income;
    JComboBox education;
    JComboBox ocupation;

    textfild panno=new textfild();
    textfild aadharno=new textfild();
    int i;
        sinuppage2(int iii){
i=iii;
            String r[]={"Hindu","Muslim","Chamar","Dalit","cristion","other"};
            rilision=new JComboBox(r);


            lable inst=new lable("Application Form No :"+i);
            inst.setFont(new Font("Arial",Font.BOLD,30));
            inst.setBounds(150,20,600,40);
            this.add(inst);

            lable page=new lable("Page 2 :Additional Details :");
            page.setBounds(200,80,600,30);
            this.add(page);

            lable name1=new lable("Rilision :");
            name1.setBounds(20,150,150,20);
            this.add(name1);
            rilision.setBounds(250,150,200,30);
            this.add(rilision);

            String cc[]={"Genral","obc","st","sc","pwd","other"};
            catagry=new JComboBox<>(cc);
            lable fathername1=new lable("Catoriry :");
            fathername1.setBounds(20,200,150,20);
            this.add(fathername1);
            catagry.setBounds(250,200,200,30);
            this.add(catagry);

            String ii[]={"null","<100000","<200000","<500000","<1000000","infinite"};
            income=new JComboBox<>(ii);
            lable dob1=new lable("Income :");
            dob1.setBounds(20,250,200,20);
            this.add(dob1);
            income.setBounds(250,250,200,30);
            this.add(income);

            String eq[]={"ssc","hsc","under graduate","post graduate","phd","unpad"};
            education=new JComboBox<>(eq);
            lable gender2=new lable("Eductional");
            gender2.setBounds(20,300,200,20);
            this.add(gender2);
            lable gender3=new lable("Qulification :");
            gender3.setBounds(20,320,200,20);
            this.add(gender3);
            education.setBounds(250,300,200,30);
            this.add(education);

            String oo[]={"student","salaried","unemployed","businness","self employed","null"};
            ocupation=new JComboBox<>(oo);
            lable email1=new lable("Ocupation :");
            email1.setBounds(20,350,200,20);
            this.add(email1);
            ocupation.setBounds(250,350,200,30);
            this.add(ocupation);

            lable marage1=new lable("Pan Number :");
            marage1.setBounds(20,400,200,20);
            this.add(marage1);
            panno.setBounds(250,400,200,30);
            this.add(panno);

            lable address1=new lable("Aadhar Number : ");
            address1.setBounds(20,450,200,20);
            this.add(address1);
            aadharno.setBounds(250,450,200,30);
            this.add(aadharno);

            lable city1=new lable("Sinoir citizion :");
            city1.setBounds(20,500,200,20);
            this.add(city1);
            yesno.add(Yes);
            yesno.add(No);
            Yes.addActionListener(this);
            No.addActionListener(this);
            Yes.setBounds(250,500,50,20);
            No.setBounds(350,500,50,20);
            this.add(Yes);
            this.add(No);





            lable state1=new lable("Existing Acount :");
            state1.setBounds(20,550,220,20);
            this.add(state1);
            yesno1.add(Yes1);
            yesno1.add(No1);
            Yes1.addActionListener(this);
            No1.addActionListener(this);
            Yes1.setBounds(250,550,50,20);
            No1.setBounds(350,550,50,20);
            this.add(Yes1);
            this.add(No1);


            next.setBackground(Color.green);
            next.setBounds(450,700,80,40);
            next.setFont(new Font("Arial",Font.BOLD,15));
            this.add(next);

            back.setBackground(Color.red);
            back.setBounds(350,700,80,40);
            back.setFont(new Font("Arial",Font.BOLD,15));
            this.add(back);





            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(700,800);
            this.setLayout(null);

            next.addActionListener(this);

            this.setVisible(true);
        }
        String op1;
        String op2;
        String sql;
        @Override

        public void actionPerformed(ActionEvent e) {

            if (e.getSource()==Yes){
                op1="Yes";

            }
            if (e.getSource()==No){
                op1="No";
            }
            if (e.getSource()==Yes1){
                op2="Yes";
            }
            if (e.getSource()==No1){
                op2="No";
            }

            if (e.getSource() == next) {
                int p = 0;
                sql = "INSERT INTO sinuppage2 VALUES(" + i + ", '"+rilision.getSelectedItem() +"','"+catagry.getSelectedItem()+ "', '"+income.getSelectedItem()+"','"+education.getSelectedItem()+"','"+ocupation.getSelectedItem()+"','"
                        + aadharno.getText() + "', '" + panno.getText()+"','" +op1+"','"+op2+
                       "');";
                System.out.println(sql);
                sui(sql);
                sinuppage3 s=new sinuppage3(i);

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
       // sinuppage2 s=new sinuppage2();
    }
}
