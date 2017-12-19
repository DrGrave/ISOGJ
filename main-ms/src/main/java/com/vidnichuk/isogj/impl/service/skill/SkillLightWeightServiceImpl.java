package com.vidnichuk.isogj.impl.service.skill;

import com.vidnichuk.isogj.api.dto.model.UserSkillDto;
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
}
