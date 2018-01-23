package com.vidnichuk.isogj.api.service.skill;

import com.vidnichuk.isogj.api.dto.model.SkillDto;
import com.vidnichuk.isogj.api.dto.model.TypeOfSkillDto;
import com.vidnichuk.isogj.api.dto.model.UserSkillDto;
import com.vidnichuk.isogj.api.dto.model.VacancySkillDto;
import com.vidnichuk.isogj.api.model.Skill;
import com.vidnichuk.isogj.api.model.type.TypeOfSkill;

import java.util.List;

public interface SkillLightWeightService {

    List<UserSkillDto> findAllSkillsById(long idUser);

    List<VacancySkillDto> findAllVacancySkillsById(Long id);

    List<UserSkillDto> findAuthorizedUserSkillsById(long id);

    List<SkillDto> findAddSkill(String name);

    List<UserSkillDto> addAndGetSkillsToUser(SkillDto skill, long id);

    List<TypeOfSkillDto> getAllTypesOfSkill();

    void addNewSkill(SkillDto skill);
}
