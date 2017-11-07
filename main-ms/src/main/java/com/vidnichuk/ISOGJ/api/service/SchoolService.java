package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.School;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to school repository
 */
public interface SchoolService {
    /**
     *
     * @return
     * all schools
     */
    List<School> getAllSchools();

    /**
     *
     * @param idOfSchool
     * id of school
     * @return
     * school with this id
     */
    School getSchoolById(int idOfSchool);

    /**
     *
     * @param school
     * save school
     */
    void saveSchool(School school);
}
