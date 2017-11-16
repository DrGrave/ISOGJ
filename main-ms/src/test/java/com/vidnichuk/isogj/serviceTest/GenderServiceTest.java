package com.vidnichuk.isogj.serviceTest;

import com.vidnichuk.isogj.api.entity.Gender;
import com.vidnichuk.isogj.api.service.GenderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Vadim on 03.11.2017.
 * test gender service
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class GenderServiceTest {
    @Autowired
    private GenderService genderService;

    /**
     * try to get all genders from service
     */
    @Test
    public void getAllGenders(){
        Gender gender = new Gender();
        gender.setNameOfGender("Male");
        genderService.saveGender(gender);

        genderService.getListOfGenders().get(0).getNameOfGender();
    }

    /**
     * try to get gender by id
     */
    @Test
    public void getGenderById(){
        Gender gender = new Gender();
        gender.setNameOfGender("Male");
        genderService.saveGender(gender);

        genderService.getGenderById(genderService.getListOfGenders().get(0).getIdGender()).getNameOfGender();
    }
}
