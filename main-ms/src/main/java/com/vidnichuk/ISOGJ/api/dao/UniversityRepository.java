package com.vidnichuk.ISOGJ.api.dao;

import com.vidnichuk.ISOGJ.api.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to uni
 */
public interface UniversityRepository extends JpaRepository<University, Long>{
    University findByIdUniversity(int idUniversity);
}
