package com.vidnichuk.isogj.api.service;

import com.vidnichuk.isogj.api.entity.MyUserCredentials;



public interface UserCredentialsService {
    void saveUserCredentials(MyUserCredentials userCredentials);
    MyUserCredentials getCtredById(int id);
    MyUserCredentials getUserByLogin(String login);
}
