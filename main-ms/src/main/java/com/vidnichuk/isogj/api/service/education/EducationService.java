package com.vidnichuk.isogj.api.service.education;

import com.vidnichuk.isogj.api.dto.model.EducationDto;
import com.vidnichuk.isogj.api.dto.model.EducationSkillsDto;
import com.vidnichuk.isogj.api.dto.model.N_A_EducationDto;
import com.vidnichuk.isogj.api.dto.model.TypeOfEducationDto;

import java.util.List;


public interface EducationService {
    List<EducationDto> findEducationById(String id);

    List<N_A_EducationDto> getLastEducationByUserId(String id);

    List<TypeOfEducationDto> getAllTypesOfEducation();

    List<EducationSkillsDto> changeEducation(EducationDto educationDto, String id);

    List<EducationSkillsDto> addEducation(EducationDto educationDto, String name);

    List<EducationSkillsDto> deleteEducation(String userName, Long idEducation);

    List<EducationSkillsDto> getEducationSkills(Long id);

    EducationSkillsDto getOneEducationById(Long id);
}
