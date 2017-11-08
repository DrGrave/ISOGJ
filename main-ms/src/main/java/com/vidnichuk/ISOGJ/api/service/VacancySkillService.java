package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.VacancySkill;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to vacancy skill repository
 */
public interface VacancySkillService {

    /**
     *
     * @return
     * all vacancy skills
     */
    List<VacancySkill> getAllVacancySkill();

    /**
     *
     * @param idVacancySkill
     * id of vacancy skill
     * @return
     * vacancy skill with this id
     */
    VacancySkill getVacancySkillById(int idVacancySkill);

    /**
     *
     * @param vacancySkill
     * save vacancy skill
     */
    void saveVacancySkill(VacancySkill vacancySkill);
}
