package com.vidnichuk.isogj.impl.service.department;

import com.vidnichuk.isogj.api.dto.model.DepartmentDto;

import com.vidnichuk.isogj.api.dto.model.SubjectSkillUserDto;
import com.vidnichuk.isogj.api.model.Subject;
import com.vidnichuk.isogj.api.model.SubjectSkill;
import com.vidnichuk.isogj.api.model.SubjectSkillUser;
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
    public List<SubjectSkill> findAllSubjectsSkillsByDepartment(String departmentName) {
        return departmentService.findAllSubjectsSkillsByDepartment(departmentName);
    }

    @Override
    public  List<Subject> findAllSubjectByDepartment(String name){
        return departmentService.findAllSubjectByDepartmentName(name);
    }

    @Override
    public List<SubjectSkillUserDto> findAllSubjectsUserSkillsByUser(String name, String userName) {
        return departmentService.findAllSkillsByDepartmentAndUser(name, userName);
    }

    @Override
    public List<DepartmentDto> findAllDepartmentsByPartOfNameAndFaculty(String name, DepartmentDto departmentDto) {
       return departmentService.findAllDepartmentsByPartOfNameAndFaculty(name, departmentDto);
    }
}
