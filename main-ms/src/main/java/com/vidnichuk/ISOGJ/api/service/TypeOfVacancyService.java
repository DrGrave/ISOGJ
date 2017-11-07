package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.TypeOfVacancy;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to type of vacancy repository
 */
public interface TypeOfVacancyService {
    List<TypeOfVacancy> getAllTypeOfVacancy();
    TypeOfVacancy getTypeOfVacancyById(int idTypeOfVacancy);
    void saveTypeOfVacancy(TypeOfVacancy typeOfVacancy);
}
