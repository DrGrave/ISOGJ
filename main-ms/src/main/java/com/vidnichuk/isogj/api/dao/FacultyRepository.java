package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to faculty entity
 */
public interface FacultyRepository extends JpaRepository<Faculty, Long>{
    /**
     *
     * @param idFaculty
     * id of faculty
     * @return
     * faculty with this id
     */
    Faculty findByIdFaculty(int idFaculty);
}
