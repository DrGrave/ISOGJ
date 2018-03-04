package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.CoursesSkillDto;
import com.vidnichuk.isogj.api.model.CoursesSkill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoursesSkillDtoMapper {
    CoursesSkillDto fromCoursesSkillToCoursesSkillDto(CoursesSkill coursesSkill);
}
