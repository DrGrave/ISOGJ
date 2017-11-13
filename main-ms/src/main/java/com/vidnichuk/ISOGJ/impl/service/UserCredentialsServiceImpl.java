package com.vidnichuk.ISOGJ.impl.service;


import com.vidnichuk.ISOGJ.api.dao.UserCredentialsDAO;
import com.vidnichuk.ISOGJ.api.entity.MyUserCredentials;
import com.vidnichuk.ISOGJ.api.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsServiceImpl implements UserCredentialsService {

    @Autowired
    private UserCredentialsDAO userCredentialsDAO;



    @Override
    public void saveUserCredentials(MyUserCredentials userCredentials) {
        userCredentialsDAO.save(userCredentials);
    }

    @Override
    public MyUserCredentials getCtredById(int id) {
        return userCredentialsDAO.findByIdUserCredential(id);
    }

    @Override
    public MyUserCredentials getUserByLogin(String login) {
        return userCredentialsDAO.findByUserLogin(login);
    }
}
