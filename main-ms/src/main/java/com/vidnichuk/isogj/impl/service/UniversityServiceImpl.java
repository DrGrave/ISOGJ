package com.vidnichuk.isogj.impl.service;

import com.vidnichuk.isogj.api.dao.UniversityRepository;
import com.vidnichuk.isogj.api.entity.University;
import com.vidnichuk.isogj.api.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implementation of university service
 */

@Service
public class UniversityServiceImpl implements UniversityService{
    @Autowired
    private UniversityRepository universityRepository;

    /**
     *
     * @return
     * all university
     */
    @Override
    public List<University> getAllUniversity() {
        return universityRepository.findAll();
    }

    /**
     *
     * @param idUniversity
     * id university
     * @return
     * university with this id
     */
    @Override
    public University getUniversityById(int idUniversity) {
        return universityRepository.findByIdUniversity(idUniversity);
    }

    /**
     *
     * @param university
     * save university
     */
    @Override
    public void saveUniversity(University university) {
        universityRepository.save(university);
    }
}
