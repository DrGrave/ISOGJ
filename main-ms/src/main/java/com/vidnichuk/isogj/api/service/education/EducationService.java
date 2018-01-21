package com.vidnichuk.isogj.api.service.education;

import com.vidnichuk.isogj.api.dto.model.EducationDto;
import com.vidnichuk.isogj.api.dto.model.N_A_EducationDto;

import java.util.List;


public interface EducationService {
    List<EducationDto> findEducationById(Long id);

    N_A_EducationDto getLastEducationByUserId(long id);
}
