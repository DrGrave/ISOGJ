package com.vidnichuk.isogj.impl.service;

import com.vidnichuk.isogj.api.dao.VacancyUserRepository;
import com.vidnichuk.isogj.api.entity.VacancyUser;
import com.vidnichuk.isogj.api.service.VacancyUserService;
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

    /**
     *
     * @return
     * all vacancy user
     */
    @Override
    public List<VacancyUser> getAllVacancyUser() {
        return vacancyUserRepository.findAll();
    }

    /**
     *
     * @param idVacancyUser
     * id vacancy user
     * @return
     * vacancy user with this id
     */
    @Override
    public VacancyUser getVacancyUserById(int idVacancyUser) {
        return vacancyUserRepository.findByIdVacancyUser(idVacancyUser);
    }

    /**
     *
     * @param vacancyUser
     * save vacancy user
     */
    @Override
    public void saveVacancyUser(VacancyUser vacancyUser) {
        vacancyUserRepository.save(vacancyUser);
    }
}
