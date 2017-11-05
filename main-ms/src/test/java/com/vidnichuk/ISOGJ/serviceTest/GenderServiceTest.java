package com.vidnichuk.ISOGJ.serviceTest;

import com.vidnichuk.ISOGJ.api.service.GenderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Vadim on 03.11.2017.
 * test gender service
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class GenderServiceTest {
    @Autowired
    private GenderService genderService;

    /**
     * try to get all genders from service
     */
    @Test
    public void getAllGenders(){
        genderService.getListOfGenders().get(0).getNameOfGender();
    }

    /**
     * try to get gender by id
     */
    @Test
    public void getGenderById(){
        genderService.getGenderById(genderService.getListOfGenders().get(0).getIdGender()).getNameOfGender();
    }
}
