package com.vidnichuk.isogj.impl.service;

import com.vidnichuk.isogj.api.dao.FacultyRepository;
import com.vidnichuk.isogj.api.entity.Faculty;
import com.vidnichuk.isogj.api.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implements of faculty service
 */
@Service
public class FacultyServiceImpl implements FacultyService{
    @Autowired
    private FacultyRepository facultyRepository;

    /**
     *
     * @return
     * all faculty
     */
    @Override
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    /**
     *
     * @param idFaculty
     * id of faculty
     * @return
     * faculty with this id
     */
    @Override
    public Faculty getFacultyById(int idFaculty) {
        return facultyRepository.findByIdFaculty(idFaculty);
    }

    /**
     *
     * @param faculty
     * save faculty
     */
    @Override
    public void saveFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }
}
