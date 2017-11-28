package com.vidnichuk.isogj.service;

import com.vidnichuk.isogj.model.User;

public interface UserService {

    /**
     * Getting user by username;
     * @param username to find
     * @return user
     */
    User loadUserByUsername(String username);

    /**
     * Create new user
     * @param user to create
     * @return created user's id
     */
    Long createUser(User user);

}
