package com.vidnichuk.ISOGJ.impl.service;

import com.vidnichuk.ISOGJ.api.dao.VacancyUserRepository;
import com.vidnichuk.ISOGJ.api.entity.VacancyUser;
import com.vidnichuk.ISOGJ.api.service.VacancyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implementation of vacancy user service
 */

@Service
public class VacancyUserServiceImpl implements VacancyUserService{
    @Autowired
    private VacancyUserRepository vacancyUserRepository;

    @Override
    public List<VacancyUser> getAllVacancyUser() {
        return vacancyUserRepository.findAll();
    }

    @Override
    public VacancyUser getVacancyUserById(int idVacancyUser) {
        return vacancyUserRepository.findByIdVacancyUser(idVacancyUser);
    }

    @Override
    public void saveVacancyUser(VacancyUser vacancyUser) {
        vacancyUserRepository.save(vacancyUser);
    }
}