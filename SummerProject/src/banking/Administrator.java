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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shivangini priya
 */
public class Administrator implements ActionListener{
   JFrame jf;
   JLabel jl,jlupdate,jldelete,jlview,jladd,Labell;
   JButton jb,jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8;
   ImageIcon i;
   Administrator(){
       jf = new JFrame("ADMIN PAGE");
       jf.setSize(700,700);
       jf.setLayout(null);
       jf.setVisible(true);
       jf.getContentPane().setBackground(Color.BLUE);
        
        i=new ImageIcon("C:\\Yes_Bank_logo.png");
       Labell=new JLabel(i);
       Labell.setBounds(450,20,230,60);
       Labell.setVisible(true);
       jf.add(Labell);
       
       jl = new JLabel("ADMIN WINDOW");
       jl.setFont(new Font("Courier New", Font.BOLD, 50));
       jl.setForeground(Color.WHITE);
       jl.setBounds(80,25,500,70);
       jf.add(jl);
       
       
       jladd = new JLabel("ADD ACCOUNT");
       jladd.setFont(new Font("Courier New", Font.BOLD, 20));
       jladd.setForeground(Color.WHITE);
       jladd.setBounds(10,220,200,50);
       jf.add(jladd);
       jlupdate = new JLabel("UPDATE ACCOUNT");
       jlupdate.setFont(new Font("Courier New", Font.BOLD, 20));
       jlupdate.setForeground(Color.WHITE);
       jlupdate.setBounds(10,290,200,50);
       jf.add(jlupdate);
       jldelete = new JLabel("DELETE ACCOUNT");
       jldelete.setFont(new Font("Courier New", Font.BOLD, 20));
       jldelete.setForeground(Color.WHITE);
       jldelete.setBounds(10,360,200,50);
       jf.add(jldelete);
       jlview = new JLabel("VIEW USERS");
       jlview.setFont(new Font("Courier New", Font.BOLD, 20));
       jlview.setForeground(Color.WHITE);
       jlview.setBounds(10,430,200,50);
       jf.add(jlview);
       
       jb = new JButton("REQUESTS");
       jb.setBounds(370,85,100,50);
       jf.add(jb);
       jb1 = new JButton("HOME");
       jb1.setBounds(470,85,100,50);
       jf.add(jb1);
       jb2 = new JButton("LOGOUT");
       jb2.setBounds(570,85,100,50);
       jf.add(jb2);
       
       
       jb4 = new JButton("ADD");
       jb4.setBounds(220,220,100,50);
       jf.add(jb4);
       jb5 = new JButton("UPDATE");
       jb5.setBounds(220,290,100,50);
       jf.add(jb5);
       jb6 = new JButton("DELETE");
       jb6.setBounds(220,360,100,50);
       jf.add(jb6);
       jb7 = new JButton("VIEW");
       jb7.setBounds(220,430,100,50);
       jf.add(jb7);
       
       jb.addActionListener(this);
       jb1.addActionListener(this);
       jb2.addActionListener(this);
       
       jb4.addActionListener(this);
       jb5.addActionListener(this);
       jb6.addActionListener(this);
       jb7.addActionListener(this);
       
   }
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==jb){ //REQUESTS
           showRequestData();
       }
       if(ae.getSource()==jb1){ //HOME
          new BankFP();
           jf.setVisible(false);
           jf.dispose();
       }
       if(ae.getSource()==jb2){ //LOGOUT
           new BankApp();
           jf.setVisible(false);
           jf.dispose();
       }
       
       if(ae.getSource()==jb4){
       new Admin_CreateAcc();
   }
       if(ae.getSource()==jb5){
       new Admin_UpdateAcc();
   }
       if(ae.getSource()==jb6){
       new Admin_DeleteAcc();
   }
       if(ae.getSource()==jb7){ //VIEW USERS
           showTableData();
       }
   }
    public void showTableData(){
            JFrame jf1 = new JFrame("USERS");
            jf1.setVisible(true);
            jf1.setLayout(null);
            jf1.setSize(400,400);
            String cols[] = {"Name","Accno","id","gender","street","city","state","phone"};
            jf1.setLayout(new BorderLayout());
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(cols);
            JTable jt = new JTable();
            jt.setBounds(10,420,400,400);
            jt.setModel(model);
            jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jt.setFillsViewportHeight(true);
            JScrollPane scroll = new JScrollPane(jt);
            scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            jf1.add(jt);
            int id;
            String acc="",phone="",n= "",g="",st="",c="",sta="";
            
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","12345");
            String query = "select * from customers";
            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
             model.addRow(new Object[]{"NAME","ACC NO","ID","GENDER","STREET","CITY","STATE","PHONE NO"});
            while(rs.next()){
                n = rs.getString("name");
                acc = rs.getString("accno");
                id = rs.getInt("id");
                g = rs.getString("gender");
                st = rs.getString("street");
                c = rs.getString("city");
                sta = rs.getString("state");
                phone = rs.getString("phone");
             
                model.addRow(new Object[]{n,acc,id,g,st,c,sta,phone});}
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR"+e);
        }
 
        }
    public void showRequestData(){
            JFrame jf = new JFrame("USERS");
            jf.setVisible(true);
            jf.setLayout(null);
            jf.setSize(400,400);
            String cols[] = {"RequestType","ReqDateTime","info"};
            jf.setLayout(new BorderLayout());
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(cols);
            JTable jt1 = new JTable();
            jt1.setBounds(10,420,400,400);
            jt1.setModel(model);
            jt1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jt1.setFillsViewportHeight(true);
            JScrollPane scroll = new JScrollPane(jt1);
            scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            jf.add(jt1);
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","12345");
            PreparedStatement pst = cn.prepareStatement("select * from Admin_msgs");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String req = rs.getString("RequestType");
                String Dt = rs.getString("ReqDateTime");
                String inf = rs.getString("info");
                model.addRow(new Object[]{req,Dt,inf});}
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR"+e);
        }
      
    }

   public static void main(String args[]){
       new Administrator();
   }
}

