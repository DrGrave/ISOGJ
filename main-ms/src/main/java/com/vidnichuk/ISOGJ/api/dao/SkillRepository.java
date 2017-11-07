package com.vidnichuk.ISOGJ.api.dao;

import com.vidnichuk.ISOGJ.api.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

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
    Skill getByIdSkill(int idSkill);
}
