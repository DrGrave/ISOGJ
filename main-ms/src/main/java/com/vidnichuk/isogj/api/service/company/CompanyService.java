package com.vidnichuk.isogj.api.service.company;

import com.vidnichuk.isogj.api.dto.model.UserCompanyDto;

import java.util.List;


public interface CompanyService {
    List<UserCompanyDto> findCompanyByUserId(long id);
}
