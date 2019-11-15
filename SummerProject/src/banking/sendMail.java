package banking;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class sendMail {

    private static String USER_NAME ="shivanginipriya@gmail.com";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "shivi&9999"; // GMail password

    public void sendFromGMail(String to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", USER_NAME);
        props.put("mail.smtp.password", PASSWORD);
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.auth", "true");
props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(USER_NAME));
            InternetAddress toAddress = new InternetAddress(to);

            // To get the array of addresses
            //for( int i = 0; i < to.length; i++ ) {
               // toAddress = new InternetAddress(to);
            //}

            //for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress);
            //}

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, USER_NAME, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}