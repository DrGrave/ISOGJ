package com.vidnichuk.isogj.api.service;

import com.vidnichuk.isogj.api.entity.VacancyUser;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to vacancy user repository
 */
public interface VacancyUserService {

    /**
     *
     * @return
     * all vacancy user
     */
    List<VacancyUser> getAllVacancyUser();

    /**
     *
     * @param idVacancyUser
     * id vacancy user
     * @return
     * vacancy user with this id
     */
    VacancyUser getVacancyUserById(int idVacancyUser);

    /**
     *
     * @param vacancyUser
     * save vacancy user
     */
    void saveVacancyUser(VacancyUser vacancyUser);
}
