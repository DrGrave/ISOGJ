package com.vidnichuk.isogj.impl.service;

import com.vidnichuk.isogj.api.dao.GenderRepository;
import com.vidnichuk.isogj.api.entity.Gender;
import com.vidnichuk.isogj.api.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 16.10.2017.
 * implement class to gender service
 */
@Service
public class GenderServiceImpl implements GenderService{
    @Autowired
    GenderRepository genderRepository;

    /**
     *
     * @return
     * return all genders
     */
    @Override
    public List<Gender> getListOfGenders() {
        return genderRepository.findAll();
    }

    /**
     *
     * @param idGender
     * get id of gender
     * @return
     * return gender by id
     */
    @Override
    public Gender getGenderById(int idGender) {
        return genderRepository.findByIdGender(idGender);
    }

    /**
     *
     * @param gender
     * save gender object to DB
     */
    @Override
    public void saveGender(Gender gender) {
        genderRepository.save(gender);
    }
}
