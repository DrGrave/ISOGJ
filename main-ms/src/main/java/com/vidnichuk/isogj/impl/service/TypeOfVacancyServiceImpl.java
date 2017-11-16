package com.vidnichuk.isogj.impl.service;

import com.vidnichuk.isogj.api.dao.TypeOfVacancyRepository;
import com.vidnichuk.isogj.api.entity.TypeOfVacancy;
import com.vidnichuk.isogj.api.service.TypeOfVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implementation of type of vacancy service
 */

@Service
public class TypeOfVacancyServiceImpl implements TypeOfVacancyService{
    @Autowired
    private TypeOfVacancyRepository typeOfVacancyRepository;

    /**
     *
     * @return
     * all types of vacancy
     */
    @Override
    public List<TypeOfVacancy> getAllTypeOfVacancy() {
        return typeOfVacancyRepository.findAll();
    }

    /**
     *
     * @param idTypeOfVacancy
     * id type of vacancy
     * @return
     * type of vacancy with this id
     */
    @Override
    public TypeOfVacancy getTypeOfVacancyById(int idTypeOfVacancy) {
        return typeOfVacancyRepository.findByIdTypeOfVacancy(idTypeOfVacancy);
    }

    /**
     *
     * @param typeOfVacancy
     * save type of vacancy
     */
    @Override
    public void saveTypeOfVacancy(TypeOfVacancy typeOfVacancy) {
        typeOfVacancyRepository.save(typeOfVacancy);
    }
}
