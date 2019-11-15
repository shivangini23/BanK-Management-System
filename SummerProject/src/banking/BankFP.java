package banking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sanu
 */
public class BankFP implements ActionListener {
    JFrame jframe;
    JMenuBar jmb;
    JLabel Label2,head ,head2,lbl;
    JButton jb111,jb112,jb113;
    JRadioButton jrb11;
    ImageIcon i1,img;
    ButtonGroup bg;
    BankFP(){
       jframe=new JFrame("WELCOME");
       jframe.setSize(700,700);
       jframe.setVisible(true);
       jframe.setLayout(null);
       jframe.getContentPane().setBackground(Color.BLUE);
       
       i1=new ImageIcon("C:\\Yes_bank_logo.png");
       Label2=new JLabel(i1);
       Label2.setBounds(10,50,230,50);
       Label2.setVisible(true);
       jframe.add(Label2);
       
       img=new ImageIcon("C:\\my-account-login-icon.png");
       jb111=new JButton("LOGIN",img);
       jb111.setBounds(540,50,135,50);
       jframe.add(jb111);
       
       jb112=new JButton("ABOUT");
       jb112.setBounds(430,50,100,50);
       jframe.add(jb112);
       
       jb113=new JButton("CONTACT US");
       jb113.setBounds(300,50,120,50);
       jframe.add(jb113);
       
       head=new JLabel("How may we ");
       head.setFont(new Font("SANS-SERIF",Font.PLAIN, 24));
       head.setForeground(Color.WHITE);
       head.setBounds(15,120,150,50);
       jframe.add(head);
       
       head2=new JLabel("help you today? ");
       head2.setFont(new Font("SANS-SERIF",Font.PLAIN, 24));
       head2.setForeground(Color.WHITE);
       head2.setBounds(15,150,200,50);
       jframe.add(head2);
       
       jrb11=new JRadioButton("Create new savings account");
       jrb11.setFont(new Font("SANS-SERIF",Font.PLAIN, 20));
       jrb11.setForeground(Color.BLUE);
       jrb11.setBounds(20,250,300,30);
       jframe.add(jrb11);
       
       bg=new ButtonGroup();
       bg.add(jrb11);
       bg.add(jrb11);
       
       jb111.addActionListener(this);
       jb112.addActionListener(this);
       jb113.addActionListener(this);
       jrb11.addActionListener(this);
       
    }
public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==jb111){
        new BankApp();  }      
    if(ae.getSource()==jb112){
        new about(); }     
    if(ae.getSource()==jb113){
        new contact();}
    if(jrb11.isSelected()){
        new Create_Acc();}
}
public static void main(String s[]){
    new BankFP();
}
}
