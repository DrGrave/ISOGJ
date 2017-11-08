package com.vidnichuk.ISOGJ.impl.service;

import com.vidnichuk.ISOGJ.api.dao.VacancySkillRepository;
import com.vidnichuk.ISOGJ.api.entity.VacancySkill;
import com.vidnichuk.ISOGJ.api.service.VacancySkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implementation of vacancy skill service
 */

@Service
public class VacancySkillServcieImpl implements VacancySkillService{
    @Autowired
    private VacancySkillRepository vacancySkillRepository;

    /**
     *
     * @return
     * all vacancy skill
     */
    @Override
    public List<VacancySkill> getAllVacancySkill() {
        return vacancySkillRepository.findAll();
    }

    /**
     *
     * @param idVacancySkill
     * id of vacancy skill
     * @return
     * vacancy skill with this id
     */
    @Override
    public VacancySkill getVacancySkillById(int idVacancySkill) {
        return vacancySkillRepository.findByIdVacancySkill(idVacancySkill);
    }

    /**
     *
     * @param vacancySkill
     * save vacancy skill
     */
    @Override
    public void saveVacancySkill(VacancySkill vacancySkill) {
        vacancySkillRepository.save(vacancySkill);
    }
}
