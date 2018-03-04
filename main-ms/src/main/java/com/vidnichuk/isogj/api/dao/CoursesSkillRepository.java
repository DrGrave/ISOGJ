package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.CoursesSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursesSkillRepository extends JpaRepository<CoursesSkill, Long>{
    List<CoursesSkill> findAllByCoursesId(Long id);
}
