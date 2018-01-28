package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.dto.model.UniversityDto;
import com.vidnichuk.isogj.api.service.University.UniversityLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {

    @Autowired
    private UniversityLightWeightService universityLightWeightService;

    @GetMapping("/all")
    public List<UniversityDto> getUniversitysByPartName(@RequestParam("name") String name){
        return universityLightWeightService.getUniversitysByPartName(name);
    }
}
