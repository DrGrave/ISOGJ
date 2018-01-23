package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.UserSkillDto;
import com.vidnichuk.isogj.api.model.UserSkill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserSkillDtoMapper {

    @Mapping(source = "marker.id", target = "marker")
    UserSkillDto fromUserSkillToUserSkillDto(UserSkill userSkill);

}
