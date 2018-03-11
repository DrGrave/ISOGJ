package com.vidnichuk.isogj.impl.service.education;

import com.vidnichuk.isogj.api.dao.EducationRepository;
import com.vidnichuk.isogj.api.dao.TypeOfEducationRepository;
import com.vidnichuk.isogj.api.dao.UserRepository;
import com.vidnichuk.isogj.api.dto.mapper.EducationDtoMapper;
import com.vidnichuk.isogj.api.dto.mapper.TypeOfEducationDtoMapper;
import com.vidnichuk.isogj.api.dto.model.EducationDto;
import com.vidnichuk.isogj.api.dto.model.EducationSkillsDto;
import com.vidnichuk.isogj.api.dto.model.N_A_EducationDto;
import com.vidnichuk.isogj.api.dto.model.TypeOfEducationDto;
import com.vidnichuk.isogj.api.model.Education;
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
    private TypeOfEducationRepository typeOfEducationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SkillService skillService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private TypeOfEducationDtoMapper typeOfEducationDtoMapper;

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
    public List<EducationDto> changeEducation(EducationDto educationDto, String id) {
        Education education = educationDtoMapper.fromEducationDtoToEducation(educationDto);
        education.setUser(userRepository.findByUid(id));
        educationRepository.save(education);
        List<EducationDto> educationDtoList = new ArrayList<>();
        for (Education educ: educationRepository.findAllByUser_Id(userRepository.findByUid(id).getId())){
            educationDtoList.add(educationDtoMapper.formEducationToEducationDto(educ));
        }
        return educationDtoList;
    }

    @Override
    public List<EducationSkillsDto> addEducation(EducationDto educationDto, String name) {
        Education education = educationDtoMapper.fromEducationDtoToEducation(educationDto);
        education.setUser(userRepository.findByUsername(name));
        educationRepository.save(education);

        return getEducationSkills(userRepository.findByUsername(name).getId());
    }

    @Override
    public List<EducationDto> deleteEducation(EducationDto educationDto, String id) {
        educationRepository.delete(educationDtoMapper.fromEducationDtoToEducation(educationDto));
        List<EducationDto> educationDtoList = new ArrayList<>();
        for (Education educ: educationRepository.findAllByUser_Id(userRepository.findByUid(id).getId())){
            educationDtoList.add(educationDtoMapper.formEducationToEducationDto(educ));
        }
        return educationDtoList;
    }

    @Override
    public List<EducationSkillsDto> getEducationSkills(Long id) {
        List<EducationSkillsDto> educationSkillsDtoList = new ArrayList<>();
        for (Education education: educationRepository.findAllByUser_Id(id)){
            educationSkillsDtoList.add(new EducationSkillsDto(educationDtoMapper.formEducationToEducationDto(education), skillService.getDepartmentSkills(education.getDepartment().getId())));
        }
        return educationSkillsDtoList;
    }

    @Override
    public EducationSkillsDto getOneEducationById(Long id) {
        EducationSkillsDto educationSkillsDto = new EducationSkillsDto();
        educationSkillsDto.setEducationDto(educationDtoMapper.formEducationToEducationDto(educationRepository.findOne(id)));
        educationSkillsDto.setDepartmentSkillDtoList(skillService.getDepartmentSkills(educationRepository.findOne(id).getDepartment().getId()));
        return educationSkillsDto;
    }
}
