package com.vidnichuk.ISOGJ.impl.service;

import com.vidnichuk.ISOGJ.api.dao.TypeOfVacancyRepository;
import com.vidnichuk.ISOGJ.api.entity.TypeOfVacancy;
import com.vidnichuk.ISOGJ.api.service.TypeOfVacancyService;
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

    @Override
    public List<TypeOfVacancy> getAllTypeOfVacancy() {
        return typeOfVacancyRepository.findAll();
    }

    @Override
    public TypeOfVacancy getTypeOfVacancyById(int idTypeOfVacancy) {
        return typeOfVacancyRepository.findByIdTypeOfVacancy(idTypeOfVacancy);
    }

    @Override
    public void saveTypeOfVacancy(TypeOfVacancy typeOfVacancy) {
        typeOfVacancyRepository.save(typeOfVacancy);
    }
}
