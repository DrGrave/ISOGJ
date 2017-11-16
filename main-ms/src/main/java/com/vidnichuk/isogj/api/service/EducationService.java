package com.vidnichuk.isogj.api.service;

import com.vidnichuk.isogj.api.entity.Education;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to education repository
 */
public interface EducationService {
    /**
     *
     * @return
     * lis of all education
     */
    List<Education> getAllEducation();

    /**
     *
     * @param idEducation
     * id of education
     * @return
     * get education with this id
     */
    Education getEducationById(int idEducation);

    /**
     *
     * @param education
     * save education to db
     */
    void saveEducation(Education education);
}
