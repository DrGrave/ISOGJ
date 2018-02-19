package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.TaskSkillDto;
import com.vidnichuk.isogj.api.model.TaskSkill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskSkillDtoMapper {
    TaskSkillDto fromTaskSkillToTaskSkillDto(TaskSkill taskSkill);
}
