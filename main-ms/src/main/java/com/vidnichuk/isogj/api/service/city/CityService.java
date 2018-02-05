package com.vidnichuk.isogj.api.service.city;

import com.vidnichuk.isogj.api.dto.model.CityDto;

import java.util.List;

public interface CityService {
    List<CityDto> getCityByPartName(String name);
}
