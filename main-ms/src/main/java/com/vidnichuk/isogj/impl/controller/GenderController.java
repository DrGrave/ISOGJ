package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.dto.model.GenderDto;
import com.vidnichuk.isogj.api.service.gender.GenderLightWeightService;
import com.vidnichuk.isogj.api.service.user.UserLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/gender")
public class GenderController {

    @Autowired
    private GenderLightWeightService genderLightWeightService;

    @GetMapping("/authorize/all")
    public List<GenderDto> getAllGenders(){
        return genderLightWeightService.getAllGenders();
    }
}
