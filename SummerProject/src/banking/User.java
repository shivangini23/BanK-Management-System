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
import javax.swing.*;

/**
 *
 * @author shivangini priya
 */
public class User implements ActionListener{
    JFrame jf;
    JLabel jl1,Labell;
    JRadioButton jrb1,jrb2,jrb3,jrb4,jrb5,jrb6;
    JButton jb1,jb2;
    ImageIcon i;
    
    User(){
        jf = new JFrame("User");
        jf.setLayout(null);
        jf.setSize(550,500);
        jf.setVisible(true);
        jf.setResizable(true);
        jf.getContentPane().setBackground(Color.BLUE);
        
        i=new ImageIcon("C:\\Yes_Bank_logo.png");
       Labell=new JLabel(i);
       Labell.setBounds(280,5,230,55);
       Labell.setVisible(true);
       jf.add(Labell);
       
        jl1 = new JLabel("Please Make a Choice..");
        jl1.setBounds(20,20,400,50);
        jl1.setFont(new Font("Courier New", Font.BOLD, 24));
        jl1.setForeground(Color.BLUE);
        jf.add(jl1);
        
        jb1 = new JButton("HOME");
       jb1.setBounds(290,65,100,30);
       jf.add(jb1);
       jb2 = new JButton("LOGOUT");
       jb2.setBounds(400,65,100,30);
       jf.add(jb2);
        
        jrb1 = new JRadioButton("CREATE NEW ACCOUNT");
        jrb1.setBounds(20,80,200,50);
        jf.add(jrb1);
        jrb2 = new JRadioButton("MAKE A DEPOSIT OR WITHDRAWAL");
        jrb2.setBounds(20,140,250,50);
        jf.add(jrb2);
        jrb3 = new JRadioButton("TRANSFER MONEY");
        jrb3.setBounds(20,200,200,50);
        jf.add(jrb3);
        jrb4 = new JRadioButton("CHECK MY BALANCE");
        jrb4.setBounds(20,260,200,50);
        jf.add(jrb4);
        jrb5 = new JRadioButton("UPDATE MOBILE NUMBER");
        jrb5.setBounds(20,320,200,50);
        jf.add(jrb5);
        jrb6 = new JRadioButton("VIEW ACCOUNT SUMMARY");
        jrb6.setBounds(20,380,200,50);
        jf.add(jrb6);
        ButtonGroup bg = new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);
        bg.add(jrb4);
        bg.add(jrb5);
        bg.add(jrb6);
        
        jrb1.addActionListener(this);
        jrb2.addActionListener(this);
        jrb3.addActionListener(this);
        jrb4.addActionListener(this);
        jrb5.addActionListener(this);
        jrb6.addActionListener(this);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==jrb1){
            //create new account
            new Create_Acc();
        }
        if(ae.getSource()==jrb2){
            new DepWith();
        }
        if(ae.getSource()==jrb3){
            new Transfer();
        }
        if(ae.getSource()==jrb4){
            //check balance
            new Check_Bal();
        }
        if(ae.getSource()==jrb5){
            //update number
            new UpdateNum();
        }
        if(ae.getSource()==jrb6){
            //view account summary
            new Admin_transactions();
        }
        if(ae.getSource()==jb1){
            // new BankFP();
           jf.setVisible(false);
           jf.dispose();
        }
        if(ae.getSource()==jb2){ //LOGOUT
           new BankApp();
           jf.setVisible(false);
           jf.dispose();
       }
    }
        
        
    public static void main(String s[]){
        new User();
    }
}
