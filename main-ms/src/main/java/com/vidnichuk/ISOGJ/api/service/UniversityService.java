package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.University;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to university repository
 */
public interface UniversityService {

    /**
     *
     * @return
     * all university
     */
    List<University> getAllUniversity();

    /**
     *
     * @param idUniversity
     * id university
     * @return
     * university with this id
     */
    University getUniversityById(int idUniversity);

    /**
     *
     * @param university
     * save university
     */
    void saveUniversity(University university);
}
