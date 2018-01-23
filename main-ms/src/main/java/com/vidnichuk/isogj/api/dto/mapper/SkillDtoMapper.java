package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.SkillDto;
import com.vidnichuk.isogj.api.model.Skill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillDtoMapper {
    SkillDto fromSkillToSkillDtoMapper(Skill skill);
    Skill fromSkillDtoToSkillMapper(SkillDto skillDto);
}
