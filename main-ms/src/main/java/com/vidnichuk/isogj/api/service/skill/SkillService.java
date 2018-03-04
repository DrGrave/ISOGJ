package com.vidnichuk.isogj.api.service.skill;

import com.vidnichuk.isogj.api.dto.model.*;

import java.util.List;

public interface SkillService {

    List<UserSkillDto> findAllSkillsByUserId(String id);

    List<VacancySkillDto> findAllSkillsByVacancyId(long id);

    List<UserSkillDto> findAuthorizedSkillsByUserId(String id);

    List<SkillDto> findAddSkill(String name);

    List<UserSkillDto> addAndGetSkillsToUser(SkillDto skill, String id);

    List<TypeOfSkillDto> getAllTypesOfSkill();

    void addNewSkill(SkillDto skill);

    List<UserSkillDto> deleteSkills(UserSkillDto userSkillDto, String id);

    List<PositionSkillDto> getPositionSkills(long id);

    List<DepartmentSkillDto> getDepartmentSkills(long id);

    List<CoursesSkillDto> getAllCoursesSkill(Long id);
}
