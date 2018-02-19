package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.TaskSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskSkillRepository extends JpaRepository<TaskSkill, Long>{
    List<TaskSkill> findAllByTask_Id(long id);
}
