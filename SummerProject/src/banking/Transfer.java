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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author shivangini priya
 */
public class Transfer implements ActionListener{
    JFrame jf;
    JLabel jl1,jl2,jl3,jl4,jl5,jl6;
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5;
    JButton jb;
    ImageIcon i1;
    JLabel Label2;
    Transfer(){
       jf = new JFrame("Transfer Money");
        jf.setSize(600,500);
        jf.setVisible(true);
        jf.setLayout(null);
        jf.setResizable(true); 
        jf.getContentPane().setBackground(Color.BLUE);
        
        i1=new ImageIcon("C:\\Yes_bank_logo.png");
       Label2=new JLabel(i1);
       Label2.setBounds(370,5,200,60);
       Label2.setVisible(true);
       jf.add(Label2);
        
        jl1 = new JLabel("ENTER YOUR ACC NO:");
        jl1.setBounds(10,50,200,50);
        jl1.setFont(new Font("SANS-SERIF",Font.PLAIN, 15));
        jf.add(jl1);
        jtf1 = new JTextField("");
        jtf1.setBounds(260,50,100,50);
        jf.add(jtf1);
        
        jl2 = new JLabel("ENTER PIN:");
        jl2.setBounds(10,110,100,50);
        jl2.setFont(new Font("SANS-SERIF",Font.PLAIN, 15));
        jf.add(jl2);
        jtf2 = new JTextField("");
        jtf2.setBounds(260,110,100,50);
        jf.add(jtf2);
        
        jl3 = new JLabel("RECIPIENTS ACCOUNT NO:");
        jl3.setBounds(10,170,200,50);
        jl3.setFont(new Font("SANS-SERIF",Font.PLAIN, 15));
        jf.add(jl3);
        jtf3 = new JTextField("");
        jtf3.setBounds(260,170,100,50);
        jf.add(jtf3);
        
        jl4 = new JLabel("RECIPIENTS NAME:");
        jl4.setBounds(10,230,200,50);
        jl4.setFont(new Font("SANS-SERIF",Font.PLAIN, 15));
        jf.add(jl4);
        jtf4 = new JTextField("");
        jtf4.setBounds(260,230,100,50);
        jf.add(jtf4);
        
        jl5 = new JLabel("ENTER AMT TO TRANSFER:");
        jl5.setBounds(10,290,200,50);
        jl5.setFont(new Font("SANS-SERIF",Font.PLAIN, 15));
        jf.add(jl5);
        jtf5 = new JTextField("");
        jtf5.setBounds(260,290,100,50);
        jf.add(jtf5);
        
        jl6 = new JLabel("PRESS TO TRANSFER AMT..");
        jl6.setBounds(10,360,200,50);
        jl6.setFont(new Font("SANS-SERIF",Font.PLAIN, 15));
        jf.add(jl6);
        jb = new JButton("TRANSFER");
        jb.setBounds(260,360,150,50);
        jf.add(jb);
        jb.addActionListener(this);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==jb){
            String acc1 = jtf1.getText();
            String acc2 = jtf3.getText();
            int pin = Integer.parseInt(jtf2.getText());
            double amt = Double.parseDouble(jtf5.getText());
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
("jdbc:mysql://localhost:3306/Bank","root","12345");
        
            String query = "select * from Bank_Acc where accno=?";
            PreparedStatement pst1 = con.prepareStatement(query);        
    
            pst1.setString(1,acc1);
            ResultSet rs = pst1.executeQuery();
            rs.next();
            double bal = rs.getDouble("balance");
            int p = rs.getInt("PIN");
           
            if(p == pin){
            bal = bal -  amt;}
            
            else{
                JOptionPane.showMessageDialog(null,"INCORRECT PIN");
            }
            new Admin(bal,acc1);
            
            String query2 = "select * from Bank_Acc where accno=?";
            PreparedStatement pst2 = con.prepareStatement(query2);      
      
            pst2.setString(1,acc2);
            ResultSet rs1 = pst2.executeQuery();
            rs1.next();
            double bal2 = rs1.getDouble("balance");
            bal2 = bal2 + amt;
            new Admin(bal2,acc2);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"ERROR"+e);
            }
            JOptionPane.showMessageDialog(null,"Tranfer Succesfull");
        }
    }
    public static void main(String args[]){
        new Transfer();
    }
}

