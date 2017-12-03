package com.vidnichuk.isogj.api.service;

import com.vidnichuk.isogj.api.dto.VacancyDTO;
import com.vidnichuk.isogj.api.entity.Vacancy;

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
    List<VacancyDTO> getAllVacancy();

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
