package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.Vacancy;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to vacancy repository
 */
public interface VacancyService {
    List<Vacancy> getAllVacancy();
    Vacancy getById(int idVacancy);
    void saveVacancy(Vacancy vacancy);
}
