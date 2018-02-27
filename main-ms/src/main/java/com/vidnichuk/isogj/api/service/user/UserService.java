package com.vidnichuk.isogj.api.service.user;

import com.vidnichuk.isogj.api.dto.model.*;
import com.vidnichuk.isogj.api.model.TempUser;
import com.vidnichuk.isogj.api.model.User;

import java.util.List;

/**
 * Created by vadim on 16.10.17.
 * service to user object
 */
public interface UserService {
    /**
     * @param email get email of user from frontend
     * @return object of user
     */
    User findByEmail(String email);


    /**
     * @param id id of user
     * @return user with this id
     */
    User findById(Long id);

    /**
     * @return all users
     * @param page
     * @param size
     */
    List<UserDto> getAllUsers(int page, int size);


    User findByLogin(String login);


    boolean registerUser(TempUser tempUser);

    boolean checkLogin(String username);

    boolean checkEmail(String email);

    void approveUser(String link);

    UserDto getUserWithMoreInfo(Long id);

    MeUserDto getUserByUsername(String username);

    GenderDto changeGender(GenderDto gender, long id);

    CityDto changeCity(CityDto cityDto, long id);

    long getCountOfPublicUser();
}
