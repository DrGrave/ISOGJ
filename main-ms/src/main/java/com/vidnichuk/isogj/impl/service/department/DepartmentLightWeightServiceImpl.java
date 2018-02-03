package com.vidnichuk.isogj.impl.service.department;

import com.vidnichuk.isogj.api.dto.model.DepartmentDto;
import com.vidnichuk.isogj.api.service.department.DepartmentLightWeightService;
import com.vidnichuk.isogj.api.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentLightWeightServiceImpl implements DepartmentLightWeightService{
    @Autowired
    private DepartmentService departmentService;

    @Override
    public List<DepartmentDto> findAllDepartmentsByPartOfNameAndFaculty(String name, DepartmentDto departmentDto) {
       return departmentService.findAllDepartmentsByPartOfNameAndFaculty(name, departmentDto);
    }
}
