package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.dto.model.CityDto;
import com.vidnichuk.isogj.api.service.city.CityLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/city")
public class CityController {
    @Autowired
    private CityLightWeightService cityLightWeightService;

    @GetMapping("")
    public List<CityDto> getCityByPartName(@RequestParam("name") String name){
        return cityLightWeightService.getCityByPartName(name);
    }
}
