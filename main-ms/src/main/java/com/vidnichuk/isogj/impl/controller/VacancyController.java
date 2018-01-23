package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.dto.model.N_A_VacancyDto;

import com.vidnichuk.isogj.api.service.vacancy.VacancyLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/vacancy")
public class VacancyController {
    @Autowired
    private VacancyLightWeightService vacancyLightWeightService;

    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @GetMapping("/all")
    public List<N_A_VacancyDto> getListOfVacancy(){
        return vacancyLightWeightService.getAllVacancy();
    }
}
