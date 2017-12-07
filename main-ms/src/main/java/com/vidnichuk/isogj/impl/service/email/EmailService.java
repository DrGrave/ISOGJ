package com.vidnichuk.isogj.impl.service.email;

import com.vidnichuk.isogj.api.model.TempUser;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {
    public void sendEmail(TempUser tempUser){
        String host="smtp.gmail.com";
        final String user="intsogj@gmail.com";//change accordingly
        final String password="1346792c212C";//change accordingly

        String to=tempUser.getEmail();//change accordingly

        //Get the session object
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,password);
                    }
                });

        //Compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("Post authorization link");
            message.setText("Link: http://localhost:3001/main/user/register?link=" + tempUser.getConfirmLink());

            //send the message
            Transport.send(message);

            System.out.println("message sent successfully...");

        } catch (MessagingException e) {e.printStackTrace();
        }
    }
}
