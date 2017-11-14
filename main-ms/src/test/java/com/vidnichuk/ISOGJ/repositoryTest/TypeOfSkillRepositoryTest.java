package com.vidnichuk.ISOGJ.repositoryTest;

import com.vidnichuk.ISOGJ.api.dao.TypeOfSkillRepository;
import com.vidnichuk.ISOGJ.api.entity.TypeOfSkill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Vadim on 03.11.2017.
 * type of skill test repository
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TypeOfSkillRepositoryTest {

    @Autowired
    private TypeOfSkillRepository typeOfSkillRepository;

    /**
     * try to save type of skill to DB
     */
    @Test
    public void saveTypeOfSkill(){
        TypeOfSkill typeOfSkill = new TypeOfSkill();
        typeOfSkill.setNameOfTypeSkill("IT");
        typeOfSkillRepository.save(typeOfSkill);
    }


    /**
     * try to get type of skill from DB by name of type of skill
     */
    @Test
    public void getByNameTypeOfSkill(){
        TypeOfSkill typeOfSkill = typeOfSkillRepository.findAll().get(0);
        typeOfSkill.getNameOfTypeSkill();
    }

    /**
     * try to get type of skill from DB by id type of skill
     */
    @Test
    public void getTypeOfSkillById(){
        TypeOfSkill firstTypeOfSkill = typeOfSkillRepository.findAll().get(0);
        TypeOfSkill typeOfSkill = typeOfSkillRepository.findByIdTypeOfSkill(firstTypeOfSkill.getIdTypeOfSkill());
        typeOfSkill.getNameOfTypeSkill();
    }
}
