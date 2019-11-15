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

import java.sql.*;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author shivangini priya
 */
public class Account {
 
  
    
    Account(String name,String anum,String age,String gender,String phone,String street,String city,String state,String photo,String email){
       
        try{
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","12345");
       
        String query = "insert into customers values(?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement pst1 = con.prepareStatement(query);
        pst1.setString(1, anum);
        pst1.setString(2, name);
        pst1.setString(3, age);
        pst1.setString(4, gender);
        pst1.setString(5, street);
        pst1.setString(6, city);
        pst1.setString(7, state);
        pst1.setString(8, phone);
        pst1.setString(9, email);
        pst1.setString(10,photo);
        pst1.executeUpdate();
        JOptionPane.showMessageDialog(null,"SUCCESS");

    
        pst1.close();
     
        con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR"+e);
        } 
    }

    
}

