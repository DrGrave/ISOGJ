package com.vidnichuk.isogj.api.service.company;

import com.vidnichuk.isogj.api.dto.model.UserCompanyDto;


public interface CompanyService {
    UserCompanyDto findCompanyByUserId(long id);
}
