package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.DepartmentSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentSkillRepository extends JpaRepository<DepartmentSkill, Long>{
    List<DepartmentSkill> findAllByDepartmentId(Long id);
}
