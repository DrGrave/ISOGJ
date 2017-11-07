package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.UserSkill;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to user skill repository
 */
public interface UserSkillService {
    List<UserSkill> getAllUserSkill();
    UserSkill getUserSkillById(int idUserSkill);
    void saveUserSkill(UserSkill userSkill);
}
