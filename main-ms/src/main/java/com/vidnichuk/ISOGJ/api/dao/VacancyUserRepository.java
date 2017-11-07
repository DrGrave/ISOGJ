package com.vidnichuk.ISOGJ.api.dao;

import com.vidnichuk.ISOGJ.api.entity.VacancyUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to vacancy user entity
 */
public interface VacancyUserRepository extends JpaRepository<VacancyUser, Long>{
    VacancyUser findByIdVacancyUser(int idVacancyUser);
}
