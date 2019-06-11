package com.vidnichuk.isogj.impl.controller;


import com.vidnichuk.isogj.api.dto.model.DepartmentDto;
import com.vidnichuk.isogj.api.dto.model.SubjectSkillUserDto;
import com.vidnichuk.isogj.api.model.Subject;
import com.vidnichuk.isogj.api.model.SubjectSkill;
import com.vidnichuk.isogj.api.model.SubjectSkillUser;
import com.vidnichuk.isogj.api.service.department.DepartmentLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
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

    @GetMapping("/getDepartmentSkills")
    public List<SubjectSkillUserDto> findAllSubjectUserSkillsByDepartment(@RequestParam("departmentName") String departmentName, Principal principal){
        return departmentLightWeightService.findAllSubjectsUserSkillsByUser(departmentName, principal.getName());
    }

    @GetMapping("/getSubjects")
    public List<Subject> findAllSubjects(@RequestParam("departmentName") String departmentId){
        return departmentLightWeightService.findAllSubjectByDepartment(departmentId);
    }

    @GetMapping("/getSubjectsSkills")
    public List<SubjectSkill> findAllSubjectSkills(@RequestParam("departmentName") String departmentName){
        return departmentLightWeightService.findAllSubjectsSkillsByDepartment(departmentName);
    }
}
