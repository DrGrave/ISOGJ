package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.UserCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCompanyRepository extends JpaRepository<UserCompany, Long>{
    UserCompany findByUserId(long id);
}
