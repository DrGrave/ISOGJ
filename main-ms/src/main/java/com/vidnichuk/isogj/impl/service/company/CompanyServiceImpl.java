package com.vidnichuk.isogj.impl.service.company;

import com.vidnichuk.isogj.api.dao.*;
import com.vidnichuk.isogj.api.dto.mapper.*;
import com.vidnichuk.isogj.api.dto.model.*;

import com.vidnichuk.isogj.api.model.*;
import com.vidnichuk.isogj.api.service.company.CompanyService;
import com.vidnichuk.isogj.api.service.skill.SkillService;
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
    private VacancySkillRepository vacancySkillRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private SkillService skillService;

    @Autowired
    private PositionSkillRepository positionSkillRepository;


    @Autowired
    private UserRepository userRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserCompanyDtoMapper userCompanyDtoMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private VacancySkillDtoMapper vacancySkillDtoMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserDtoMapper userDtoMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private PositionDtoMapper positionDtoMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CompanyDtoMapper companyDtoMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private SkillDtoMapper skillDtoMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private VacancyDtoMapper vacancyDtoMapper;

    @Autowired
    private VacancyRepository vacancyRepository;

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
    public List<SkillsToPositionDto> getPositionsByPartName(String name, long companyId) {
        List<PositionDto> positionDtos = new ArrayList<>();
        for (Position position : positionRepository.findAllByNameContains(name)){
            positionDtos.add(positionDtoMapper.fromPositionToPositionDto(position));
        }
        List<SkillsToPositionDto> skillsToPositionDtoList = new ArrayList<>();
        for (PositionDto position: positionDtos){
            SkillsToPositionDto skillsToPositionDto = new SkillsToPositionDto();
            skillsToPositionDto.setPosition(position);
            skillsToPositionDto.setName(position.getName());
            List<SkillDto> skills = new ArrayList<>();
            for (PositionSkill positionSkill: positionSkillRepository.findAllByPositionId(position.getId())){
                skills.add(skillDtoMapper.fromSkillToSkillDtoMapper(positionSkill.getSkill()));
            }
            skillsToPositionDto.setSkills(skills);
            skillsToPositionDtoList.add(skillsToPositionDto);
        }
        return skillsToPositionDtoList;
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

    @Override
    public UserFullCompanyDto getMainCompany(long id) {
        return userCompanyDtoMapper.fromUserCompanyToUserFullCompanyDto(userCompanyRepository.findByUserIdAndCompanyApprove(id, true));
    }

    @Override
    public List<UserDto> getUsersToCompany(long id, boolean b) {
        List<UserDto> userCompanyDtoList = new ArrayList<>();
        for (UserCompany userCompany : userCompanyRepository.findAllByCompanyIdAndCompanyApprove(id, b)){
            userCompanyDtoList.add(userDtoMapper.fromUserToUserDto(userCompany.getUser()));
        }
        return userCompanyDtoList;
    }

    @Override
    public List<VacancyDto> getVacancysById(long id) {
        List<VacancyDto> vacancyDtoList = new ArrayList<>();
        for (Vacancy vacancy: vacancyRepository.findAllByCompanyId(id)){
            vacancyDtoList.add(vacancyDtoMapper.fromVacancyToVacancyDto(vacancy));
        }
        return vacancyDtoList;
    }

    @Override
    public UserCompanyDto getUserPosition(long userId, long companyId) {
        return userCompanyDtoMapper.fromUserCompanyToUserCompanyDto(userCompanyRepository.findByUserIdAndCompanyId(userId, companyId));
    }

    @Override
    public List<VacancySkillDto> getVacancySkills(long id) {
        List<VacancySkillDto> vacancySkillDtos = new ArrayList<>();
        for (VacancySkill vacancySkill: vacancySkillRepository.findAllByVacancy_Id(id)){
            vacancySkillDtos.add(vacancySkillDtoMapper.fromVacancySkillToVacancySkillDto(vacancySkill));
        }
        return vacancySkillDtos;
    }

    @Override
    public List<UserCompanySkillsDto> getUserCompanyDtoList(long id) {
        List<UserCompanySkillsDto> userCompanySkillsDtoList = new ArrayList<>();
        for (UserCompany userCompany: userCompanyRepository.findAllByUserId(id)){
            userCompanySkillsDtoList.add(new UserCompanySkillsDto(userCompanyDtoMapper.fromUserCompanyToUserCompanyDto(userCompany), skillService.getPositionSkills(userCompany.getPosition().getId())));
        }
        return userCompanySkillsDtoList;
    }
}
