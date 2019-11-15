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

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author shivangini priya
 */
public class BankApp implements ActionListener{
    static JFrame jf;
    static JLabel jl1,jl2,jl3,jl4,Label;
    static JTextField jtf1,jtf2,jtf3;
    static JButton jb1,jb2,jb3;
    Connection con;
    PreparedStatement pst;
    ImageIcon i;
    
   BankApp(){
       
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","12345");
       
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(),"database not connected"+e);
        }
       jf = new JFrame("Bank App");
       jf.setSize(700,700);
       jf.setLayout(null);
       jf.setVisible(true);
       jf.getContentPane().setBackground(Color.BLUE);
       
       i=new ImageIcon("C:\\Yes_Bank_logo.png");
       Label=new JLabel(i);
       Label.setBounds(450,20,230,60);
       Label.setVisible(true);
       jf.add(Label);
       
       
       jl3 = new JLabel("WELCOME TO YES BANK!!");
       jl3.setFont(new Font("Courier New", Font.BOLD, 10));
       jl3.setForeground(Color.BLUE);
       jl3.setBounds(30,10,400,50);
       jf.add(jl3);
    
        jl1 = new JLabel("USERNAME");
        jl1.setBounds(200,200,100,50);
        jf.add(jl1);
        jl2 = new JLabel("PASSWORD");
        jl2.setBounds(200,270,100,50);
        jf.add(jl2);
        jtf1 = new JTextField("");
        jtf1.setBounds(320,200,100,50);
        jf.add(jtf1);
        jtf2 = new JTextField("");
        jtf2.setBounds(320,270,100,50);
        jf.add(jtf2);
        jb1 = new JButton("LOGIN");
        jb1.setBounds(200,340,100,50);
        jf.add(jb1);
        jb2 = new JButton("RESET");
        jb2.setBounds(330,340,100,50);
        jf.add(jb2);
        
        jl4 = new JLabel("DO NOT HAVE AN ACCOUNT?");
        jl4.setBounds(10,400,300,50);
        jf.add(jl4);
        jb3 = new JButton("SIGN UP");
        jb3.setBounds(200,400,100,50);
        jf.add(jb3);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
    }
   
    public void actionPerformed(ActionEvent ae){
	if(ae.getSource()==jb1){
            try{
	String u = jtf1.getText();
	String p = jtf2.getText();
        String query = "select * from Login_details where userid=?";
        pst = con.prepareStatement(query);
        pst.setString(1,u);
        ResultSet rs = pst.executeQuery();
        rs.next();
        if(p.equals(rs.getString("password"))){
        jf.setVisible(false);
        jf.dispose();
        new User();
        }
        else{
            JOptionPane.showMessageDialog(null,"Login Failed");
        }
        pst.close();
       
       }catch(Exception e){
          JOptionPane.showMessageDialog(new JFrame(),"ERROR"+e);
       }
        
        }
        if(ae.getSource()==jb2){
            jtf1.setText("");
            jtf2.setText("");
        }
        if(ae.getSource()==jb3){
            new SignUp();
        }
        }
	
    public static void main(String S[]){
        new BankApp();
    }
}
