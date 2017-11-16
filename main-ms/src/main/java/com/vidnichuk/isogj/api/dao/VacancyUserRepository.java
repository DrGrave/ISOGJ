package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.entity.VacancyUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to vacancy user entity
 */
public interface VacancyUserRepository extends JpaRepository<VacancyUser, Long>{
    /**
     *
     * @param idVacancyUser
     * id vacancy user
     * @return
     * vacancy user with this id
     */
    VacancyUser findByIdVacancyUser(int idVacancyUser);
}
