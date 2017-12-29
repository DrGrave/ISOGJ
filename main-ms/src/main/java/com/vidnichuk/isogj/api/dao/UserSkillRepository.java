package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserSkillRepository extends JpaRepository<UserSkill, Long>{
    List<UserSkill> findAllByUser_Id(long id);
}