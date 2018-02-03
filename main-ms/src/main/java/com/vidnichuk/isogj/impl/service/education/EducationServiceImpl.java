package com.vidnichuk.isogj.impl.service.education;

import com.vidnichuk.isogj.api.dao.EducationRepository;
import com.vidnichuk.isogj.api.dao.TypeOfEducationRepository;
import com.vidnichuk.isogj.api.dao.UserRepository;
import com.vidnichuk.isogj.api.dto.mapper.EducationDtoMapper;
import com.vidnichuk.isogj.api.dto.mapper.TypeOfEducationDtoMapper;
import com.vidnichuk.isogj.api.dto.mapper.TypeOfSkillDtoMapper;
import com.vidnichuk.isogj.api.dto.model.EducationDto;
import com.vidnichuk.isogj.api.dto.model.N_A_EducationDto;
import com.vidnichuk.isogj.api.dto.model.TypeOfEducationDto;
import com.vidnichuk.isogj.api.model.Education;
import com.vidnichuk.isogj.api.model.type.TypeOfEducation;
import com.vidnichuk.isogj.api.service.education.EducationService;

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

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private TypeOfEducationDtoMapper typeOfEducationDtoMapper;

    @Override
    public List<EducationDto> findEducationById(Long id) {
        List<EducationDto> educationDtos = new ArrayList<>();
        for (Education education : educationRepository.findAllByUser_Id(id)){
            educationDtos.add(educationDtoMapper.formEducationToEducationDto(education));
        }
        return educationDtos;
    }

    @Override
    public List<N_A_EducationDto> getLastEducationByUserId(long id) {
        List<N_A_EducationDto> n_a_educationDtoList = new ArrayList<>();
        for (Education education: educationRepository.findAllByUserIdOrderByDateOfEnd(id)){
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
    public void changeEducation(EducationDto educationDto, Long id) {
        Education education = educationDtoMapper.fromEducationDtoToEducation(educationDto);
        education.setUser(userRepository.findById(id));
        educationRepository.save(education);
    }

    @Override
    public void addEducation(EducationDto educationDto, Long id) {
        Education education = educationDtoMapper.fromEducationDtoToEducation(educationDto);
        education.setUser(userRepository.findById(id));
        educationRepository.save(education);
    }
}
