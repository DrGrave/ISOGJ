package com.vidnichuk.isogj.repositoryTest;

import com.vidnichuk.isogj.api.dao.SkillRepository;
import com.vidnichuk.isogj.api.dao.UserRepository;
import com.vidnichuk.isogj.api.dao.UserSkillRepository;
import com.vidnichuk.isogj.api.entity.UserSkill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vadim on 03.11.2017.
 * tes user skill repository
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserSkillRepositoryTest {
    @Autowired
    private UserSkillRepository userSkillRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SkillRepository skillRepository;

    /**
     * try to save user skill to DB
     */
    @Test
    public void saveUserSkill(){
        UserSkill userSkill = new UserSkill();
        userSkill.setIdUser(userRepository.findAll().get(0));
        userSkill.setIdSkill(skillRepository.findAll().get(0));
        userSkill.setSkillMark("4.5");
        userSkill.setSkillPracticalMark("5.3");
        userSkillRepository.save(userSkill);
    }

    /**
     * try to get all user skills by Id user
     */
    @Test
    public void getAllUserSkillsByIdUser(){
        List<UserSkill> userSkills = userSkillRepository.findAllByIdUser_UserId(userRepository.findAll().get(0).getUserId());
        userSkills.get(0).getIdSkill().getNameOfSkill();
    }
}
