package com.vidnichuk.isogj.api.service.skill;

import com.vidnichuk.isogj.api.dto.model.UserSkillDto;

import java.util.List;

public interface SkillLightWeightService {

    List<UserSkillDto> findAllSkillsById(long idUser);
}
