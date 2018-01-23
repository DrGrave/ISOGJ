package com.vidnichuk.isogj.api.service.gender;

import com.vidnichuk.isogj.api.dto.model.GenderDto;

import java.util.List;

public interface GenderLightWeightService {
    List<GenderDto> getAllGenders();
}
