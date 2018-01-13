package com.vidnichuk.isogj.api.service.education;

import com.vidnichuk.isogj.api.dto.model.EducationDto;

import java.util.List;

public interface EducationLightWeightService {

    List<EducationDto> getEducationById(Long id);
}
