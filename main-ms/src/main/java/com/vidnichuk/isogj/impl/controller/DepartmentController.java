package com.vidnichuk.isogj.impl.controller;


import com.vidnichuk.isogj.api.dto.model.DepartmentDto;
import com.vidnichuk.isogj.api.service.department.DepartmentLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "department")
public class DepartmentController {
    @Autowired
    private DepartmentLightWeightService departmentLightWeightService;

    @PostMapping()
    public List<DepartmentDto> findAllDepartmentsByPartOfNameAndFaculty(@Valid @RequestBody DepartmentDto departmentDto, @RequestParam("name") String name){
        return departmentLightWeightService.findAllDepartmentsByPartOfNameAndFaculty(name, departmentDto);
    }
}
