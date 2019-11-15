/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;


import com.toedter.calendar.JCalendar;
import java.util.Calendar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import java.awt.event.*;

public class Admin_transactions implements ActionListener {
    JFrame jf;
    JLabel jl1,jl2,jl3,jl4,jl5,Labell;
    ImageIcon i;
    JButton jb1,from1,to1,to2,from2;
    JTextField jtf,jtf1,jtf2,jtf3;
    JComboBox jcb1,jcb2,jcb3;
    JLabel from,to;
    
    Admin_transactions(){
        jf=new JFrame("ADMIN");
        jf.setSize(700,700);
        jf.setLayout(null);
        jf.setVisible(true);
        jf.getContentPane().setBackground(Color.BLUE);
        
        i=new ImageIcon("C:\\Yes_Bank_logo.png");
        Labell=new JLabel(i);
        Labell.setBounds(450,20,230,60);
        Labell.setVisible(true);
        jf.add(Labell);
        
        jl1 = new JLabel("ACCOUNT TRANSACTIONS");
        jl1.setBounds(40,45,410,50);
        jl1.setFont(new Font("Courier New", Font.BOLD, 30));
        jl1.setForeground(Color.WHITE);
        jf.add(jl1);
        
        jl2 = new JLabel("ACCOUNT NUMBER:");
        jl2.setBounds(20,120,300,50);
        jl2.setFont(new Font("Courier New", Font.BOLD, 20));
        jl2.setForeground(Color.WHITE);
        jf.add(jl2);
        
        from=new JLabel("FROM(YYYY/MM/DD):");
        from.setBounds(20,200,250,50);
        from.setFont(new Font("Courier New", Font.BOLD, 20));
        from.setForeground(Color.WHITE);
        jf.add(from);
        
        to=new JLabel("TO(YYYY/MM/DD):");
        to.setBounds(20,280,250,50);
        to.setFont(new Font("Courier New", Font.BOLD, 20));
        to.setForeground(Color.WHITE);
        jf.add(to);
        
        
        jl5 = new JLabel("DISPLAY TRANSACTIONS:");
        jl5.setBounds(20,360,300,50);
        jl5.setFont(new Font("Courier New", Font.BOLD, 20));
        jl5.setForeground(Color.WHITE);
        jf.add(jl5);
                
        jb1=new JButton("ENTER");
        jb1.setBounds(360,360,100,50);
        jf.add(jb1);
        
        to2=new JButton("...");
        to2.setBounds(470,200,30,50);
        jf.add(to2);
        
        from2=new JButton("...");
        from2.setBounds(470,280,30,50);
        jf.add(from2);
        
        jtf=new JTextField("");
        jtf.setBounds(360,120,100,50);
        jf.add(jtf);
        
        jtf1=new JTextField("");
        jtf1.setBounds(360,200,100,50);
        jf.add(jtf1);
        
        jtf2=new JTextField("");
        jtf2.setBounds(360,280,100,50);
        jf.add(jtf2);
        
        
        
        jb1.addActionListener(this);
        to2.addActionListener(this);
        from2.addActionListener(this);
        
    
}

public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==jb1)
    {       
       String accnumber=jtf.getText();
       new TransTable(accnumber,jtf2.getText(),jtf1.getText());
    }
    if(ae.getSource()==to2){
        
        DatePickerExample d1=new DatePickerExample();
        String a=d1.send();
        jtf2.setText(a);}
    if(ae.getSource()==from2){
        DatePickerExample d1=new DatePickerExample();
        String a=d1.send();
        jtf1.setText(a);
    }
        
}
public static void main(String s[]){
    new Admin_transactions();
}
}

