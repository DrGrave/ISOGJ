package com.vidnichuk.isogj.api.service.skill;

import com.vidnichuk.isogj.api.dto.model.UserSkillDto;
import com.vidnichuk.isogj.api.model.UserSkill;

import java.util.List;

public interface SkillService {

    List<UserSkillDto> findAllSkillsByUserId(long id);
}
