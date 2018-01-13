package com.vidnichuk.isogj.impl.service.company;

import com.vidnichuk.isogj.api.dto.model.UserCompanyDto;
import com.vidnichuk.isogj.api.model.UserCompany;
import com.vidnichuk.isogj.api.service.company.CompanyLightWeightService;
import com.vidnichuk.isogj.api.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyLightWeightServiceImpl implements CompanyLightWeightService{
    @Autowired
    private CompanyService companyService;

    @Override
    public UserCompanyDto getUserCompanyByUserId(long id) {
        return companyService.findCompanyByUserId(id);
    }
}
