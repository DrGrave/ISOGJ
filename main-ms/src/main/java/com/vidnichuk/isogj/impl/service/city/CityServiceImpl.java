package com.vidnichuk.isogj.impl.service.city;

import com.vidnichuk.isogj.api.dao.CityRepository;
import com.vidnichuk.isogj.api.dto.mapper.CityDtoMapper;
import com.vidnichuk.isogj.api.dto.model.CityDto;
import com.vidnichuk.isogj.api.model.City;
import com.vidnichuk.isogj.api.service.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private CityRepository cityRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CityDtoMapper cityDtoMapper;

    @Override
    public List<CityDto> getCityByPartName(String name) {
        List<CityDto> cityDtoList = new ArrayList<>();
        for (City city: cityRepository.findAllByNameContains(name)){
            cityDtoList.add(cityDtoMapper.fromCityToCityDto(city));
        }
        return cityDtoList;
    }
}
