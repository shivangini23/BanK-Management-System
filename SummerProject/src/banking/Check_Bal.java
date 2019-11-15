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
public class Check_Bal implements ActionListener{
    JFrame jf;
    JLabel jl1,jl2,jl3,jl4,jl5;
    JTextField jtf1,jtf2,jtf3;
    JButton jb;
    Check_Bal(){
        jf = new JFrame("Check Balance");
        jf.setLayout(null);
        jf.setSize(500,500);
        jf.setVisible(true);
        jf.setResizable(true);
        jf.getContentPane().setBackground(Color.BLUE);
        
        jl1 = new JLabel("PLEASE ENTER YOUR DETAILS");
        jl1.setBounds(10, 20, 400,50);
        jl1.setFont(new Font("Courier New", Font.BOLD, 24));
        jl1.setForeground(Color.WHITE);
        jf.add(jl1);
        
        jl2 = new JLabel("ACCOUNT NUMBER:");
        jl2.setBounds(10,80,200,50);
        jl2.setFont(new Font("Courier New", Font.PLAIN, 18));
        jl2.setForeground(Color.WHITE);
        jf.add(jl2);
        jl3 = new JLabel("NAME:");
        jl3.setBounds(10,140,100,50);
        jl3.setFont(new Font("Courier New", Font.PLAIN, 18));
        jl3.setForeground(Color.WHITE);
        jf.add(jl3);
        jl4 = new JLabel("Press Enter");
        jl4.setBounds(10,200,150,50);
        jl4.setFont(new Font("Courier New", Font.PLAIN,18));
        jl4.setForeground(Color.WHITE);
        jf.add(jl4);
        jb = new JButton("ENTER");
        jb.setBounds(220,200,100,50);
        jf.add(jb);
        jl5 = new JLabel("Your account bal:");
        jl5.setBounds(10,260,200,50);
        jl5.setFont(new Font("Courier New", Font.PLAIN, 18));
        jl5.setForeground(Color.WHITE);
        jf.add(jl5);
        
        jtf1 = new JTextField("");
        jtf1.setBounds(220,80,100,50);
        jf.add(jtf1);
        jtf2 = new JTextField("");
        jtf2.setBounds(220,140,100,50);
        jf.add(jtf2);
        jtf3 = new JTextField("");
        jtf3.setBounds(220,260,100,50);
        jf.add(jtf3);
        
        jb.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==jb){
            try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","12345");
        
	String accno = jtf1.getText();
	String name = jtf2.getText();
        String query = "select * from Bank_Acc where accno=?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1,accno);
        ResultSet rs = pst.executeQuery();
        rs.next();
        jtf3.setText(rs.getString("balance"));
        pst.close();
        con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR:"+e);}
    }
}
    public static void main(String s[]){
        new Check_Bal();
    }
}

