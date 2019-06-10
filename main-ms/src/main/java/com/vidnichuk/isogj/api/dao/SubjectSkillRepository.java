package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.SubjectSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectSkillRepository extends JpaRepository<SubjectSkill, Long> {
    List<SubjectSkill> findAllBySubjectDepartmentId(long id);
}
