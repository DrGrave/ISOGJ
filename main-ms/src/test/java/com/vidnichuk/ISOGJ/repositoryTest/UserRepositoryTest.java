package com.vidnichuk.ISOGJ.repositoryTest;

import com.vidnichuk.ISOGJ.api.dao.GenderRepository;
import com.vidnichuk.ISOGJ.api.dao.UserRepository;
import com.vidnichuk.ISOGJ.api.entity.Gender;
import com.vidnichuk.ISOGJ.api.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * Created by vadim on 16.10.17.
 * user repository test
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    GenderRepository genderRepository;

    @Test
    public void saveUser(){
        User user = new User();
        user.setActive(1);
        Gender gender = genderRepository.findByIdGender(1);
        user.setGender(gender);
        user.setUserEmail("vv@gmail.com");
        user.setUserName("Petya");
        user.setUserPatronymic("Petya1");
        user.setUserSurname("Patu1");
        userRepository.save(user);
    }

    @Test
    public void getUserByEmail(){
        User user = userRepository.findAll().get(0);
        System.out.println(user);
    }
}
