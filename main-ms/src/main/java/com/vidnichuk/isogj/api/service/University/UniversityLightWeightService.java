package com.vidnichuk.isogj.api.service.University;

import com.vidnichuk.isogj.api.dto.model.UniversityDto;

import java.util.List;

public interface UniversityLightWeightService {
    List<UniversityDto> getUniversitysByPartName(String name);
}
