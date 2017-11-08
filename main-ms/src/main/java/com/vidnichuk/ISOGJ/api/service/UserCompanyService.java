package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.UserCompany;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to user company repository
 */
public interface UserCompanyService {

    /**
     *
     * @return
     * all user company
     */
    List<UserCompany> getAllUserCompany();

    /**
     *
     * @param idUserCompany
     * id user company
     * @return
     * user company with this id
     */
    UserCompany getUserCompanyById(int idUserCompany);

    /**
     *
     * @param userCompany
     * save user company
     */
    void saveUserCompany(UserCompany userCompany);
}
