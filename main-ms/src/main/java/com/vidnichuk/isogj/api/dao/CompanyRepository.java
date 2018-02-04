package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long>{
    List<Company> findAllByNameContains(String name);
}
