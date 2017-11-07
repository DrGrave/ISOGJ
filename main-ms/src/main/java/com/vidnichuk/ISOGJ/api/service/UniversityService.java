package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.University;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to university repository
 */
public interface UniversityService {
    List<University> getAllUniversity();
    University getUniversityById(int idUniversity);
    void saveUniversity(University university);
}
