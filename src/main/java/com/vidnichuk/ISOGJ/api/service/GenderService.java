package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.Gender;

import java.util.List;

/**
 * Created by Vadim on 16.10.2017.
 * service to genders
 */
public interface GenderService {
    /**
     *
     * @return
     * list of all genders
     */
    List<Gender> getListOfGenders();

    /**
     *
     * @param idGender
     * get id of gender
     * @return
     * gender by id
     */
    Gender getGenderById(int idGender);
}
