package com.vidnichuk.ISOGJ.impl.service;

import com.vidnichuk.ISOGJ.api.dao.TypeOfEducationRepository;
import com.vidnichuk.ISOGJ.api.entity.TypeOfEducation;
import com.vidnichuk.ISOGJ.api.service.TypeOfEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implementation of type of education service
 */
@Service
public class TypeOfEducationServiceImpl implements TypeOfEducationService{
    @Autowired
    private TypeOfEducationRepository typeOfEducationRepository;

    @Override
    public List<TypeOfEducation> getAllTypeOfEducation() {
        return typeOfEducationRepository.findAll();
    }

    @Override
    public TypeOfEducation getTypeOfEducationById(int idTypeOfEducation) {
        return typeOfEducationRepository.findByIdTypeOfEducation(idTypeOfEducation);
    }

    @Override
    public void saveTypeOfEducation(TypeOfEducation typeOfEducation) {
        typeOfEducationRepository.save(typeOfEducation);
    }
}
