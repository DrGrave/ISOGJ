package com.vidnichuk.isogj.impl.service.education;

import com.vidnichuk.isogj.api.dto.model.EducationDto;
import com.vidnichuk.isogj.api.dto.model.EducationSkillsDto;
import com.vidnichuk.isogj.api.dto.model.N_A_EducationDto;
import com.vidnichuk.isogj.api.dto.model.TypeOfEducationDto;
import com.vidnichuk.isogj.api.service.education.EducationLightWeightService;
import com.vidnichuk.isogj.api.service.education.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationLightWeightServiceImpl implements EducationLightWeightService{

    @Autowired
    private EducationService educationService;

    @Override
    public List<EducationDto> getEducationById(String id) {
        return educationService.findEducationById(id);
    }

    @Override
    public List<N_A_EducationDto> getLastEducationByUserId(String id) {
        return educationService.getLastEducationByUserId(id);
    }

    @Override
    public List<TypeOfEducationDto> getAllTypesOfEducation() {
        return educationService.getAllTypesOfEducation();
    }

    @Override
    public List<EducationDto> changeEducation(EducationDto educationDto, String id) {
        return educationService.changeEducation(educationDto, id);

    }

    @Override
    public List<EducationSkillsDto> addEducation(EducationDto educationDto, String name) {
        return educationService.addEducation(educationDto, name);
    }

    @Override
    public List<EducationDto> deleteEducation(EducationDto educationDto, String name) {
        return educationService.deleteEducation(educationDto, name);
    }
}
