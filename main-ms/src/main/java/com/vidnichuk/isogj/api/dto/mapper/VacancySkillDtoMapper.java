package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.VacancySkillDto;
import com.vidnichuk.isogj.api.model.VacancySkill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VacancySkillDtoMapper {


    VacancySkillDto fromVacancySkillToVacancySkillDto(VacancySkill vacancySkill);
}
