package com.vidnichuk.ISOGJ.api.dao;

import com.vidnichuk.ISOGJ.api.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by vadim on 16.10.17.
 * repository to store gender of user
 */
public interface GenderRepository extends JpaRepository<Gender, Long>{
    /**
     *
     * @param idGender
     * id to find gender in DB
     * @return
     * object of gender witch have string value of name of gender
     */
    Gender findByIdGender(int idGender);

    /**
     *
     * @return
     * all genders
     */
    List<Gender> findAll();
}
