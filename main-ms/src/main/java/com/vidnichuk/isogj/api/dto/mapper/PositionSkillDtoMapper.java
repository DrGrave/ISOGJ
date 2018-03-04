package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.PositionSkillDto;
import com.vidnichuk.isogj.api.model.PositionSkill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PositionSkillDtoMapper {
    PositionSkillDto fromPositionToPositionDto(PositionSkill positionSkill);
}
