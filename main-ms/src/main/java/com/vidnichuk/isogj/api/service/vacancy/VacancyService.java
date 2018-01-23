package com.vidnichuk.isogj.api.service.vacancy;

import com.vidnichuk.isogj.api.dto.model.N_A_VacancyDto;

import java.util.List;

public interface VacancyService {
    List<N_A_VacancyDto> findAllVacancyDto();
}
