package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.Skill;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to skill repository
 */
public interface SkillService {
    /**
     *
     * @return
     * all skill
     */
    List<Skill> getAllSkill();

    /**
     *
     * @param idOfSkill
     * id skill
     * @return
     * skill with this id
     */
    Skill getBySkillId(int idOfSkill);

    /**
     *
     * @param skill
     * save skill
     */
    void saveSkill(Skill skill);
}
