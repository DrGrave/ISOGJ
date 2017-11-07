package com.vidnichuk.ISOGJ.impl.service;

import com.vidnichuk.ISOGJ.api.dao.UniversityRepository;
import com.vidnichuk.ISOGJ.api.entity.University;
import com.vidnichuk.ISOGJ.api.service.UniversityService;
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

    @Override
    public List<University> getAllUniversity() {
        return universityRepository.findAll();
    }

    @Override
    public University getUniversityById(int idUniversity) {
        return universityRepository.findByIdUniversity(idUniversity);
    }

    @Override
    public void saveUniversity(University university) {
        universityRepository.save(university);
    }
}
