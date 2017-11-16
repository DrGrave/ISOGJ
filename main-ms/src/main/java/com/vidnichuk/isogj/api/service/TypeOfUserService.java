package com.vidnichuk.isogj.api.service;

import com.vidnichuk.isogj.api.entity.TypeOfUser;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to type of user repository
 */
public interface TypeOfUserService {

    /**
     *
     * @return
     * all types of user
     */
    List<TypeOfUser> getAllTypeOfUser();

    /**
     *
     * @param idTypeOfUser
     * id type of user
     * @return
     * type of user with this id
     */
    TypeOfUser getTypeOfUserById(int idTypeOfUser);

    /**
     *
     * @param typeOfUser
     * save type of user
     */
    void saveTypeOfUser(TypeOfUser typeOfUser);
}
