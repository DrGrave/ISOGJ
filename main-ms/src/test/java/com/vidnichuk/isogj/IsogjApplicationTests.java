package com.vidnichuk.isogj;

import com.vidnichuk.isogj.api.dao.TempUserRepository;
import com.vidnichuk.isogj.api.entity.TempUser;
import com.vidnichuk.isogj.api.entity.User;
import com.vidnichuk.isogj.api.mappers.TempUserToUserMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Ignore
public class IsogjApplicationTests {

	@Autowired
	private TempUserRepository repository;

	@Autowired
	private TempUserToUserMapper tempUserToUserMapper;



	@Test
	public void contextLoads() throws Exception {
			String host="smtp.gmail.com";
			final String user="intsogj@gmail.com";//change accordingly
			final String password="1346792c212C";//change accordingly

			String to="VadimXPZL@gmail.com";//change accordingly

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
				message.setText("This is simple program of sending email using JavaMail API");

				//send the message
				Transport.send(message);

				System.out.println("message sent successfully...");

			} catch (MessagingException e) {e.printStackTrace();
		}
	}

	@Test
	public void fromTmpUserToUser(){
		TempUser tempUser = repository.findAll().get(0);
		User user = tempUserToUserMapper.tempUserToUser(tempUser);
		System.out.print(user);
	}

}
