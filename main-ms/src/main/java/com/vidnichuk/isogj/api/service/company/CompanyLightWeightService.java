package com.vidnichuk.isogj.api.service.company;


import com.vidnichuk.isogj.api.dto.model.*;

import java.util.List;


public interface CompanyLightWeightService {
    List<UserCompanyDto> getUserCompanyByUserId(long id);

    List<CompanyDto> getCompanysByPartName(String name);

    List<SkillsToPositionDto> getPositionsByPartName(String name, long companyId);

    List<UserCompanyDto> changeCompany(UserCompanyDto companyDto, Long id);

    List<UserCompanyDto> addCompany(UserCompanyDto companyDto, Long id);

    List<UserCompanyDto> deleteCompany(UserCompanyDto companyDto, Long id);

    UserFullCompanyDto getMainCompany(long id);

    List<UserDto> getUserToCompany(long id, boolean b);

    List<VacancyDto> getVacancys(long id);

    UserCompanyDto getUserPosition(long userId, long companyId);

    List<VacancySkillDto> getVacancySkills(long id);

    SkillDto saveSkill(String name);
}
