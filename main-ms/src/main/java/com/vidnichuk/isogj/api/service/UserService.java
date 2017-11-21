package com.vidnichuk.isogj.api.service;

import com.vidnichuk.isogj.api.entity.User;

import java.util.List;

/**
 * Created by vadim on 16.10.17.
 * service to user object
 */
public interface UserService {
    /**
     *
     * @param email
     * get email of user from frontend
     * @return
     * object of user
     */
    User findByEmail(String email);

    /**
     *
     * @param user
     * save user object if not exist in DB
     */
    void saveUser(User user);

    /**
     *
     * @param id
     * id of user
     * @return
     * user with this id
     */
    User findById(Integer id);

    /**
     *
     * @return
     * all users
     */
    List<User> getAllUsers();
}
