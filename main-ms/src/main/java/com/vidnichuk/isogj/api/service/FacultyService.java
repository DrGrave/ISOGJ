package com.vidnichuk.isogj.api.service;

import com.vidnichuk.isogj.api.entity.Faculty;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to faculty repository
 */
public interface FacultyService {
    /**
     *
     * @return
     * all faculty
     */
    List<Faculty> getAllFaculty();

    /**
     *
     * @param idFaculty
     * id of faculty
     * @return
     * faculty with this id
     */
    Faculty getFacultyById(int idFaculty);

    /**
     *
     * @param faculty
     * save faculty
     */
    void saveFaculty(Faculty faculty);
}
