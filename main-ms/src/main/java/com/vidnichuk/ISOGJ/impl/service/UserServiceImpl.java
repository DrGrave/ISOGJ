package com.vidnichuk.ISOGJ.impl.service;

import com.vidnichuk.ISOGJ.api.dao.UserRepository;
import com.vidnichuk.ISOGJ.api.entity.User;
import com.vidnichuk.ISOGJ.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;

/**
 * Created by vadim on 16.10.17.
 * implementation of user Service
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;



    @Autowired
    private
    ShaPasswordEncoder shaPasswordEncoder;

    /**
     *
     * @param email
     * get email of user from frontend
     * @return
     * object of user
     */
    @Override
    public User findByEmail(String email) {
        return userRepository.findByUserEmail(email);
    }

    /**
     *
     * @param user
     * save user object
     */
    @Override
    public void saveUser(User user) {
        user.setActive(1);
        userRepository.save(user);
    }

    /**
     *
     * @param id
     * id user
     * @return
     * user with this id
     */
    @Override
    public User findById(Integer id) {
        return userRepository.findByUserId(id);
    }
}
