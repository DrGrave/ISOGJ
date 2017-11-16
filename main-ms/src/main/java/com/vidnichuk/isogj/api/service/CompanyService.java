package com.vidnichuk.isogj.api.service;

import com.vidnichuk.isogj.api.entity.Company;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to company repository
 */
public interface CompanyService {
    /**
     *
     * @return
     * list of all company
     */
    List<Company> getAllCompany();

    /**
     *
     * @param idCompany
     * id of company
     * @return
     * company with this id
     */
    Company getCompanyById(int idCompany);

    /**
     *
     * @param company
     * save company
     */
    void saveCompany(Company company);
}
