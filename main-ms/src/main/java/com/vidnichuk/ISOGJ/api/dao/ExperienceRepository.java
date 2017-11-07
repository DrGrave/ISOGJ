package com.vidnichuk.ISOGJ.api.dao;

import com.vidnichuk.ISOGJ.api.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to experience entity
 */
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    Experience findByIdExperience(int idOfExperience);
}
