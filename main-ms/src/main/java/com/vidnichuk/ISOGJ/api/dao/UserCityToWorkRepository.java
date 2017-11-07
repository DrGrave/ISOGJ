package com.vidnichuk.ISOGJ.api.dao;

import com.vidnichuk.ISOGJ.api.entity.UserCityToWork;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to user city to work entity
 */
public interface UserCityToWorkRepository extends JpaRepository<UserCityToWork, Long>{
    UserCityToWork findByIdUserCityToWork(int idCityToWork);
}
