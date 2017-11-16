package com.vidnichuk.isogj.serviceTest;

import com.vidnichuk.isogj.api.dao.GenderRepository;
import com.vidnichuk.isogj.api.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by vadim on 16.10.17.
 * test to user service
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    GenderRepository genderRepository;

    @Test
    public void saveUser(){
    }
}
