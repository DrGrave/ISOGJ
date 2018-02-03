package com.vidnichuk.isogj.api.service.department;

import com.vidnichuk.isogj.api.dto.model.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> findAllDepartmentsByPartOfNameAndFaculty(String name, DepartmentDto departmentDto);
}
