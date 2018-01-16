package com.vidnichuk.isogj;

import com.vidnichuk.isogj.api.dao.*;
import com.vidnichuk.isogj.api.dto.mapper.*;
import com.vidnichuk.isogj.api.dto.model.EducationDto;
import com.vidnichuk.isogj.api.dto.model.UserDto;
import com.vidnichuk.isogj.api.dto.model.UserSkillDto;
import com.vidnichuk.isogj.api.dto.model.VacancyDto;
import com.vidnichuk.isogj.api.model.*;
import com.vidnichuk.isogj.api.service.education.EducationLightWeightService;
import com.vidnichuk.isogj.api.service.skill.SkillLightWeightService;
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

	@Autowired
	private SkillLightWeightService skillLightWeightService;


	@Test
	public void fromVacancyToVacancyDto(){
		List<Skill> skills = skillLightWeightService.findAddSkill("");
		System.out.print(skills);
	}


}
