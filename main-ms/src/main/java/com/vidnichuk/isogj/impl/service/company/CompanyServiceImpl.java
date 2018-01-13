package com.vidnichuk.isogj.impl.service.company;

import com.vidnichuk.isogj.api.dao.UserCompanyRepository;
import com.vidnichuk.isogj.api.dto.mapper.CompanyDtoMapper;
import com.vidnichuk.isogj.api.dto.mapper.UserCompanyDtoMapper;
import com.vidnichuk.isogj.api.dto.model.UserCompanyDto;

import com.vidnichuk.isogj.api.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    UserCompanyRepository userCompanyRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserCompanyDtoMapper userCompanyDtoMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CompanyDtoMapper companyDtoMapper;

    @Override
    public UserCompanyDto findCompanyByUserId(long id) {
        return userCompanyDtoMapper.fromUserCompanyToUserCompanyDto(userCompanyRepository.findByUserId(id));
    }
}
