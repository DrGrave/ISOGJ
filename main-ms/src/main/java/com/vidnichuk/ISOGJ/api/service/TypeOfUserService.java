package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.TypeOfUser;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to type of user repository
 */
public interface TypeOfUserService {
    List<TypeOfUser> getAllTypeOfUser();
    TypeOfUser getTypeOfUserById(int idTypeOfUser);
    void saveTypeOfUser(TypeOfUser typeOfUser);
}
