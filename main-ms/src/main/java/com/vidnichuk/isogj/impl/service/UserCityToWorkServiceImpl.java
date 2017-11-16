package com.vidnichuk.isogj.impl.service;

import com.vidnichuk.isogj.api.dao.UserCityToWorkRepository;
import com.vidnichuk.isogj.api.entity.UserCityToWork;
import com.vidnichuk.isogj.api.service.UserCityToWorkService;
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

    /**
     *
     * @return
     * all city to work
     */
    @Override
    public List<UserCityToWork> getAllUserCityToWork() {
        return userCityToWorkRepository.findAll();
    }

    /**
     *
     * @param idUserCityToWork
     * id city to work
     * @return
     * user city with this id
     */
    @Override
    public UserCityToWork getUserCityToWorkById(int idUserCityToWork) {
        return userCityToWorkRepository.findByIdUserCityToWork(idUserCityToWork);
    }

    /**
     *
     * @param userCityToWork
     * save user city to work
     */
    @Override
    public void saveUserCityToWork(UserCityToWork userCityToWork) {
        userCityToWorkRepository.save(userCityToWork);
    }
}
