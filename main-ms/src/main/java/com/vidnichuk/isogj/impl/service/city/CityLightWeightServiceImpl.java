package com.vidnichuk.isogj.impl.service.city;

import com.vidnichuk.isogj.api.dto.model.CityDto;
import com.vidnichuk.isogj.api.service.city.CityLightWeightService;
import com.vidnichuk.isogj.api.service.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityLightWeightServiceImpl implements CityLightWeightService{
    @Autowired
    private CityService cityService;

    @Override
    public List<CityDto> getCityByPartName(String name) {
        return cityService.getCityByPartName(name);
    }
}
