package com.vidnichuk.isogj.api.service.vacancy;

import com.vidnichuk.isogj.api.dto.model.*;

import java.util.List;

public interface VacancyLightWeightService {
    List<VacancyListDto> getAllVacancy(int page, int size);

    List<UserDto> getUsersByCompanyId(long id, boolean us, boolean comp);


    List<VacancyDto> getVacancyByCompanyId(long id);

    List<VacancyTaskDto> getTasksByVacancyId(long id);

    List<TaskSkillDto> getSkillsToTask(long id);

    long getCountOfVacancy();

    List<VacancyListDto> getVacancysByCompanyId(long id);
}
