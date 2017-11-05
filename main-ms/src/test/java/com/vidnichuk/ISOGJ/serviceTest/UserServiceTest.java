package com.vidnichuk.ISOGJ.serviceTest;

import com.vidnichuk.ISOGJ.api.dao.GenderRepository;
import com.vidnichuk.ISOGJ.api.entity.Gender;
import com.vidnichuk.ISOGJ.api.entity.User;
import com.vidnichuk.ISOGJ.api.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by vadim on 16.10.17.
 * test to user service
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    GenderRepository genderRepository;

    @Test
    public void saveUser(){
        User user = new User();
        user.setUserPassword("ffffff");
        user.setActive(1);
        Gender gender = genderRepository.findByIdGender(1);
        user.setGender(gender);
        user.setUserEmail("vv@gmail.com");
        user.setUserName("Petya");
        user.setUserPatronymic("Petya1");
        user.setUserSurname("Patu1");
        userService.saveUser(user);
    }
}
