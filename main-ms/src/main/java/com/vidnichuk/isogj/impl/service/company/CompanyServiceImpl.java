package com.vidnichuk.isogj.impl.service.company;

import com.vidnichuk.isogj.api.dao.CompanyRepository;
import com.vidnichuk.isogj.api.dao.PositionRepository;
import com.vidnichuk.isogj.api.dao.UserCompanyRepository;
import com.vidnichuk.isogj.api.dao.UserRepository;
import com.vidnichuk.isogj.api.dto.mapper.CompanyDtoMapper;
import com.vidnichuk.isogj.api.dto.mapper.PositionDtoMapper;
import com.vidnichuk.isogj.api.dto.mapper.UserCompanyDtoMapper;
import com.vidnichuk.isogj.api.dto.model.CompanyDto;
import com.vidnichuk.isogj.api.dto.model.PositionDto;
import com.vidnichuk.isogj.api.dto.model.UserCompanyDto;

import com.vidnichuk.isogj.api.model.Company;
import com.vidnichuk.isogj.api.model.Position;
import com.vidnichuk.isogj.api.model.UserCompany;
import com.vidnichuk.isogj.api.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private UserCompanyRepository userCompanyRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private UserRepository userRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserCompanyDtoMapper userCompanyDtoMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private PositionDtoMapper positionDtoMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CompanyDtoMapper companyDtoMapper;

    @Override
    public List<UserCompanyDto> findCompanyByUserId(long id) {
        List<UserCompanyDto> userCompanyDtos = new ArrayList<>();
        for (UserCompany userCompany: userCompanyRepository.findAllByUserId(id)){
            userCompanyDtos.add(userCompanyDtoMapper.fromUserCompanyToUserCompanyDto(userCompany));
        }
        return userCompanyDtos;
    }

    @Override
    public List<CompanyDto> getCompanysByPartName(String name) {
        List<CompanyDto> companyDtos = new ArrayList<>();
        for (Company company: companyRepository.findAllByNameContains(name)){
            companyDtos.add(companyDtoMapper.fromCompanyToCompanyDto(company));
        }
        return companyDtos;
    }

    @Override
    public List<PositionDto> getPositionsByPartName(String name) {
        List<PositionDto> positionDtos = new ArrayList<>();
        for (Position position : positionRepository.findAllByNameContains(name)){
            positionDtos.add(positionDtoMapper.fromPositionToPositionDto(position));
        }
        return positionDtos;
    }

    @Override
    public List<UserCompanyDto> changeCompany(UserCompanyDto companyDto, Long id) {
        UserCompany userCompany = userCompanyDtoMapper.fromUserCompanyDtoToUserCompany(companyDto);
        userCompany.setUser(userRepository.findById(id));
        userCompanyRepository.save(userCompany);
        List<UserCompanyDto> userCompanyDtos = new ArrayList<>();
        for (UserCompany usCom : userCompanyRepository.findAllByUserId(id)){
            userCompanyDtos.add(userCompanyDtoMapper.fromUserCompanyToUserCompanyDto(usCom));
        }
        return userCompanyDtos;
    }

    @Override
    public List<UserCompanyDto> addCompany(UserCompanyDto companyDto, Long id) {
        List<UserCompanyDto> userCompanyDtos = new ArrayList<>();
        UserCompany userCompany = userCompanyDtoMapper.fromUserCompanyDtoToUserCompany(companyDto);
        userCompany.setUser(userRepository.findById(id));
        userCompanyRepository.save(userCompany);
        for (UserCompany usCom : userCompanyRepository.findAllByUserId(id)){
            userCompanyDtos.add(userCompanyDtoMapper.fromUserCompanyToUserCompanyDto(usCom));
        }
        return userCompanyDtos;
    }

    @Override
    public List<UserCompanyDto> deleteCompany(UserCompanyDto companyDto, Long id) {
        UserCompany userCompany = userCompanyDtoMapper.fromUserCompanyDtoToUserCompany(companyDto);
        userCompany.setUser(userRepository.findById(id));
        userCompanyRepository.delete(userCompany.getIdUserCompany());
        List<UserCompanyDto> userCompanyDtos = new ArrayList<>();
        for (UserCompany usCom : userCompanyRepository.findAllByUserId(id)){
            userCompanyDtos.add(userCompanyDtoMapper.fromUserCompanyToUserCompanyDto(usCom));
        }
        return userCompanyDtos;
    }
}
