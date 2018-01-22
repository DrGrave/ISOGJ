package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.TypeOfSkillDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeOfSkillDtoMapper {
    TypeOfSkillDto fromTypeOfSkillToTypeOfSkillDtoMapper(TypeOfSkillDto typeOfSkillDto);
}
