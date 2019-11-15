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
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author shivangini priya
 */
public class Admin_DeleteAcc implements ActionListener{
    JFrame jf;
    JLabel jl,jl1;
    JTextField jtf1;
    JButton jb1,jb2;
    ImageIcon i;
    JLabel Labell;
    Admin_DeleteAcc(){
        jf = new JFrame("DELETE");
        jf.setSize(550,550);
        jf.setLayout(null);
        jf.setVisible(true);
        jf.getContentPane().setBackground(Color.BLUE);
        
        i=new ImageIcon("C:\\Yes_Bank_logo.png");
       Labell=new JLabel(i);
       Labell.setBounds(310,20,230,55);
       Labell.setVisible(true);
       jf.add(Labell);
        
        jl = new JLabel("DELETE ACCOUNT");
        jl.setBounds(30, 20, 400,50);
        jl.setFont(new Font("Courier New", Font.BOLD, 30));
        jl.setForeground(Color.WHITE);
        jf.add(jl);
        
        jl1 = new JLabel("ACCOUNT NUMBER:");
        jl1.setBounds(30,120,200,50);
        jl1.setFont(new Font("Courier New", Font.BOLD, 18));
        jl1.setForeground(Color.WHITE);
        jf.add(jl1);
        jtf1 = new JTextField("");
        jtf1.setBounds(220,120,120,50);
        jf.add(jtf1);
        
        jb1 = new JButton("VIEW ACCOUNT");
        jb1.setBounds(20,200,200,50);
        
        jf.add(jb1);
        jb2 = new JButton("DELETE");
        jb2.setBounds(230,200,100,50);
        jf.add(jb2);
        
        jb1.addActionListener(this);
        jb2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==jb1){
            //calls the transaction page
            //new Admin_transactions();
        }
        if(ae.getSource()==jb2){
            String acc = jtf1.getText();
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","12345");
            PreparedStatement pst = cn.prepareStatement("delete from customers where accno=?");
            pst.setString(1, acc);
            pst.executeUpdate();
            PreparedStatement pst1 = cn.prepareStatement("delete from Bank_Acc where accno=?");
            pst1.setString(1, acc);
            pst1.executeUpdate();
            PreparedStatement pst2 = cn.prepareStatement("delete from transactions where accno=?");
            pst2.setString(1, acc);
            pst2.executeUpdate();
            pst.close();
            pst1.close();
            pst2.close();
            cn.close();
            JOptionPane.showMessageDialog(new JFrame(),"ACCOUNT DELETED");
           
            }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR"+e);
        }
        }
    }
    public static void main(String s[]){
        new Admin_DeleteAcc();
    }
}

