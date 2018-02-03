package com.vidnichuk.isogj.impl.service.department;

import com.vidnichuk.isogj.api.dao.DepartmentRepository;
import com.vidnichuk.isogj.api.dto.mapper.DepartmentDtoMapper;
import com.vidnichuk.isogj.api.dto.model.DepartmentDto;
import com.vidnichuk.isogj.api.model.Department;
import com.vidnichuk.isogj.api.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private DepartmentDtoMapper departmentDtoMapper;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentDto> findAllDepartmentsByPartOfNameAndFaculty(String name, DepartmentDto departmentDto) {
        List<DepartmentDto> departmentDtos = new ArrayList<>();
        for (Department department : departmentRepository.findAllByNameContainsAndAndFacultyId(name, departmentDto.getId())){
            departmentDtos.add(departmentDtoMapper.fromDepartmentToDepartmentDto(department));
        }
        return departmentDtos;
    }
}
