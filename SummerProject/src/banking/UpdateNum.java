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
import java.time.format.*;
import javax.swing.*;

/**
 *
 * @author shivangini priya
 */
public class UpdateNum implements ActionListener{
    JFrame jf;
    JLabel jl,jl1,jl2,jl3;
    JTextField jtf1,jtf2,jtf3;
    JButton jb;
    ImageIcon i;
    JLabel Labell;
    UpdateNum(){
      jf = new JFrame("CONTACT UPDATION");
        jf.setSize(700,500);
        jf.setLayout(null);
        jf.setVisible(true); 
        jf.getContentPane().setBackground(Color.BLUE);
        
        i=new ImageIcon("C:\\Yes_Bank_logo.png");
       Labell=new JLabel(i);
       Labell.setBounds(460,5,230,60);
       Labell.setVisible(true);
       jf.add(Labell);
        
       jl = new JLabel("UPDATE YOUR CONTACT NUMBER");
       jl.setFont(new Font("Courier New", Font.BOLD, 28));
       jl.setForeground(Color.WHITE);
       jl.setBounds(20,20,450,50);
       jf.add(jl);
       
       jl1 = new JLabel("ACCOUNT NUMBER:");
        jl1.setBounds(20,100,200,50);
        jl1.setFont(new Font("Courier New", Font.PLAIN, 18));
       jl1.setForeground(Color.WHITE);
        jf.add(jl1);
        jtf1 = new JTextField("");
        jtf1.setBounds(270,100,100,50);
        jf.add(jtf1);
        
        jl2 = new JLabel("PREVIOUS PHONE NUMBER:");
        jl2.setBounds(20,180,250,50);
        jl2.setFont(new Font("Courier New", Font.PLAIN, 18));
       jl2.setForeground(Color.WHITE);
        jf.add(jl2);
        jtf2 = new JTextField("");
        jtf2.setBounds(270,180,100,50);
        jf.add(jtf2);
        
        jl3 = new JLabel("NEW PHONE NUMBER:");
        jl3.setBounds(20,260,200,50);
        jl3.setFont(new Font("Courier New", Font.PLAIN, 18));
       jl3.setForeground(Color.WHITE);
        jf.add(jl3);
        jtf3 = new JTextField("");
        jtf3.setBounds(270,260,100,50);
        jf.add(jtf3);
        
        jb = new JButton("UPPDATE");
        jb.setBounds(370,330,100,50);
        jf.add(jb);
        
        jb.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==jb){
            String acc = jtf1.getText();
            String pnum = jtf2.getText();
            String nNum = jtf3.getText();
              try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","12345");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	String datetime = dtf.format(now); //2016/11/16 12:08:43
        String request_type = "UPDATE ACCOUNT";
        String query = "insert into Admin_msgs values(?,?,?,default)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1,request_type);
        pst.setString(2, datetime);
        pst.setString(3, acc+","+pnum+","+nNum);
        pst.executeUpdate();
        pst.close();
        con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR"+e);
        }
        JOptionPane.showMessageDialog(new JFrame(),"THANKYOU...WE WILL PROCESS YOUR REQUEST.");
        }
    }
    public static void main(String s[]){
        new UpdateNum();
    }
}

