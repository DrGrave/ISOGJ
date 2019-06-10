package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.SubjectSkillUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectSkillUserRepository extends JpaRepository<SubjectSkillUser, Long> {
    List<SubjectSkillUser> findAllBySubjectSkill_Subject_Department_Id(long id);
}
