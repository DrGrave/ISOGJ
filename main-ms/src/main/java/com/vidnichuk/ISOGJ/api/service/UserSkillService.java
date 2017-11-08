package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.UserSkill;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to user skill repository
 */
public interface UserSkillService {

    /**
     *
     * @return
     * all user skills
     */
    List<UserSkill> getAllUserSkill();

    /**
     *
     * @param idUserSkill
     * id user skill
     * @return
     * user skill with this id
     */
    UserSkill getUserSkillById(int idUserSkill);

    /**
     *
     * @param userSkill
     * save user skill
     */
    void saveUserSkill(UserSkill userSkill);
}
