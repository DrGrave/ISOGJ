package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.User;

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
    public User findByEmail(String email);

    /**
     *
     * @param user
     * save user object if not exist in DB
     */
    public void saveUser(User user);

    /**
     *
     * @param id
     * id of user
     * @return
     * user with this id
     */
    User findById(Integer id);
}
