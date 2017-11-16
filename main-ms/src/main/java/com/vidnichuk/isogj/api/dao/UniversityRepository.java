package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to uni
 */
public interface UniversityRepository extends JpaRepository<University, Long>{
    /**
     *
     * @param idUniversity
     * id of university
     * @return
     * university with this id
     */
    University findByIdUniversity(int idUniversity);
}
