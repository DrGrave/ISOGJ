package com.vidnichuk.isogj.api.service.experience;

import com.vidnichuk.isogj.api.dto.model.ExperienceSkillsDto;

import java.util.List;

public interface ExperienceService {
    List<ExperienceSkillsDto> getExperienceSkillsById(Long id);

    ExperienceSkillsDto getOneByExperienceId(Long id);
}
