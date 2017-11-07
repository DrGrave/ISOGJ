package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.UserCompany;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to user company repository
 */
public interface UserCompanyService {
    List<UserCompany> getAllUserCompany();
    UserCompany getUserCompanyById(int idUserCompany);
    void saveUserCompany(UserCompany userCompany);
}
