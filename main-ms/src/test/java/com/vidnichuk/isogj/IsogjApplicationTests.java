package com.vidnichuk.isogj;

import com.vidnichuk.isogj.api.dao.*;
import com.vidnichuk.isogj.api.dto.mapper.*;
import com.vidnichuk.isogj.api.dto.model.EducationDto;
import com.vidnichuk.isogj.api.dto.model.UserDto;
import com.vidnichuk.isogj.api.dto.model.UserSkillDto;
import com.vidnichuk.isogj.api.dto.model.VacancyDto;
import com.vidnichuk.isogj.api.model.Education;
import com.vidnichuk.isogj.api.model.TempUser;
import com.vidnichuk.isogj.api.model.User;
import com.vidnichuk.isogj.api.model.UserSkill;
import com.vidnichuk.isogj.api.service.education.EducationLightWeightService;
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
	private EducationRepository educationRepository;

	@Autowired
	private EducationLightWeightService educationLightWeightService;

	@Autowired
	private EducationDtoMapper educationDtoMapper;

	@Test
	public void fromVacancyToVacancyDto(){
		List<Education> education = new  ArrayList<>();
		List<EducationDto> educationDto = new ArrayList<>();
		educationDto = educationLightWeightService.getEducationById((long)2);
		for(Education education1 : education){
			educationDto.add(educationDtoMapper.formEducationToEducationDto(education1));
		}
		System.out.print(educationDto);
	}


}
