package com.vidnichuk.isogj.impl.service.department;

import com.vidnichuk.isogj.api.dao.*;
import com.vidnichuk.isogj.api.dto.mapper.*;
import com.vidnichuk.isogj.api.dto.model.*;
import com.vidnichuk.isogj.api.model.Department;
import com.vidnichuk.isogj.api.model.Subject;
import com.vidnichuk.isogj.api.model.SubjectSkill;
import com.vidnichuk.isogj.api.model.SubjectSkillUser;
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

    @Autowired
    private SubjectSkillUserRepository subjectSkillUserRepository;

    @Autowired
    private SubjectSkillUserDtoMapper subjectSkillUserDtoMapper;

    @Autowired
    private SubjectSkillRepository subjectSkillRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubjectSkillDtoMapper subjectSkillDtoMapper;

    @Autowired
    private SubjectDtoMapper subjectDtoMapper;

    @Autowired
    private SkillDtoMapper skillDtoMapper;


    @Override
    public List<Subject> findAllSubjectByDepartmentName(String name) {
        return subjectRepository.findAllByDepartmentId(Integer.parseInt(name));
    }

    @Override
    public List<SubjectSkill> findAllSubjectsSkillsByDepartment(String departmentName) {
        return subjectSkillRepository.findAllBySubjectDepartmentId(Integer.parseInt(departmentName));
    }

    @Override
    public List<SubjectSkillUserDto> findAllSkillsByDepartmentAndUser(String name, String userName) {
        List<SubjectSkill> subjectSkills = subjectSkillRepository.findAllBySubjectDepartmentId(Integer.parseInt(name));
        List<SubjectSkillUserDto> subjectSkillUserDtoList = new ArrayList<>();
        for (SubjectSkill subjectSkill: subjectSkills){
            for (SubjectSkillUser subjectSkillUser : subjectSkillUserRepository.findAllBySubjectSkillIdAndUserId(subjectSkill.getId(), userRepository.findByUsername(userName).getId())) {
                SubjectDto subjectDto = subjectDtoMapper.fromSubjectToSubjectDto(subjectSkill.getSubject());
                SkillDto skillDto = skillDtoMapper.fromSkillToSkillDtoMapper(subjectSkill.getSkill());
                SubjectSkillDto subjectSkillDto = new SubjectSkillDto();
                subjectSkillDto.setSkillDto(skillDto);
                subjectSkillDto.setSubjectDto(subjectDto);
                subjectSkillDto.setPersentOfSkill(subjectSkill.getPercentOfSkill());
                subjectSkillDto.setPersentOfSubject(subjectSkill.getPercentOfSubject());
                subjectSkillDto.setId(subjectSkill.getId());
                SubjectSkillUserDto subjectSkillUserDto = subjectSkillUserDtoMapper.fromSubjectSkillUserToSubjectSkillUserDto(subjectSkillUser);
                subjectSkillUserDto.setSubjectSkill(subjectSkillDto);
                subjectSkillUserDtoList.add(subjectSkillUserDto);
            }
        }

        return subjectSkillUserDtoList;
    }

    @Override
    public List<DepartmentDto> findAllDepartmentsByPartOfNameAndFaculty(String name, DepartmentDto departmentDto) {
        List<DepartmentDto> departmentDtos = new ArrayList<>();
        for (Department department : departmentRepository.findAllByNameContainsAndAndFacultyId(name, departmentDto.getId())){
            departmentDtos.add(departmentDtoMapper.fromDepartmentToDepartmentDto(department));
        }
        return departmentDtos;
    }
}
