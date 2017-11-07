package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.TypeOfEducation;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to type of education repository
 */
public interface TypeOfEducationService {
    List<TypeOfEducation> getAllTypeOfEducation();
    TypeOfEducation getTypeOfEducationById(int idTypeOfEducation);
    void saveTypeOfEducation(TypeOfEducation typeOfEducation);
}
