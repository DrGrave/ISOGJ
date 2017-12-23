package com.vidnichuk.isogj.impl.service.vacancy;

import com.vidnichuk.isogj.api.dto.model.VacancyDto;
import com.vidnichuk.isogj.api.service.vacancy.VacancyLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacancyLightWeightServiceImpl implements VacancyLightWeightService{
    @Autowired
    private VacancyServiceImpl vacancyService;



    @Override
    public List<VacancyDto> getAllVacancy() {
        return vacancyService.findAllVacancyDto();
    }
}
