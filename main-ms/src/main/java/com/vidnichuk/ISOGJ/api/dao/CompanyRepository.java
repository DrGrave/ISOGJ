package com.vidnichuk.ISOGJ.api.dao;

import com.vidnichuk.ISOGJ.api.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Vadim on 07.11.2017.
 * repository to company
 */
public interface CompanyRepository extends JpaRepository<Company, Long>{
    /**
     *
     * @param idOfCompany
     * id of company
     * @return
     * company with this id
     */
    Company findByIdCompany(int idOfCompany);
}
