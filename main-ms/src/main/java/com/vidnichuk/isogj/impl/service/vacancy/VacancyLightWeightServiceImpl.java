package com.vidnichuk.isogj.impl.service.vacancy;

import com.vidnichuk.isogj.api.dto.model.*;
import com.vidnichuk.isogj.api.service.vacancy.VacancyLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacancyLightWeightServiceImpl implements VacancyLightWeightService{
    @Autowired
    private VacancyServiceImpl vacancyService;



    @Override
    public List<N_A_VacancyDto> getAllVacancy() {
        return vacancyService.findAllVacancyDto();
    }

    @Override
    public List<UserDto> getUsersByCompanyId(long id, boolean us, boolean comp) {
        return vacancyService.getUserByCompanyId(id, us , comp);
    }

    @Override
    public List<VacancyDto> getVacancyByCompanyId(long id) {
        return vacancyService.getVacancyByCompanyId(id);
    }

    @Override
    public List<VacancyTaskDto> getTasksByVacancyId(long id) {
        return vacancyService.getTasksByVacancyId(id);
    }
}
