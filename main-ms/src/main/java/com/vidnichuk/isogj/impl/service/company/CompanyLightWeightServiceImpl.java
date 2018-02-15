package com.vidnichuk.isogj.impl.service.company;

import com.vidnichuk.isogj.api.dto.model.*;
import com.vidnichuk.isogj.api.service.company.CompanyLightWeightService;
import com.vidnichuk.isogj.api.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyLightWeightServiceImpl implements CompanyLightWeightService{
    @Autowired
    private CompanyService companyService;

    @Override
    public List<UserCompanyDto> getUserCompanyByUserId(long id) {
        return companyService.findCompanyByUserId(id);
    }

    @Override
    public List<CompanyDto> getCompanysByPartName(String name) {
        return companyService.getCompanysByPartName(name);
    }

    @Override
    public List<PositionDto> getPositionsByPartName(String name) {
        return companyService.getPositionsByPartName(name);
    }

    @Override
    public List<UserCompanyDto> changeCompany(UserCompanyDto companyDto, Long id) {
        return companyService.changeCompany(companyDto, id);
    }

    @Override
    public List<UserCompanyDto> addCompany(UserCompanyDto companyDto, Long id) {
        return companyService.addCompany(companyDto, id);
    }

    @Override
    public List<UserCompanyDto> deleteCompany(UserCompanyDto companyDto, Long id) {
        return companyService.deleteCompany(companyDto,id);
    }

    @Override
    public UserFullCompanyDto getMainCompany(long id) {
        return companyService.getMainCompany(id);
    }

    @Override
    public List<UserDto> getUserToCompany(long id, boolean b) {
        return companyService.getUsersToCompany(id, b);
    }

    @Override
    public List<VacancyDto> getVacancys(long id) {
        return companyService.getVacancysById(id);
    }

    @Override
    public UserCompanyDto getUserPosition(long userId, long companyId) {
        return companyService.getUserPosition(userId, companyId);
    }
}
