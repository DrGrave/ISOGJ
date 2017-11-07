package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.VacancyUser;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to vacancy user repository
 */
public interface VacancyUserService {
    List<VacancyUser> getAllVacancyUser();
    VacancyUser getVacancyUserById(int idVacancyUser);
    void saveVacancyUser(VacancyUser vacancyUser);
}
