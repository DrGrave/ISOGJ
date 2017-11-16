package com.vidnichuk.isogj.api.service;

import com.vidnichuk.isogj.api.entity.TypeOfVacancy;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to type of vacancy repository
 */
public interface TypeOfVacancyService {

    /**
     *
     * @return
     * all types of vacancy
     */
    List<TypeOfVacancy> getAllTypeOfVacancy();

    /**
     *
     * @param idTypeOfVacancy
     * id type of vacancy
     * @return
     * type of vacancy with this id
     */
    TypeOfVacancy getTypeOfVacancyById(int idTypeOfVacancy);

    /**
     *
     * @param typeOfVacancy
     * save type of vacancy
     */
    void saveTypeOfVacancy(TypeOfVacancy typeOfVacancy);
}
