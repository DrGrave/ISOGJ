package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.VacancySkill;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to vacancy skill repository
 */
public interface VacancySkillService {
    List<VacancySkill> getAllVacancySkill();
    VacancySkill getVacancySkillById(int idVacancySkill);
    void saveVacancySkill(VacancySkill vacancySkill);
}
