package com.vidnichuk.isogj.impl.service.experience;

import com.vidnichuk.isogj.api.dao.ExperienceRepository;
import com.vidnichuk.isogj.api.dto.mapper.ExperienceDtoMapper;
import com.vidnichuk.isogj.api.dto.model.ExperienceSkillsDto;
import com.vidnichuk.isogj.api.model.Experience;
import com.vidnichuk.isogj.api.service.experience.ExperienceService;
import com.vidnichuk.isogj.api.service.skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService{
    @Autowired
    private SkillService skillService;

    @Autowired
    private ExperienceRepository experienceRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ExperienceDtoMapper experienceDtoMapper;

    @Override
    public List<ExperienceSkillsDto> getExperienceSkillsById(Long id) {
        try {
            List<ExperienceSkillsDto> experienceSkillsDtoList = new ArrayList<>();
            for (Experience experience : experienceRepository.findAllByUser_Id(id)) {
                experienceSkillsDtoList.add(new ExperienceSkillsDto(experienceDtoMapper.fromExperienceToExperienceDtoMapper(experience), skillService.getPositionSkills(experience.getPosition().getId())));
            }
            return experienceSkillsDtoList;
        }catch (NullPointerException ex){
            return null;
        }
    }

    @Override
    public ExperienceSkillsDto getOneByExperienceId(Long id) {
        try {
            ExperienceSkillsDto experienceSkillsDto = new ExperienceSkillsDto();
            experienceSkillsDto.setExperienceDto(experienceDtoMapper.fromExperienceToExperienceDtoMapper(experienceRepository.getOne(id)));
            experienceSkillsDto.setPositionSkillDtoList(skillService.getPositionSkills(experienceRepository.getOne(id).getPosition().getId()));
            return experienceSkillsDto;
        }catch (NullPointerException ex){
            return null;
        }
    }
}
