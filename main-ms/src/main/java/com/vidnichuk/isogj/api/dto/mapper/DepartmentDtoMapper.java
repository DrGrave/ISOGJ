package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.DepartmentDto;
import com.vidnichuk.isogj.api.model.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentDtoMapper {
    DepartmentDto fromDepartmentToDepartmentDto(Department department);
}
