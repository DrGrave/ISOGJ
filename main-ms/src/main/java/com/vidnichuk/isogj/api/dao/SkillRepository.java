package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 03.11.2017.
 * skill repository
 */
public interface SkillRepository extends JpaRepository<Skill, Long>{
    /**
     *
     * @param idSkill
     * id of skill
     * @return
     * skill with this id
     */
    Skill findByIdSkill(int idSkill);
}
