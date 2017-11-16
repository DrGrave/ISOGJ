package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.entity.VacancySkill;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to vacancy skill entity
 */
public interface VacancySkillRepository extends JpaRepository<VacancySkill, Long>{
    /**
     *
     * @param idVacancySkill
     * id vacancy skill
     * @return
     * vacancy skill with this id
     */
    VacancySkill findByIdVacancySkill(int idVacancySkill);
}
