package com.vidnichuk.isogj.impl.service.skill;

import com.vidnichuk.isogj.api.dto.model.UserSkillDto;
import com.vidnichuk.isogj.api.dto.model.VacancySkillDto;
import com.vidnichuk.isogj.api.model.Skill;
import com.vidnichuk.isogj.api.model.type.TypeOfSkill;
import com.vidnichuk.isogj.api.service.skill.SkillLightWeightService;
import com.vidnichuk.isogj.api.service.skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillLightWeightServiceImpl implements SkillLightWeightService{
    @Autowired
    private SkillService skillService;

    @Override
    public List<UserSkillDto> findAllSkillsById(long idUser) {
        return skillService.findAllSkillsByUserId(idUser);
    }

    @Override
    public List<VacancySkillDto> findAllVacancySkillsById(Long id) {
        return skillService.findAllSkillsByVacancyId(id);
    }

    @Override
    public List<UserSkillDto> findAuthorizedUserSkillsById(long id) {
        return skillService.findAllSkillsByUserId(id);
    }

    @Override
    public List<Skill> findAddSkill(String name) {
        return skillService.findAddSkill(name);
    }

    @Override
    public List<UserSkillDto> addAndGetSkillsToUser(Skill skill, long id) {
        return skillService.addAndGetSkillsToUser(skill, id);
    }

    @Override
    public List<TypeOfSkill> getAllTypesOfSkill() {
        return skillService.getAllTypesOfSkill();
    }
}
