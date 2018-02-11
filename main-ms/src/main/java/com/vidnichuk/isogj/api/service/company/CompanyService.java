package com.vidnichuk.isogj.api.service.company;

import com.vidnichuk.isogj.api.dto.model.CompanyDto;
import com.vidnichuk.isogj.api.dto.model.PositionDto;
import com.vidnichuk.isogj.api.dto.model.UserCompanyDto;
import com.vidnichuk.isogj.api.dto.model.UserFullCompanyDto;

import java.util.List;


public interface CompanyService {
    List<UserCompanyDto> findCompanyByUserId(long id);

    List<CompanyDto> getCompanysByPartName(String name);

    List<PositionDto> getPositionsByPartName(String name);

    List<UserCompanyDto> changeCompany(UserCompanyDto companyDto, Long id);

    List<UserCompanyDto> addCompany(UserCompanyDto companyDto, Long id);

    List<UserCompanyDto> deleteCompany(UserCompanyDto companyDto, Long id);

    UserFullCompanyDto getMainCompany(long id);
}
