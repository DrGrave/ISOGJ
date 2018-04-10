package com.vidnichuk.isogj.api.service.company;

import com.vidnichuk.isogj.api.dto.model.*;

import java.util.List;


public interface CompanyService {
    List<UserCompanyDto> findCompanyByUserId(long id);

    List<CompanyDto> getCompanysByPartName(String name);

    List<SkillsToPositionDto> getPositionsByPartName(String name, long companyId);

    List<UserCompanyDto> changeCompany(UserCompanyDto companyDto, Long id);

    List<UserCompanyDto> addCompany(UserCompanyDto companyDto, Long id);

    List<UserCompanySkillsDto> deleteCompany(Long id, String name);

    UserFullCompanyDto getMainCompany(long id);

    List<UserDto> getUsersToCompany(long id, boolean b);

    List<VacancyDto> getVacancysById(long id);

    UserCompanyDto getUserPosition(long userId, long companyId);

    List<VacancySkillDto> getVacancySkills(long id);

    List<UserCompanySkillsDto> getUserCompanyDtoList(long id);

    SkillDto saveSkill(String name);

    SkillsToPositionDto saveNewPosition(String name);

    CompanyDto saveNewCompany(String name);

    SkillsToPositionDto checkPosition(SkillsToPositionDto skillsToPositionDto);

    UserCompanySkillsDto saveNewWorkCompany(long idCompany, long idPosition, String name);
}
