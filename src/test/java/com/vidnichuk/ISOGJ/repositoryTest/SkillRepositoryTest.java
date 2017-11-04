package com.vidnichuk.ISOGJ.repositoryTest;

import com.vidnichuk.ISOGJ.api.dao.SkillRepository;
import com.vidnichuk.ISOGJ.api.dao.TypeOfSkillRepository;
import com.vidnichuk.ISOGJ.api.entity.Skill;
import com.vidnichuk.ISOGJ.api.entity.TypeOfSkill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Vadim on 03.11.2017.
 * test to skill repository
 */

@RunWith(SpringRunner.class)
@SpringBootTest
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
        Skill skill = skillRepository.getByIdSkill(1);
        skill.getNameOfSkill();
    }
}
