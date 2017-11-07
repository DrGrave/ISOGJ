package com.vidnichuk.ISOGJ.api.dao;

import com.vidnichuk.ISOGJ.api.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to education entity
 */
public interface EducationRepository extends JpaRepository<Education, Long> {
    Education findByIdOfEducation(int idOfEducation);
}
