package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.UserCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCompanyRepository extends JpaRepository<UserCompany, Long>{
    List<UserCompany> findAllByUserId(long id);
}
