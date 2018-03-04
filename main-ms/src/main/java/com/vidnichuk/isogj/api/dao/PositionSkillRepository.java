package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.PositionSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionSkillRepository extends JpaRepository<PositionSkill, Long>{
    List<PositionSkill> findAllByPositionId(Long id);
}
