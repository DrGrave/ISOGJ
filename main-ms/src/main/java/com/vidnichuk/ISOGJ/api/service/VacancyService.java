package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.Vacancy;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to vacancy repository
 */
public interface VacancyService {

    /**
     *
     * @return
     * all vacancy
     */
    List<Vacancy> getAllVacancy();

    /**
     *
     * @param idVacancy
     * id of vacancy
     * @return
     * vacancy with this id
     */
    Vacancy getById(int idVacancy);

    /**
     *
     * @param vacancy
     * save vacancy
     */
    void saveVacancy(Vacancy vacancy);
}
