/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author shivangini priya
 */
public class SignUp implements ActionListener{
    JFrame jf;
    JLabel jl,jl1,jl2,jl3,jl4;
    JTextField jtf1,jtf2,jtfmail;
    JPasswordField jpf2;
    JButton jb1,jb2,jb3;
    ImageIcon i;
    JLabel Labell;
    SignUp(){
       jf = new JFrame("SignUp");
       jf.setSize(500,500);
       jf.setLayout(null);
       jf.setVisible(true);
       jf.setResizable(false);
       jf.getContentPane().setBackground(Color.BLUE);
        
        i=new ImageIcon("C:\\Yes_Bank_logo.png");
       Labell=new JLabel(i);
       Labell.setBounds(280,5,230,60);
       Labell.setVisible(true);
       jf.add(Labell);
        
       jl = new JLabel("PLEASE SIGN UP!!!");
       jl.setFont(new Font("Courier New", Font.BOLD, 24));
       jl.setForeground(Color.WHITE);
       jl.setBounds(10,20,250,50);
       jf.add(jl);
       
       jl1 = new JLabel("ACC NO");
       jl1.setBounds(10,80,100,50);
       jl1.setFont(new Font("Courier New", Font.BOLD, 20));
       jl1.setForeground(Color.WHITE);
       jf.add(jl1);
       jtf1 = new JTextField("");
       jtf1.setBounds(150,80,100,50);
       jf.add(jtf1);
       jl2 = new JLabel("USERNAME");
       jl2.setBounds(10,140,100,50);
       jl2.setFont(new Font("Courier New", Font.BOLD, 20));
       jl2.setForeground(Color.WHITE);
       jf.add(jl2);
       jtf2 = new JTextField("");
       jtf2.setBounds(150,140,100,50);
       jf.add(jtf2);
       jl3 = new JLabel("PASSWORD");
       jl3.setBounds(10,200,150,50);
       jl3.setFont(new Font("Courier New", Font.BOLD, 20));
       jl3.setForeground(Color.WHITE);
       jf.add(jl3);
       jpf2 = new JPasswordField("");
       jpf2.setBounds(150,200,100,50);
       jpf2.setEchoChar('*');
       jf.add(jpf2);
       
       
       jl4 = new JLabel("EMAIL");
       jl4.setBounds(10,260,100,50);
       jl4.setFont(new Font("Courier New", Font.BOLD, 20));
       jl4.setForeground(Color.WHITE);
       jf.add(jl4);
       jtfmail = new JTextField("");
       jtfmail.setBounds(150,260,200,50);
       jf.add(jtfmail);
       
       jb1 = new JButton("SHOW");
       jb1.setBounds(260,200,80,50);
       jf.add(jb1);
       
       jb2 = new JButton("SIGN UP");
       jb2.setBounds(150,320,100,50);
       jf.add(jb2);
       
    
       jb1.addActionListener(this);
       jb2.addActionListener(this);
       
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==jb1){
            
        }
        if(ae.getSource()==jb2){
            try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","12345");
        String acc = jtf1.getText();
        String username = jtf1.getText();
        String pass = String.copyValueOf(jpf2.getPassword());
        String email = jtfmail.getText();
        if(pass.length()>8){
           JOptionPane.showMessageDialog(new JFrame(),"Password should be less than 8 characters!!!");
       }
        else{
        String query = "insert into login_details values(?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1,acc);
        pst.setString(2, username);
        pst.setString(3, pass);
        pst.setString(4, email);
        pst.executeUpdate();
        pst.close();
        con.close();}
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR"+e);
        }
        }
       
    }
    public static void main(String args[]){
        new SignUp();
    }
}
