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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;


/**
 *
 * @author shivangini priya
 */
public class Admin_CreateAcc implements ActionListener{
    JFrame jf;
    JLabel jl1,jl2,jl3,jl4;
    JComboBox jcb1;
    String Branches[]={"NEW DELHI","NOIDA","GURGAON","PATNA"};
    JTextField jtf1,jtf2;
    JButton jb1;
    ImageIcon i;
    JLabel Labell;
    Admin_CreateAcc(){
       jf = new JFrame("ADMIN PAGE");
       jf.setSize(550,550);
       jf.setLayout(null);
       jf.setVisible(true);
       jf.getContentPane().setBackground(Color.BLUE);
       
       i=new ImageIcon("C:\\Yes_Bank_logo.png");
       Labell=new JLabel(i);
       Labell.setBounds(300,10,230,60);
       Labell.setVisible(true);
       jf.add(Labell);
       
       jl1 = new JLabel("ADD A NEW ACCOUNT");
       jl1.setBounds(20,20,300,50);
       jl1.setFont(new Font("Courier New", Font.BOLD, 27));
       jl1.setForeground(Color.WHITE);
       jf.add(jl1);
       
       jl2 = new JLabel("ACCOUNT AT:");
       jl2.setBounds(20,100,150,50);
       jl2.setFont(new Font("Courier New", Font.BOLD, 18));
       jl2.setForeground(Color.WHITE);
       jf.add(jl2);
       jcb1 = new JComboBox(Branches);
       jcb1.setBounds(180,100,100,50);
       jf.add(jcb1);
       
       jl3 = new JLabel("ACCOUNT NO:");
       jl3.setBounds(20,160,150,50);
       jl3.setFont(new Font("Courier New", Font.BOLD, 18));
       jl3.setForeground(Color.WHITE);
       jf.add(jl3);
       jtf1 = new JTextField("");
       jtf1.setBounds(180,160,100,50);
       jf.add(jtf1);
       
       jl4 = new JLabel("NAME:");
       jl4.setBounds(20,220,150,50);
       jl4.setFont(new Font("Courier New", Font.BOLD, 18));
       jl4.setForeground(Color.WHITE);
       jf.add(jl4);
       jtf2 = new JTextField("");
       jtf2.setBounds(180,220,100,50);
       jf.add(jtf2);
       
       jb1 = new JButton("ADD");
       jb1.setBounds(100,290,100,50);
       jf.add(jb1);
       //jb2 = new JButton("SAVE");
       //jb2.setBounds(130,290,100,50);
       //jf.add(jb2);
       
       jb1.addActionListener(this);
       //jb2.addActionListener(this);
    }
    //@SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==jb1){
           try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","12345");
            PreparedStatement pst = cn.prepareStatement("select * from Admin_msgs where RequestType=?",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, "CREATE ACCOUNT");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
            String Dt = rs.getString("ReqDateTime");
            String cust = rs.getString("info");
            String arr[] = cust.split(",");
            Admin a = new Admin(arr[0],Integer.parseInt(arr[8]));
            jtf1.setText(a.accnum);
            jtf2.setText(arr[0]);
            new Account(arr[0],a.accnum,arr[1],arr[2],arr[6],arr[3],arr[4],arr[5],arr[7],arr[9]);
            rs.deleteRow();
            JOptionPane.showMessageDialog(new JFrame(),"ACCOUNT CREATED");
            sendEmailForAccCreation(a.accnum,arr[0]);
            pst.close();
            cn.close();
            }
            else{
                JOptionPane.showMessageDialog(new JFrame(),"ALL REQUESTS SATISFIED");
            }
            }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR"+e);
        }
        }
        
    }
   
    public void sendEmailForAccCreation(String acc,String name){
        try{
  
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","12345");
            PreparedStatement pst = cn.prepareStatement("select * from login_details where accno=?");
            pst.setString(1, acc);
            ResultSet rs = pst.executeQuery();
            rs.next();
            String mail = rs.getString("emailID");
            String Subject = "Yes Bank Account Creation Success.";
            String body = "Dear "+name+",\n Thanks for choosing us. Your request to create a new savings account is succesful."+
                    " Your new savings account number is: "+ acc+ ".";
            sendMail s = new sendMail();
            s.sendFromGMail(mail,Subject,body);
            pst.close();
            cn.close();
            
            }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR"+e);
        }
    }
    public static void main(String args[]){
        new Admin_CreateAcc();
    }
}
