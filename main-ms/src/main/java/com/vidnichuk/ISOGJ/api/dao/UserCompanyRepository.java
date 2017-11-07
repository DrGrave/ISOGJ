package com.vidnichuk.ISOGJ.api.dao;

import com.vidnichuk.ISOGJ.api.entity.UserCompany;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to user company entity
 */
public interface UserCompanyRepository extends JpaRepository<UserCompany, Long>{
    /**
     *
     * @param idUserCompany
     * id of user company
     * @return
     * user company with this id
     */
    UserCompany findByIdUserCompany(int idUserCompany);
}