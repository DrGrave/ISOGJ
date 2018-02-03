package com.vidnichuk.isogj.api.service.education;

import com.vidnichuk.isogj.api.dto.model.EducationDto;
import com.vidnichuk.isogj.api.dto.model.N_A_EducationDto;
import com.vidnichuk.isogj.api.dto.model.TypeOfEducationDto;

import java.util.List;


public interface EducationService {
    List<EducationDto> findEducationById(Long id);

    List<N_A_EducationDto> getLastEducationByUserId(long id);

    List<TypeOfEducationDto> getAllTypesOfEducation();

    void changeEducation(EducationDto educationDto, Long id);

    void addEducation(EducationDto educationDto, Long id);
}
