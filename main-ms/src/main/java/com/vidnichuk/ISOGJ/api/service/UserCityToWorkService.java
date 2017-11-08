package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.UserCityToWork;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * user city to work service
 */
public interface UserCityToWorkService {

    /**
     *
     * @return
     * all city to work
     */
    List<UserCityToWork> getAllUserCityToWork();

    /**
     *
     * @param idUserCityToWork
     * id city to work
     * @return
     * city to work with this id
     */
    UserCityToWork getUserCityToWorkById(int idUserCityToWork);

    /**
     *
     * @param userCityToWork
     * save city to work
     */
    void saveUserCityToWork(UserCityToWork userCityToWork);
}
