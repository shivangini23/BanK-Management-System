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
import javax.swing.*;

/**
 *
 * @author shivangini priya
 */
public class Admin_UpdateAcc implements ActionListener{
    JFrame jf;
    JLabel jl,jl1,jl2,jl3,jl4,Labell;
    JTextField jtf1,jtf2,jtf3;
    JButton jb;
    ImageIcon i;
    Admin_UpdateAcc(){
        jf = new JFrame("UPDATE");
        jf.setSize(550,550);
        jf.setLayout(null);
        jf.setVisible(true); 
        jf.getContentPane().setBackground(Color.BLUE);
        
        i=new ImageIcon("C:\\Yes_Bank_logo.png");
        Labell=new JLabel(i);
        Labell.setBounds(280,20,230,60);
        Labell.setVisible(true);
        jf.add(Labell);
       
        jl = new JLabel("UPDATE PHONE NUMBER");
        jl.setBounds(20, 30, 400, 50);
        jl.setFont(new Font("Courier New", Font.BOLD, 28));
        jl.setForeground(Color.BLUE);
        jf.add(jl);
        
        jl1 = new JLabel("ACCOUNT NUMBER:");
        jl1.setBounds(20,100,200,50);
        jf.add(jl1);
        jtf1 = new JTextField("");
        jtf1.setBounds(230,100,100,50);
        jf.add(jtf1);
        
        jl2 = new JLabel("PREVIOUS CONTACT NUMBER:");
        jl2.setBounds(20,180,200,50);
        jf.add(jl2);
        jtf2 = new JTextField("");
        jtf2.setBounds(230,180,100,50);
        jf.add(jtf2);
        
        jl3 = new JLabel("NEW CONTACT NUMBER:");
        jl3.setBounds(20,260,200,50);
        jf.add(jl3);
        jtf3 = new JTextField("");
        jtf3.setBounds(230,260,100,50);
        jf.add(jtf3);
        
        jl4 = new JLabel("PRESS TO UPDATE");
        jl4.setBounds(20,330,200,50);
        jf.add(jl4);
        jb = new JButton("UPDATE");
        jb.setBounds(230,330,100,50);
        jf.add(jb);
        
        jb.addActionListener(this);
    }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==jb){
              try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","12345");
            PreparedStatement pst = cn.prepareStatement("select * from Admin_msgs where RequestType=?",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, "UPDATE ACCOUNT");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
            
            String num = rs.getString("info");
            String arr[] = num.split(",");
            jtf1.setText(arr[0]);
            jtf2.setText(arr[1]);
            jtf3.setText(arr[2]);
            new Admin(arr[0],arr[2]);
            rs.deleteRow();
            JOptionPane.showMessageDialog(new JFrame(),"PHONE NUMBER UPDATED");
            sendEmailForAccUpdation(arr[0]);
            }
            else{
                JOptionPane.showMessageDialog(new JFrame(),"ALL NUMBERS UPDATED");
            }
            }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR"+e);
        }
         }
     }
      public void sendEmailForAccUpdation(String name){
        try{
            String a = jtf1.getText();
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","12345");
            PreparedStatement pst = cn.prepareStatement("select * from login_details where accno=?");
            pst.setString(1, a);
            ResultSet rs = pst.executeQuery();
            rs.next();
            String mail = rs.getString("emailID");
            String Subject = "Yes Bank Account Updation Success.";
            String body = "Dear "+name+",\n Your request to update your contact number is succesful."+
                    " You can now start operating from your new phone number";
            sendMail s = new sendMail();
            s.sendFromGMail(mail,Subject,body);
            pst.close();
            cn.close();
            
            }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR"+e);
        }
    }
}

