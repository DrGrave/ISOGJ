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
    public List<VacancyListDto> getAllVacancy(int page, int size) {
        return vacancyService.findAllVacancyDto(page,size);
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

    @Override
    public List<TaskSkillDto> getSkillsToTask(long id) {
        return vacancyService.getSkillsToTask(id);
    }

    @Override
    public long getCountOfVacancy() {
        return vacancyService.getCountOfVacancy();
    }

    @Override
    public List<VacancyListDto> getVacancysByCompanyId(long id) {
        return vacancyService.getVacancysByCompanyId(id);
    }
}
