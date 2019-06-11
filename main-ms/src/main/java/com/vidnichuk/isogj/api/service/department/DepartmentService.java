package com.vidnichuk.isogj.api.service.department;

import com.vidnichuk.isogj.api.dto.model.DepartmentDto;
import com.vidnichuk.isogj.api.dto.model.SubjectSkillUserDto;
import com.vidnichuk.isogj.api.model.Subject;
import com.vidnichuk.isogj.api.model.SubjectSkill;
import com.vidnichuk.isogj.api.model.SubjectSkillUser;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> findAllDepartmentsByPartOfNameAndFaculty(String name, DepartmentDto departmentDto);

    List<SubjectSkillUserDto> findAllSkillsByDepartmentAndUser(String name, String userName);

    List<Subject> findAllSubjectByDepartmentName(String name);

    List<SubjectSkill> findAllSubjectsSkillsByDepartment(String departmentName);
}
