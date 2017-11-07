package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.Experience;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to experience repository
 */
public interface ExperienceService {
    /**
     *
     * @return
     * all experience
     */
    List<Experience> getAllExperience();

    /**
     *
     * @param idExperience
     * id of experience
     * @return
     * experience with this id
     */
    Experience getExperienceById(int idExperience);


    /**
     *
     * @param experience
     * save experience
     */
    void saveExperience(Experience experience);

}
