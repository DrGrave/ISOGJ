package com.vidnichuk.isogj.impl.service.education;

import com.vidnichuk.isogj.api.dao.*;
import com.vidnichuk.isogj.api.dto.mapper.EducationDtoMapper;
import com.vidnichuk.isogj.api.dto.mapper.SubjectSkillUserDtoMapper;
import com.vidnichuk.isogj.api.dto.mapper.TypeOfEducationDtoMapper;
import com.vidnichuk.isogj.api.dto.model.*;
import com.vidnichuk.isogj.api.model.Education;
import com.vidnichuk.isogj.api.model.SubjectSkillUser;
import com.vidnichuk.isogj.api.model.type.TypeOfEducation;
import com.vidnichuk.isogj.api.service.education.EducationService;

import com.vidnichuk.isogj.api.service.skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EducationServiceImpl implements EducationService{

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private EducationDtoMapper educationDtoMapper;

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TypeOfEducationRepository typeOfEducationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SkillService skillService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private TypeOfEducationDtoMapper typeOfEducationDtoMapper;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectSkillUserRepository subjectSkillUserRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private SubjectSkillUserDtoMapper subjectSkillUserDtoMapper;

    @Override
    public List<EducationDto> findEducationById(String id) {
        List<EducationDto> educationDtos = new ArrayList<>();
        for (Education education : educationRepository.findAllByUser_Id(userRepository.findByUid(id).getId())){
            educationDtos.add(educationDtoMapper.formEducationToEducationDto(education));
        }
        return educationDtos;
    }

    @Override
    public List<N_A_EducationDto> getLastEducationByUserId(String id) {
        List<N_A_EducationDto> n_a_educationDtoList = new ArrayList<>();
        for (Education education: educationRepository.findAllByUserIdOrderByDateOfEnd(userRepository.findByUid(id).getId())){
            n_a_educationDtoList.add(educationDtoMapper.fromEducationToNAEducationDto(education));
        }
        return n_a_educationDtoList;
    }

    @Override
    public List<TypeOfEducationDto> getAllTypesOfEducation() {
        List<TypeOfEducationDto> typeOfEducationDtos = new ArrayList<>();
        for (TypeOfEducation typeOfEducation: typeOfEducationRepository.findAll()){
            typeOfEducationDtos.add(typeOfEducationDtoMapper.fromTypeOfEducationToTypeOfEducationDto(typeOfEducation));
        }
        return typeOfEducationDtos;
    }

    @Override
    public List<EducationSkillsDto> changeEducation(EducationDto educationDto, String name) {
        Education education = educationDtoMapper.fromEducationDtoToEducation(educationDto);
        if (universityRepository.findByName(education.getDepartment().getFaculty().getUniversity().getName()) == null){
            universityRepository.save(education.getDepartment().getFaculty().getUniversity());
            facultyRepository.save(education.getDepartment().getFaculty());
            departmentRepository.save(education.getDepartment());
        }else if (facultyRepository.findByName(education.getDepartment().getFaculty().getName()) == null){
            facultyRepository.save(education.getDepartment().getFaculty());
            departmentRepository.save(education.getDepartment());
        } else if (departmentRepository.findByName(education.getDepartment().getName()) == null){
            departmentRepository.save(education.getDepartment());
        }
        education.setUser(userRepository.findByUsername(name));
        educationRepository.save(education);
        return getEducationSkills(userRepository.findByUsername(name).getId());
    }

    @Override
    public List<EducationSkillsDto> addEducation(EducationDto educationDto, String name) {

        Education education = educationDtoMapper.fromEducationDtoToEducation(educationDto);
            if (universityRepository.findByName(education.getDepartment().getFaculty().getUniversity().getName()) == null){
                universityRepository.save(education.getDepartment().getFaculty().getUniversity());
                facultyRepository.save(education.getDepartment().getFaculty());
                departmentRepository.save(education.getDepartment());
            }else if (facultyRepository.findByName(education.getDepartment().getFaculty().getName()) == null){
                facultyRepository.save(education.getDepartment().getFaculty());
                departmentRepository.save(education.getDepartment());
            } else if (departmentRepository.findByName(education.getDepartment().getName()) == null){
                departmentRepository.save(education.getDepartment());
            }
            education.setUser(userRepository.findByUsername(name));
            educationRepository.save(education);
            return getEducationSkills(userRepository.findByUsername(name).getId());
    }

    @Override
    public List<EducationSkillsDto> deleteEducation(String userName, Long idEducation) {
        educationRepository.delete(idEducation);
        return getEducationSkills(userRepository.findByUsername(userName).getId());
    }

    @Override
    public List<EducationSkillsDto> getEducationSkills(Long id) {
        List<EducationSkillsDto> educationSkillsDtoList = new ArrayList<>();
        for (Education education: educationRepository.findAllByUser_Id(id)){

            List<SubjectSkillUserDto> subjectSkillUserDto = new ArrayList<>();
            for (SubjectSkillUser subjectSkillUser :  subjectSkillUserRepository.findAllBySubjectSkillSubjectDepartment_Id(education.getDepartment().getId())){
                subjectSkillUserDto.add(subjectSkillUserDtoMapper.fromSubjectSkillUserToSubjectSkillUserDto(subjectSkillUser));
            }
            educationSkillsDtoList.add(new EducationSkillsDto(educationDtoMapper.formEducationToEducationDto(education), subjectSkillUserDto));
        }
        return educationSkillsDtoList;
    }

    @Override
    public EducationSkillsDto getOneEducationById(Long id) {
        EducationSkillsDto educationSkillsDto = new EducationSkillsDto();
        educationSkillsDto.setEducationDto(educationDtoMapper.formEducationToEducationDto(educationRepository.findOne(id)));
        /**
         *  educationSkillsDto.setDepartmentSkillDtoList(skillService.getDepartmentSkills(educationRepository.findOne(id).getDepartment().getId()));
         *
         * and this
         */
        return educationSkillsDto;
    }
}
