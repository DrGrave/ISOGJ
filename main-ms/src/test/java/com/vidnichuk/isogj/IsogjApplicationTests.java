package com.vidnichuk.isogj;

import com.vidnichuk.isogj.api.dao.TempUserRepository;
import com.vidnichuk.isogj.api.dao.UserRepository;
import com.vidnichuk.isogj.api.dao.UserSkillRepository;
import com.vidnichuk.isogj.api.dao.VacancyRepository;
import com.vidnichuk.isogj.api.dto.mapper.UserDtoMapper;
import com.vidnichuk.isogj.api.dto.mapper.UserSkillDtoMapper;
import com.vidnichuk.isogj.api.dto.mapper.VacancyDtoMapper;
import com.vidnichuk.isogj.api.dto.model.UserDto;
import com.vidnichuk.isogj.api.dto.model.UserSkillDto;
import com.vidnichuk.isogj.api.dto.model.VacancyDto;
import com.vidnichuk.isogj.api.model.TempUser;
import com.vidnichuk.isogj.api.model.User;
import com.vidnichuk.isogj.api.dto.mapper.TempUserToUserMapper;
import com.vidnichuk.isogj.api.model.UserSkill;
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
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
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

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VacancyRepository vacancyRepository;

	@Autowired
	private UserSkillRepository userSkillRepository;

	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	@Autowired
	private UserDtoMapper userDtoMapper;

	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	@Autowired
	private VacancyDtoMapper vacancyDtoMapper;

	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	@Autowired
	private UserSkillDtoMapper userSkillDtoMapper;

	@Test
	public void fromVacancyToVacancyDto(){
		VacancyDto vacancyDto = vacancyDtoMapper.fromVacancyToVacancyDTO(vacancyRepository.findAll().get(0));
		System.out.println(vacancyDto);

	}


	@Test
	public void fromUserSkillToUserSkillDto(){
		List<UserSkillDto> userSkillDtoList = new ArrayList<>();
		for (UserSkill userSkill: userSkillRepository.findAllByUser_Id(1)){
			userSkillDtoList.add(userSkillDtoMapper.fromUserSkillToUserSkillDto(userSkill));
		}
		System.out.println(userSkillDtoList);
	}

	@Test
	public void fromUserToUserDto(){
		List<UserDto> userDtoList = new ArrayList<>();
		for (User user: userRepository.findAll()){
			userDtoList.add(userDtoMapper.fromUserToUserDto(user));
		}
		System.out.println(userDtoList);
	}



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
