package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to education entity
 */
public interface EducationRepository extends JpaRepository<Education, Long> {
    /**
     *
     * @param idOfEducation
     * id of education
     * @return
     * education with this id
     */
    Education findByIdOfEducation(int idOfEducation);
}
