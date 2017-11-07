package com.vidnichuk.ISOGJ.impl.service;

import com.vidnichuk.ISOGJ.api.dao.CompanyRepository;
import com.vidnichuk.ISOGJ.api.entity.Company;
import com.vidnichuk.ISOGJ.api.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implementation of company service
 */
@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyRepository companyRepository;

    /**
     *
     * @return
     * list of all companys
     */
    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    /**
     *
     * @param idCompany
     * id of company
     * @return
     * company with this id
     */
    @Override
    public Company getCompanyById(int idCompany) {
        return companyRepository.findByIdCompany(idCompany);
    }

    /**
     *
     * @param company
     * save company
     */
    @Override
    public void saveCompany(Company company) {
        companyRepository.save(company);
    }
}
