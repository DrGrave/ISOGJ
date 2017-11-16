package com.vidnichuk.isogj.impl.service;

import com.vidnichuk.isogj.api.dao.SkillRepository;
import com.vidnichuk.isogj.api.entity.Skill;
import com.vidnichuk.isogj.api.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implementation of skill service
 */
@Service
public class SkillServiceImpl implements SkillService{
    @Autowired
    private SkillRepository skillRepository;

    /**
     *
     * @return
     * all skills
     */
    @Override
    public List<Skill> getAllSkill() {
        return skillRepository.findAll();
    }

    /**
     *
     * @param idOfSkill
     * id skill
     * @return
     * skill with this id
     */
    @Override
    public Skill getBySkillId(int idOfSkill) {
        return skillRepository.findByIdSkill(idOfSkill);
    }

    /**
     *
     * @param skill
     * save skill
     */
    @Override
    public void saveSkill(Skill skill) {
        skillRepository.save(skill);
    }
}
