package com.vidnichuk.isogj.impl.service;

import com.vidnichuk.isogj.api.dao.ExperienceRepository;
import com.vidnichuk.isogj.api.entity.Experience;
import com.vidnichuk.isogj.api.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implements of experience service
 */
@Service
public class ExperienceServiceImpl implements ExperienceService{

    @Autowired
    private ExperienceRepository experienceRepository;

    /**
     *
     * @return
     * list of all experience
     */
    @Override
    public List<Experience> getAllExperience() {
        return experienceRepository.findAll();
    }

    /**
     *
     * @param idExperience
     * id of experience
     * @return
     * experience with this id
     */
    @Override
    public Experience getExperienceById(int idExperience) {
        return experienceRepository.findByIdExperience(idExperience);
    }

    /**
     *
     * @param experience
     * save experience
     */
    @Override
    public void saveExperience(Experience experience) {
        experienceRepository.save(experience);
    }
}
