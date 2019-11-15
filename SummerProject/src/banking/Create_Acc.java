/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

/**
 *
 * @author sanu
 */

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

/**
 *
 * @author shivangini priya
 */
public class Create_Acc implements ActionListener{
    JFrame jf;
    JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9;
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8,jtfmail,jtfpic;
    JButton jb,jb1;
    ImageIcon i1;
    JLabel label2;

    
    Create_Acc(){
       jf = new JFrame("Create new Account");
       jf.setVisible(true);
       jf.setSize(610,600);
       jf.setLayout(null);
       jf.setResizable(true);
       
       i1=new ImageIcon("C:\\Yes_bank_logo.png");
       label2=new JLabel(i1);
       label2.setBounds(380,5,230,60);
       label2.setVisible(true);
       jf.add(label2);
       jf.getContentPane().setBackground(Color.BLUE);
       
       jl1 = new JLabel("Enter Your Personal Details");
       jl1.setBounds(10,10,400,50);
       jl1.setFont(new Font("Courier New", Font.BOLD, 24));
       jl1.setForeground(Color.WHITE);
       jf.add(jl1);
       
       jl2 = new JLabel("NAME: ");
       jl2.setBounds(10,70,100,50);
       jl2.setFont(new Font("Courier New", Font.BOLD, 18));
       jl2.setForeground(Color.WHITE);
       jf.add(jl2);
       jtf1 = new JTextField("");
       jtf1.setBounds(120,70,100,50);
       jf.add(jtf1);
       jl3 = new JLabel("AGE: ");
       jl3.setBounds(230,70,100,50);
       jl3.setFont(new Font("Courier New", Font.BOLD, 18));
       jl3.setForeground(Color.WHITE);
       jf.add(jl3);
       jtf2 = new JTextField("");
       jtf2.setBounds(340,70,100,50);
       jf.add(jtf2);
       jl4 = new JLabel("GENDER: ");
       jl4.setBounds(10,140,100,50);
       jl4.setFont(new Font("Courier New", Font.BOLD, 18));
       jl4.setForeground(Color.WHITE);
       jf.add(jl4);
       jtf3 = new JTextField("");
       jtf3.setBounds(120,140,100,50);
       
       jf.add(jtf3);
       jl5 = new JLabel("PHONE: ");
       jl5.setBounds(230,140,100,50);
       jl5.setFont(new Font("Courier New", Font.BOLD, 18));
       jl5.setForeground(Color.WHITE);
       jf.add(jl5);
       jtf4 = new JTextField("");
       jtf4.setBounds(340,140,100,50);
       jf.add(jtf4);
       jl6 = new JLabel("STREET: ");
       jl6.setBounds(10,210,100,50);
       jl6.setFont(new Font("Courier New", Font.BOLD, 18));
       jl6.setForeground(Color.WHITE);
       jf.add(jl6);
       jtf5 = new JTextField("");
       jtf5.setBounds(120,210,100,50);
       jf.add(jtf5);
       jl2 = new JLabel("CITY: ");
       jl2.setBounds(230,210,100,50);
       jl2.setFont(new Font("Courier New", Font.BOLD, 18));
       jl2.setForeground(Color.WHITE);
       jf.add(jl2);
       jtf6 = new JTextField("");
       jtf6.setBounds(340,210,100,50);
       jf.add(jtf6);
       jl7 = new JLabel("STATE: ");
       jl7.setBounds(10,280,100,50);
       jl7.setFont(new Font("Courier New", Font.BOLD, 18));
       jl7.setForeground(Color.WHITE);
       jf.add(jl7);
       jtf7 = new JTextField("");
       jtf7.setBounds(120,280,100,50);
       jf.add(jtf7);
       
       jl8 = new JLabel("Enter PIN:");
       jl8.setBounds(10,350,150,50);
       jl8.setFont(new Font("Courier New", Font.BOLD, 18));
       jl8.setForeground(Color.WHITE);
       jf.add(jl8);
       jtf8 = new JTextField("");
       jtf8.setBounds(170,350,100,50);
       jf.add(jtf8);
       
       jl9 = new JLabel("EMAIL:");
       jl9.setBounds(10,420,70,50);
       jl9.setFont(new Font("Courier New", Font.BOLD, 18));
       jl9.setForeground(Color.WHITE);
       jf.add(jl9);
       jtfmail = new JTextField("");
       jtfmail.setBounds(90,420,180,50);
       jf.add(jtfmail);
       
       jtfpic = new JTextField("");
       jtfpic.setBounds(350,340,200,50);
       jf.add(jtfpic);
       
       
       jb = new JButton("CREATE ACCOUNT");
       jb.setBounds(350,450,200,50);
       jf.add(jb);
       jb1 = new JButton("UPLOAD PIC");
       jb1.setBounds(350,390,200,50);
       jf.add(jb1);
       
       
       jb.addActionListener(this);
       jb1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==jb){
                     String name = jtf1.getText();
          String age = jtf2.getText();
          String gender = jtf3.getText();
          String phone = jtf4.getText();
          String street = jtf5.getText();
          String city = jtf6.getText();
          String state = jtf7.getText();
          String photo = jtfpic.getText();
          String pin = jtf8.getText();
          String email = jtfmail.getText();
          String info = name+","+age+","+gender+","+street+","+city+","+state+","+phone+","+photo+","+pin+","+email;
           try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","12345");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	String datetime = dtf.format(now); //2016/11/16 12:08:43
        String request_type = "CREATE ACCOUNT";
        String query = "insert into Admin_msgs values(?,?,?,default)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1,request_type);
        pst.setString(2, datetime);
        pst.setString(3, info);
        pst.executeUpdate();
        pst.close();
        con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR"+e);
        } 
        JOptionPane.showMessageDialog(new JFrame(),"THANKYOU...WE WILL PROCESS YOUR REQUEST.");
      
        }
        if(ae.getSource()==jb1){
            JFileChooser jfc = new JFileChooser();
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			if (jfc.getSelectedFile().isDirectory()) {
			   jtfpic.setText(jfc.getSelectedFile().getPath());
			}
                }
        }
    }
    
       
    public static void main(String s[]){
        new Create_Acc();
    }
}

