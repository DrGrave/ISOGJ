package com.vidnichuk.isogj.impl.service;

import com.vidnichuk.isogj.api.dao.UserCompanyRepository;
import com.vidnichuk.isogj.api.entity.UserCompany;
import com.vidnichuk.isogj.api.service.UserCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implementation of user company service
 */

@Service
public class UserCompanyServiceImpl implements UserCompanyService{
    @Autowired
    private UserCompanyRepository userCompanyRepository;

    /**
     *
     * @return
     * all user company
     */
    @Override
    public List<UserCompany> getAllUserCompany() {
        return userCompanyRepository.findAll();
    }

    /**
     *
     * @param idUserCompany
     * id user company
     * @return
     * user company with this id
     */
    @Override
    public UserCompany getUserCompanyById(int idUserCompany) {
        return userCompanyRepository.findByIdUserCompany(idUserCompany);
    }

    /**
     *
     * @param userCompany
     * save user company
     */
    @Override
    public void saveUserCompany(UserCompany userCompany) {
        userCompanyRepository.save(userCompany);
    }
}
