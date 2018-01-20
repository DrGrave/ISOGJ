package com.vidnichuk.isogj.api.service.skill;

import com.vidnichuk.isogj.api.dto.model.UserSkillDto;
import com.vidnichuk.isogj.api.dto.model.VacancySkillDto;
import com.vidnichuk.isogj.api.model.Skill;
import com.vidnichuk.isogj.api.model.UserSkill;
import com.vidnichuk.isogj.api.model.type.TypeOfSkill;

import java.util.List;

public interface SkillService {

    List<UserSkillDto> findAllSkillsByUserId(long id);

    List<VacancySkillDto> findAllSkillsByVacancyId(long id);

    List<UserSkillDto> findAuthorizedSkillsByUserId(long id);

    List<Skill> findAddSkill(String name);

    List<UserSkillDto> addAndGetSkillsToUser(Skill skill, long id);

    List<TypeOfSkill> getAllTypesOfSkill();
}
