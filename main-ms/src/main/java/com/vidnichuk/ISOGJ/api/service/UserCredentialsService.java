package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.MyUserCredentials;



public interface UserCredentialsService {
    void saveUserCredentials(MyUserCredentials userCredentials);
    MyUserCredentials getCtredById(int id);
    MyUserCredentials getUserByLogin(String login);
}
