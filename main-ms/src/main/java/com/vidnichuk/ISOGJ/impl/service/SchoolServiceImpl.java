package com.vidnichuk.ISOGJ.impl.service;

import com.vidnichuk.ISOGJ.api.dao.SchoolRepository;
import com.vidnichuk.ISOGJ.api.entity.School;
import com.vidnichuk.ISOGJ.api.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implementation of school service
 */
@Service
public class SchoolServiceImpl implements SchoolService{
    @Autowired
    private SchoolRepository schoolRepository;

    /**
     *
     * @return
     * all schools
     */
    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    /**
     *
     * @param idOfSchool
     * id of school
     * @return
     * school with this id
     */
    @Override
    public School getSchoolById(int idOfSchool) {
        return schoolRepository.findByIdSchool(idOfSchool);
    }

    /**
     *
     * @param school
     * save school
     */
    @Override
    public void saveSchool(School school) {
        schoolRepository.save(school);
    }
}
