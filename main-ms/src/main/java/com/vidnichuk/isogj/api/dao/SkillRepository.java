package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long>{
    List<Skill> findAllByNameContains(String name);
}
