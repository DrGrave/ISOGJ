package com.vidnichuk.ISOGJ.api.dao;

import com.vidnichuk.ISOGJ.api.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to school entity
 */
public interface SchoolRepository extends JpaRepository<School, Long>{
    /**
     *
     * @param idOfSchool
     * id of school
     * @return
     * school with this id
     */
    School findByIdSchool(int idOfSchool);
}
