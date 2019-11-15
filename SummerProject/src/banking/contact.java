/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author sanu
 */
public class contact {
    JFrame jframe3;
    JLabel Labell2;
    ImageIcon i;
    contact(){
        jframe3=new JFrame("CONTACT");
        jframe3.setSize(500,500);
        jframe3.setVisible(true);
        jframe3.getContentPane().setBackground(Color.BLUE);
        

        jframe3.setLayout(null);
        i=new ImageIcon("C:\\Yes_Bank_logo.png");
       Labell2=new JLabel(i);
       Labell2.setBounds(250,5,230,60);
       Labell2.setVisible(true);
       jframe3.add(Labell2);
        
        i=new ImageIcon("C:\\Capture (1).png");
       Labell2=new JLabel(i);
       Labell2.setBounds(20,100,450,200);
       Labell2.setVisible(true);
       jframe3.add(Labell2);
        
    }
public static void main(String s[]){
    new contact();
}
}

