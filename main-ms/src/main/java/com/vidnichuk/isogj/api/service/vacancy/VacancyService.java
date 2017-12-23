package com.vidnichuk.isogj.api.service.vacancy;

import com.vidnichuk.isogj.api.dto.model.VacancyDto;

import java.util.List;

public interface VacancyService {
    List<VacancyDto> findAllVacancyDto();
}
