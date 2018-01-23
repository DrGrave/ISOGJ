package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.TypeOfSkillDto;
import com.vidnichuk.isogj.api.model.type.TypeOfSkill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeOfSkillDtoMapper {
    TypeOfSkillDto fromTypeOfSkillToTypeOfSkillDto(TypeOfSkill typeOfSkill);
}
