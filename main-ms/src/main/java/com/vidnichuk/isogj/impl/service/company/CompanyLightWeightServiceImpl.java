package com.vidnichuk.isogj.impl.service.company;

import com.vidnichuk.isogj.api.dto.model.*;
import com.vidnichuk.isogj.api.model.UserCompany;
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
    public List<SkillsToPositionDto> getPositionsByPartName(String name, long companyId) {
        return companyService.getPositionsByPartName(name, companyId);
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
    public List<UserCompanySkillsDto> deleteCompany(Long id, String name) {
        return companyService.deleteCompany(id, name);
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

    @Override
    public List<VacancySkillDto> getVacancySkills(long id) {
        return companyService.getVacancySkills(id);
    }

    @Override
    public SkillDto saveSkill(String name) {
        return companyService.saveSkill(name);
    }

    @Override
    public SkillsToPositionDto saveNewPosition(String name) {
        return companyService.saveNewPosition(name);
    }

    @Override
    public CompanyDto saveNewCompany(String name) {
        return companyService.saveNewCompany(name);
    }

    @Override
    public SkillsToPositionDto checkPosition(SkillsToPositionDto skillsToPositionDto) {
        return companyService.checkPosition(skillsToPositionDto);
    }

    @Override
    public UserCompanySkillsDto saveNewWorkCompany(long idCompany, long idPosition, String name) {
        return companyService.saveNewWorkCompany(idCompany, idPosition, name);
    }

    @Override
    public List<UserCompany> getUserCompanyByCompanyId(long id) {
        return companyService.getUserCompanyByCompanyId(id);
    }

    @Override
    public List<UserListInfoDto> getUsersToCompanyVacancys() {
        return companyService.getUsersToCompanyVacancy();
    }
}
