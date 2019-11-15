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

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author shivangini priya
 */
public class Admin {
    String accnum;
    float balance=1000.0f;
    String gen_accno(){
        String a = "0123456789";
        char [] num = new char[11];
        for(int i=0;i<11;i++){
            int ch = (int)(Math.random()*a.length());
            num[i]=a.charAt(ch);
        }
        String accno = new String(num);
        return accno;
    
    }
    
   
   
    Admin(String name,int pin){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","12345");
        accnum = gen_accno();

        PreparedStatement pst2 = con.prepareStatement("insert into Bank_Acc values(?,?,?,?)");
        pst2.setString(1, accnum);
        pst2.setString(2,name);
        pst2.setFloat(3,balance);
        pst2.setInt(4,pin);
        pst2.executeUpdate();
        pst2.close();
        con.close();
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR"+e);
        } 
    }
    
    Admin(double balance,String acc){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","12345");
            PreparedStatement pst = con.prepareStatement("update Bank_Acc set balance=? where accno=?");
            pst.setDouble(1,balance);
            pst.setString(2,acc);
            pst.executeUpdate();
            
         
            pst.close();
            con.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"ERRO"
                        + "R"+e);
            }
    }
     Admin(String acc,String phone){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","12345");
            PreparedStatement pst = con.prepareStatement("update customers set phone=? where accno=?");
            pst.setString(1,phone);
            pst.setString(2,acc);
            pst.executeUpdate();
            pst.close();
            con.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"ERROR"+e);
            }
    }
}

