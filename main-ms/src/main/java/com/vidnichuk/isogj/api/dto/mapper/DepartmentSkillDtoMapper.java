package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.DepartmentSkillDto;
import com.vidnichuk.isogj.api.model.DepartmentSkill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentSkillDtoMapper {
    DepartmentSkillDto fromDepartmentSkillToDepartmentSkillDto(DepartmentSkill departmentSkill);
}
