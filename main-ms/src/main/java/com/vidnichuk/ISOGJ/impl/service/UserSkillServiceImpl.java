package com.vidnichuk.ISOGJ.impl.service;

import com.vidnichuk.ISOGJ.api.dao.UserSkillRepository;
import com.vidnichuk.ISOGJ.api.entity.UserSkill;
import com.vidnichuk.ISOGJ.api.service.UserSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implementation of user skill service
 */
@Service
public class UserSkillServiceImpl implements UserSkillService{
    @Autowired
    private UserSkillRepository userSkillRepository;

    @Override
    public List<UserSkill> getAllUserSkill() {
        return userSkillRepository.findAll();
    }

    @Override
    public UserSkill getUserSkillById(int idUserSkill) {
        return null;
    }

    @Override
    public void saveUserSkill(UserSkill userSkill) {
        userSkillRepository.save(userSkill);
    }
}