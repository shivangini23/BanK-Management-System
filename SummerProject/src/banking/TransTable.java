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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.ResultSet;

public class TransTable {
     
    JFrame jf1;
    JTable table;
    JPanel panel;
    
    Connection cn1;
    PreparedStatement pst2;
    String[] columns={"ACC NO","OLD BAL","DEP-WITH","AMT","NEW BAL","DATE TIME"};
    
    
    TransTable(String accnumber,String from,String to){
        
        jf1=new JFrame("TRANSACTIONS");
        jf1.setSize(800,700);
        jf1.setVisible(true);
        jf1.setLayout(null);
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            cn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","12345");
            
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(),"database not connected"+e);
        }
        
        showtable(accnumber,from,to);
        
        
        
    }

public void showtable(String accnumber,String from,String to){
    
       jf1.setLayout(new BorderLayout());
       DefaultTableModel model=new DefaultTableModel();
       model.setColumnIdentifiers(columns);
       table=new JTable();
       
       table.setModel(model);
       table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
       table.setFillsViewportHeight(true);
       JScrollPane scroll=new JScrollPane(table);
       scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       jf1.add(table);
      
       String a="";
       String b="";
       String c="";
       String d="";
       String e="";
       String f="";
       
       try{
           String sql="select * from transactions where DateTime >= ? and DateTime <= ?";
           PreparedStatement pst=cn1.prepareStatement(sql);
            
           //pst.setString(1,accnumber);
           pst.setString(1,from);
           pst.setString(2, to);
           ResultSet rs=pst.executeQuery();
           
           int i=0;
           model.addRow(new Object[]{"ACC NO","OLD BAl","DEP-WITH","AMT","NEW BAL","DATE TIME"});
           while(rs.next())
           {
               a=rs.getString("accno");
               b=rs.getString("OldBalance");
               c=rs.getString("DepWith");
               d=rs.getString("Amount");
               e=rs.getString("NewBalance");
               f=rs.getString("DateTime");
                model.addRow(new Object[]{a,b,c,d,e,f});
               i++;
           }
       }
       catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null,ex);
       }
    
    

}
   
}

