package com.vidnichuk.isogj.repositoryTest;

import com.vidnichuk.isogj.api.dao.SkillRepository;
import com.vidnichuk.isogj.api.dao.TypeOfSkillRepository;
import com.vidnichuk.isogj.api.entity.Skill;
import com.vidnichuk.isogj.api.entity.TypeOfSkill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Vadim on 03.11.2017.
 * test to skill repository
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SkillRepositoryTest {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private TypeOfSkillRepository typeOfSkillRepository;

    /**
     * try to save skill in DB
     */
    @Test
    public void saveSkill(){
        TypeOfSkill typeOfSkill = new TypeOfSkill();
        typeOfSkill.setNameOfTypeSkill("DB");
        typeOfSkillRepository.save(typeOfSkill);
        Skill skill = new Skill();
        skill.setNameOfSkill("MySql");
        skill.setTypeOfSkill(typeOfSkill);
        skillRepository.save(skill);
    }

    /**
     * try to get skill from DB by id
     */
    @Test
    public void getSkillById(){
        Skill skill = skillRepository.findByIdSkill(skillRepository.findAll().get(0).getIdSkill());
        skill.getNameOfSkill();
    }
}
