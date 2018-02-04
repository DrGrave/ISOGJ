package com.vidnichuk.isogj.api.service.education;

import com.vidnichuk.isogj.api.dto.model.EducationDto;
import com.vidnichuk.isogj.api.dto.model.N_A_EducationDto;
import com.vidnichuk.isogj.api.dto.model.TypeOfEducationDto;

import java.util.List;

public interface EducationLightWeightService {

    List<EducationDto> getEducationById(Long id);

    List<N_A_EducationDto> getLastEducationByUserId(long id);

    List<TypeOfEducationDto> getAllTypesOfEducation();

    List<EducationDto> changeEducation(EducationDto educationDto, Long id);

    List<EducationDto> addEducation(EducationDto educationDto, Long id);

    List<EducationDto> deleteEducation(EducationDto educationDto, Long id);
}
