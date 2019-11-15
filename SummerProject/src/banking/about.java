/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author sanu
 */
public class about {
    JFrame jframe2;
    ImageIcon i;
    JLabel jl,Labell,Labell2;
    about(){
        jframe2=new JFrame("ABOUT");
        jframe2.setSize(500,500);
        jframe2.setVisible(true);
        jframe2.setLayout(new GridLayout());
        jframe2.getContentPane().setBackground(Color.WHITE);
        
        i=new ImageIcon("C:\\yess.png");
       Labell2=new JLabel(i);
       Labell2.setBounds(150,5,230,200);
       Labell2.setVisible(true);
       jframe2.add(Labell2);
        
        
        jl=new JLabel("<html> YES BANK has been recognized amongst the Top and Fastest Growing Banks <br>in various Indian Banking League Tables by prestigious media houses <br>and Global Advisory Firms, and has received several national and international honours <br> for our various Businesses including Corporate Investment Banking, Treasury, Transaction Banking,<br> and Sustainable practices through Responsible Banking.<br> YES BANK is steadily evolving as the Professionals’ Bank of India <br>with the long term mission of Finest Quality Large Bank of the World in India </html>");
       
        jframe2.add(jl);
         
        
        
    }
public static void main(String s[]){
    new about();
}
}
