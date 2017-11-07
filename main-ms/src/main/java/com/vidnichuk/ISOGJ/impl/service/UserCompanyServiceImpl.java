package com.vidnichuk.ISOGJ.impl.service;

import com.vidnichuk.ISOGJ.api.dao.UserCompanyRepository;
import com.vidnichuk.ISOGJ.api.entity.UserCompany;
import com.vidnichuk.ISOGJ.api.service.UserCompanyService;
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

    @Override
    public List<UserCompany> getAllUserCompany() {
        return userCompanyRepository.findAll();
    }

    @Override
    public UserCompany getUserCompanyById(int idUserCompany) {
        return userCompanyRepository.findByIdUserCompany(idUserCompany);
    }

    @Override
    public void saveUserCompany(UserCompany userCompany) {
        userCompanyRepository.save(userCompany);
    }
}
