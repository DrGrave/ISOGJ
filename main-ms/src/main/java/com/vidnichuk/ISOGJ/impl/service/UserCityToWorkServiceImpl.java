package com.vidnichuk.ISOGJ.impl.service;

import com.vidnichuk.ISOGJ.api.dao.UserCityToWorkRepository;
import com.vidnichuk.ISOGJ.api.entity.UserCityToWork;
import com.vidnichuk.ISOGJ.api.service.UserCityToWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implementation of user city to work service
 */

@Service
public class UserCityToWorkServiceImpl implements UserCityToWorkService{
    @Autowired
    private UserCityToWorkRepository userCityToWorkRepository;

    @Override
    public List<UserCityToWork> getAllUserCityToWork() {
        return userCityToWorkRepository.findAll();
    }

    @Override
    public UserCityToWork getUserCityToWorkById(int idUserCityToWork) {
        return userCityToWorkRepository.findByIdUserCityToWork(idUserCityToWork);
    }

    @Override
    public void saveUserCityToWork(UserCityToWork userCityToWork) {
        userCityToWorkRepository.save(userCityToWork);
    }
}
