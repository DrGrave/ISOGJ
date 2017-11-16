package com.vidnichuk.isogj.impl.service;

import com.vidnichuk.isogj.api.dao.EducationRepository;
import com.vidnichuk.isogj.api.entity.Education;
import com.vidnichuk.isogj.api.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implementation of education service
 */
@Service
public class EducationServiceImpl implements EducationService{
    @Autowired
    private EducationRepository educationRepository;

    /**
     *
     * @return
     * all educations
     */
    @Override
    public List<Education> getAllEducation() {
        return educationRepository.findAll();
    }

    /**
     *
     * @param idEducation
     * id of education
     * @return
     * education with this id
     */
    @Override
    public Education getEducationById(int idEducation) {
        return educationRepository.findByIdOfEducation(idEducation);
    }

    /**
     *
     * @param education
     * save education
     */
    @Override
    public void saveEducation(Education education) {
        educationRepository.save(education);
    }
}
