package com.vidnichuk.ISOGJ.impl.service;

import com.vidnichuk.ISOGJ.api.dao.TypeOfUserRepository;
import com.vidnichuk.ISOGJ.api.entity.TypeOfUser;
import com.vidnichuk.ISOGJ.api.service.TypeOfUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implementation of type of user service
 */

@Service
public class TypeOfUserServiceImpl implements TypeOfUserService{
    @Autowired
    private TypeOfUserRepository typeOfUserRepository;

    /**
     *
     * @return
     * all types of user
     */
    @Override
    public List<TypeOfUser> getAllTypeOfUser() {
        return typeOfUserRepository.findAll();
    }

    /**
     *
     * @param idTypeOfUser
     * id type of user
     * @return
     * type of user with this id
     */
    @Override
    public TypeOfUser getTypeOfUserById(int idTypeOfUser) {
        return typeOfUserRepository.findByIdTypeOfUser(idTypeOfUser);
    }

    /**
     *
     * @param typeOfUser
     * save type of user
     */
    @Override
    public void saveTypeOfUser(TypeOfUser typeOfUser) {
        typeOfUserRepository.save(typeOfUser);
    }
}
