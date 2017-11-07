package com.vidnichuk.ISOGJ.api.dao;

import com.vidnichuk.ISOGJ.api.entity.TypeOfEducation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository yo type of education
 */
public interface TypeOfEducationRepository extends JpaRepository<TypeOfEducation, Long>{
    TypeOfEducation findByIdTypeOfEducation(int idTypeOfEducation);
}
