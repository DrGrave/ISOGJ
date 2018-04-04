package com.vidnichuk.isogj.api.service.skill;

import com.vidnichuk.isogj.api.dto.model.SkillDto;
import com.vidnichuk.isogj.api.dto.model.TypeOfSkillDto;
import com.vidnichuk.isogj.api.dto.model.UserSkillDto;
import com.vidnichuk.isogj.api.dto.model.VacancySkillDto;

import java.util.List;

public interface SkillLightWeightService {

    List<UserSkillDto> findAllSkillsById(String idUser);

    List<VacancySkillDto> findAllVacancySkillsById(Long id);

    List<UserSkillDto> findAuthorizedUserSkillsById(String id);

    List<SkillDto> findAddSkill(String name);

    List<UserSkillDto> addAndGetSkillsToUser(SkillDto skill, String id);

    List<TypeOfSkillDto> getAllTypesOfSkill();

    void addNewSkill(SkillDto skill);


    List<UserSkillDto> deleteSkills(UserSkillDto userSkillDto, String id);

    List<SkillDto> getSkillsByPartName(String name);
}
