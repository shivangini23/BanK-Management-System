package banking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXDatePicker;

public class DatePickerExample extends JPanel implements ActionListener{
    JButton jb;
    static String s;
    static JXDatePicker picker;
    JFrame frame;
   DatePickerExample(){
        frame = new JFrame("DATE");
        JPanel panel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400, 400, 250, 100);

        picker = new JXDatePicker();
        picker.setDate(Calendar.getInstance().getTime());
        picker.setFormats(new SimpleDateFormat("yyyy/MM/dd"));

        panel.add(picker);
        frame.getContentPane().add(panel);

        frame.setVisible(true);
        jb = new JButton("OK");
        jb.setBounds(10,70,50,50);
        panel.add(jb);
       
        jb.addActionListener(this);
      }
   public String send(){
       return s;
   }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==jb){
               Date d=picker.getDate();
        DateFormat df=new SimpleDateFormat("yyyy/MM/dd");
        s=df.format(d);
        send();
        frame.dispose();
            }
        }
        
               
         
    }
  
        

