package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.TypeOfEducation;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to type of education repository
 */
public interface TypeOfEducationService {
    /**
     *
     * @return
     * all type of education
     */
    List<TypeOfEducation> getAllTypeOfEducation();

    /**
     *
     * @param idTypeOfEducation
     * id type of education
     * @return
     * type of education with this id
     */
    TypeOfEducation getTypeOfEducationById(int idTypeOfEducation);

    /**
     *
     * @param typeOfEducation
     * save type of education
     */
    void saveTypeOfEducation(TypeOfEducation typeOfEducation);
}
