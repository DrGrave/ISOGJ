package com.vidnichuk.ISOGJ.api.dao;

import com.vidnichuk.ISOGJ.api.entity.VacancySkill;
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
