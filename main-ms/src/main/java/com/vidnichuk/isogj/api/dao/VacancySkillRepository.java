package com.vidnichuk.isogj.api.dao;


import com.vidnichuk.isogj.api.model.VacancySkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacancySkillRepository extends JpaRepository<VacancySkill, Long>{
    List<VacancySkill> findAllByVacancy_Id(Long id);
}
