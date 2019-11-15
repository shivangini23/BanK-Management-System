
package banking;

/**
 *
 * @author sanu
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

/**
 *
 * @author shivangini priya
 */
public class DepWith implements ActionListener{
    JFrame jf;
    JLabel jl1,jl2,jl3;
    JTextField jtf1,jtf2,jtf3;
    JButton jb1,jb2;
    ImageIcon i1;
    JLabel Label2;
    DepWith(){
        jf = new JFrame("Deposit or Withdraw");
        jf.setSize(500,500);
        jf.setVisible(true);
        jf.setLayout(null);
        jf.setResizable(true);
        jf.getContentPane().setBackground(Color.BLUE);
        
       i1=new ImageIcon("C:\\Yes_bank_logo.png");
       Label2=new JLabel(i1);
       Label2.setBounds(280,5,200,60);
       Label2.setVisible(true);
       jf.add(Label2);
        
        jl1 = new JLabel("ACCOUNT NUMBER:");
        jl1.setBounds(20,70,170,50);
        jl1.setFont(new Font("SANS-SERIF",Font.BOLD, 16));
        jl1.setForeground(Color.WHITE);
        jf.add(jl1);
        jtf1 = new JTextField("");
        jtf1.setBounds(200,70,100,50);
        jf.add(jtf1);
        jl2 = new JLabel("PIN:");
        jl2.setBounds(20,140,100,50);
        jl2.setFont(new Font("SANS-SERIF",Font.BOLD, 16));
        jl2.setForeground(Color.WHITE);
        jf.add(jl2);
        jtf2 = new JTextField("");
        jtf2.setBounds(200,140,100,50);
        jf.add(jtf2);
        jl3 = new JLabel("ENTER AMT:");
        jl3.setBounds(20,210,100,50);
        jl3.setFont(new Font("SANS-SERIF",Font.BOLD, 16));
        jl3.setForeground(Color.WHITE);
        jf.add(jl3);
        jtf3 = new JTextField("");
        jtf3.setBounds(200,210,100,50);
        jf.add(jtf3);
        jb1 = new JButton("DEPOSIT");
        jb1.setBounds(20,280,100,50);
        jf.add(jb1);
        jb2 = new JButton("WITHDRAW");
        jb2.setBounds(180,280,100,50);
        jf.add(jb2);
        
        jb1.addActionListener(this);
        jb2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        double amt = Double.parseDouble(jtf3.getText());
        String acc = jtf1.getText();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String datetime = dtf.format(now);
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","12345");
        
            String query = "select * from Bank_Acc where accno=?";
            PreparedStatement pst1 = con.prepareStatement(query);            
            pst1.setString(1,acc);
            ResultSet rs = pst1.executeQuery();
            rs.next();
            double bal = rs.getDouble("balance");
            int pin = rs.getInt("PIN");
            String q = "insert into transactions values(?,?,?,?,?,?)";
            PreparedStatement pst2 = con.prepareStatement(q);
            pst2.setString(1,acc);
            pst2.setDouble(2,bal);
            pst2.setString(6, datetime);
            if(ae.getSource()==jb1){
            if(pin ==Integer.parseInt(jtf2.getText())){
            bal = bal +  amt;}
            else{
                JOptionPane.showMessageDialog(null,"INCORRECT PIN");
            }
            pst2.setString(3, "DEPOSIT");
            pst2.setDouble(4, amt);
            pst2.setDouble(5, bal);
            pst2.executeUpdate();
            }
            
            
            if(ae.getSource()==jb2){
            if(pin ==Integer.parseInt(jtf2.getText())){
            bal = bal -  amt;}
             else{
                JOptionPane.showMessageDialog(null,"INCORRECT PIN");
            }
            pst2.setString(3, "WITHDRAW");
            pst2.setDouble(4, amt);
            pst2.setDouble(5, bal);
            pst2.executeUpdate();
            }

            pst1.close();
            pst2.close();
            con.close();
            new Admin(bal,acc);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"ERROR"+e);
            }
            
            
           
    }
    public static void main(String s[]){
        new DepWith();
    }
}