package com.vidnichuk.isogj.impl.service.company;

import com.vidnichuk.isogj.api.dao.*;
import com.vidnichuk.isogj.api.dto.mapper.*;
import com.vidnichuk.isogj.api.dto.model.*;

import com.vidnichuk.isogj.api.model.*;
import com.vidnichuk.isogj.api.service.company.CompanyService;
import com.vidnichuk.isogj.api.service.education.EducationService;
import com.vidnichuk.isogj.api.service.link.LinkService;
import com.vidnichuk.isogj.api.service.skill.SkillService;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{


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
    private SkillRepository skillRepository;

    @Autowired
    private TypeOfSkillRepository typeOfSkillRepository;

    @Autowired
    private CityRepository cityRepository;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LinkService linkService;

    @Autowired
    private EducationService educationService;

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

    @Autowired
    private UserCompanyRepository userCompanyRepository;

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
    public List<UserCompanySkillsDto> deleteCompany(Long id, String name) {
        User user = userRepository.findByUsername(name);
        UserCompany userCompany = userCompanyRepository.findByIdUserCompanyAndUserId(id, user.getId());
        if (userCompany != null){
            userCompanyRepository.delete(userCompany);
            return getUserCompanyDtoList(user.getId());
        } else {
            return getUserCompanyDtoList(user.getId());
        }
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

    @Override
    public SkillDto saveSkill(String name) {
        Skill skill = new Skill();
        skill.setName(name);
        skill.setTypeOfSkill(typeOfSkillRepository.findOne((long)1));
        skillRepository.save(skill);
        return skillDtoMapper.fromSkillToSkillDtoMapper(skill);
    }

    @Override
    public SkillsToPositionDto saveNewPosition(String name) {
        Position position = new Position();
        position.setName(name);
        this.positionRepository.save(position);
        SkillsToPositionDto skillsToPositionDto = new SkillsToPositionDto();
        skillsToPositionDto.setName(name);
        skillsToPositionDto.setSkills(new ArrayList<>());
        skillsToPositionDto.setPosition(positionDtoMapper.fromPositionToPositionDto(position));
        return skillsToPositionDto;
    }

    @Override
    public CompanyDto saveNewCompany(String name) {
        Company company = new Company();
        company.setName(name);
        company.setCityOfCompany(cityRepository.findOne((long)1));
        companyRepository.save(company);
        return companyDtoMapper.fromCompanyToCompanyDto(company);
    }

    @Override
    public SkillsToPositionDto checkPosition(SkillsToPositionDto skillsToPositionDto) {
        for (SkillsToPositionDto pos: getPositionsByPartName(skillsToPositionDto.getName(), 1)){
            if (skillsToPositionDto.getSkills().containsAll(pos.getSkills()) && skillsToPositionDto.getSkills().size() == pos.getSkills().size()){
                return pos;
            } else{
                Position position = new Position();
                position.setName(skillsToPositionDto.getPosition().getName());
                positionRepository.save(position);
                for (SkillDto skillDto: skillsToPositionDto.getSkills()){
                    PositionSkill positionSkill = new PositionSkill();
                    positionSkill.setPosition(position);
                    positionSkill.setSkill(skillDtoMapper.fromSkillDtoToSkillMapper(skillDto));
                    positionSkillRepository.save(positionSkill);
                }
                skillsToPositionDto.setPosition(positionDtoMapper.fromPositionToPositionDto(position));
                List<SkillDto> skillDtos = new ArrayList<>();
                for (PositionSkill skill: positionSkillRepository.findAllByPositionId(position.getId())){
                    skillDtos.add(skillDtoMapper.fromSkillToSkillDtoMapper(skill.getSkill()));
                }
                skillsToPositionDto.setSkills(skillDtos);
                return skillsToPositionDto;
            }
        }
        return null;
    }

    @Override
    public UserCompanySkillsDto saveNewWorkCompany(long idCompany, long idPosition, String name) {
        UserCompany userCompany = new UserCompany();
        userCompany.setUser(userRepository.findByUsername(name));
        userCompany.setCompany(companyRepository.findOne(idCompany));
        userCompany.setPosition(positionRepository.findOne(idPosition));
        userCompany.setChangeApprove(false);
        userCompany.setCompanyApprove(false);
        userCompanyRepository.save(userCompany);
        return new UserCompanySkillsDto(userCompanyDtoMapper.fromUserCompanyToUserCompanyDto(userCompany), skillService.getPositionSkills(userCompany.getPosition().getId()));
    }

    @Override
    public List<UserCompany> getUserCompanyByCompanyId(long id) {
        return userCompanyRepository.findAllByCompanyId(id);
    }

    @Override
    public List<UserListInfoDto> getUsersToCompanyVacancy() {
        List<User> userList = userRepository.findAll();
        List<User> goodUsers = new ArrayList<>();
        for (User user: userList){
            if (userCompanyRepository.findAllByUserId(user.getId()).size() == 0){
                goodUsers.add(user);
            }
        }
        List<UserListInfoDto> userListInfoDtos = new ArrayList<>();
        for (User user: goodUsers){
            userListInfoDtos.add(new UserListInfoDto(userDtoMapper.fromUserToUserDto(user), linkService.getUserImgByUid(user.getUid()), skillService.findAllSkillsByUserId(user.getUid()), educationService.getLastEducationByUserId(user.getUid())));
        }
        return userListInfoDtos;
    }
}
