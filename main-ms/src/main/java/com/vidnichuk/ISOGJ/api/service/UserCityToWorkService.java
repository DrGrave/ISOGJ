package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.UserCityToWork;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * user city to work service
 */
public interface UserCityToWorkService {
    List<UserCityToWork> getAllUserCityToWork();
    UserCityToWork getUserCityToWorkById(int idUserCityToWork);
    void saveUserCityToWork(UserCityToWork userCityToWork);
}
