package com.vidnichuk.ISOGJ.repositoryTest;

import com.vidnichuk.ISOGJ.api.dao.GenderRepository;
import com.vidnichuk.ISOGJ.api.entity.Gender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * Created by vadim on 16.10.17.
 * test to gender repository
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class GenderRepositoryTest {
    @Autowired
    private GenderRepository genderRepository;

    /**
     * try to save gender
     */
    @Test
    public void saveGender(){
        Gender gender = new Gender();
        gender.setNameOfGender("Male");
        genderRepository.save(gender);
    }

    /**
     * try to get gender by id
     */
    @Test
    public void getGenderById(){
        Gender gender1 = new Gender();
        gender1.setNameOfGender("Male");
        genderRepository.save(gender1);
        Gender gender = genderRepository.findByIdGender(1);
        System.out.println(gender);
    }
}
