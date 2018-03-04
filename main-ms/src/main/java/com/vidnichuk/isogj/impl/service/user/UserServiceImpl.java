package com.vidnichuk.isogj.impl.service.user;

import com.vidnichuk.isogj.api.dao.*;
import com.vidnichuk.isogj.api.dto.mapper.*;
import com.vidnichuk.isogj.api.dto.model.*;
import com.vidnichuk.isogj.api.model.TempUser;
import com.vidnichuk.isogj.api.model.User;
import com.vidnichuk.isogj.api.model.UserLink;
import com.vidnichuk.isogj.api.service.company.CompanyService;
import com.vidnichuk.isogj.api.service.courses.CoursesService;
import com.vidnichuk.isogj.api.service.education.EducationService;
import com.vidnichuk.isogj.api.service.experience.ExperienceService;
import com.vidnichuk.isogj.api.service.history.HistoryService;
import com.vidnichuk.isogj.api.service.link.LinkService;
import com.vidnichuk.isogj.api.service.mail.EmailService;
import com.vidnichuk.isogj.api.service.skill.SkillService;
import com.vidnichuk.isogj.api.service.user.UserService;
import com.vidnichuk.isogj.impl.client.AuthServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.util.Assert.*;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TempUserRepository tempUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TypeOfUserRepository typeOfUserRepository;

    @Autowired
    private AuthServiceClient authServiceClient;

    @Autowired
    private UserLinkRepository userLinkRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private TypeOfLinkRepository typeOfLinkRepository;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private ExperienceService experienceService;

    @Autowired
    private CoursesService coursesService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private TempUserToUserMapper tempUserToUserMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private TempUserDtoMapper tempUserDtoMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserDtoMapper userDtoMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private GenderDtoMapper genderDtoMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CityDtoMapper cityDtoMapper;

    @Autowired
    private EmailService emailService;

    @Autowired
    private LinkService linkService;

    @Autowired
    private SkillService skillService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private EducationService educationService;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByUsername(login);
    }

    @Override
    public boolean checkLogin(String username) {
        return (userRepository.findByUsername(username) == null && tempUserRepository.findByUsername(username) == null);
    }

    @Override
    public boolean checkEmail(String email) {
        return (userRepository.countAllByEmailIgnoreCase(email).equals(0L)
                && tempUserRepository.countAllByEmailIgnoreCase(email).equals(0L));
    }

    @Override
    public long getCountOfPublicUser() {
        return userRepository.count();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserListInfoDto> getAllUsers(int page, int size) {
        List<UserListInfoDto> userListInfoDtos = new ArrayList<>();
        for (User user: userRepository.findAll(createPageRequest(size,page))){
            userListInfoDtos.add(new UserListInfoDto(userDtoMapper.fromUserToUserDto(user), linkService.getUserImgByUid(user.getUid()), skillService.findAllSkillsByUserId(user.getUid()), educationService.getLastEducationByUserId(user.getUid())));
        }
        return userListInfoDtos;
    }

    @Transactional
    @Override
    public void approveUser(String link) {
        TempUser tempUser = tempUserRepository.findByConfirmLink(link);
        User user = tempUserToUserMapper.tempUserToUser(tempUser);
        user.setTypeOfUser(typeOfUserRepository.findAll().get(0));
        UUID uuid = UUID.randomUUID();
        while (userRepository.findByUid(uuid.toString()) != null) {
            uuid = UUID.randomUUID();
        }
        user.setUid(uuid.toString());
        userRepository.save(user);
        UserLink userLink = new UserLink();
        userLink.setUser(user);
        userLink.setLink("http://www.zoofirma.ru/images/stories/2012/05/07/capybara1.jpg");
        userLink.setTypeOfLink(typeOfLinkRepository.findByName("Img"));
        userLinkRepository.save(userLink);
        user.setGender(genderRepository.getOne((long)1));
        user.setCity(cityRepository.findOne((long)1));
        tempUserRepository.delete(tempUser);
        authServiceClient.createUser(tempUserDtoMapper.fromTempUserToAuthUserDto(tempUser));
    }

    @Transactional
    @Override
    public boolean registerUser(TempUser tempUser) {
        String notUniqueUsername = "User with given username already exists.";
        String notUniqueEmail = "User with given email already exists.";

        isNull(userRepository.findByUsername(tempUser.getUsername()), notUniqueUsername);
        isNull(userRepository.findByEmail(tempUser.getEmail()), notUniqueEmail);

        isNull(tempUserRepository.findByUsername(tempUser.getUsername()), notUniqueUsername);
        isNull(tempUserRepository.findByEmail(tempUser.getEmail()), notUniqueEmail);

        tempUser.setPassword(passwordEncoder.encode(tempUser.getPassword()));

        UUID uuid = UUID.randomUUID();
        while (tempUserRepository.findByConfirmLink(uuid.toString()) != null) {
            uuid = UUID.randomUUID();
        }

        tempUser.setConfirmLink(uuid.toString());
        tempUserRepository.save(tempUser);
        emailService.sendConfirmationEmail(tempUser);
        return true;
    }

    @Override
    public UserDto getUserWithMoreInfo(String id) {
        return userDtoMapper.fromUserToUserDto(userRepository.findByUid(id));
    }

    @Override
    public FullUserInfoDto getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        FullUserInfoDto fullUserInfoDto = new FullUserInfoDto();

        fullUserInfoDto.setMeUserDto(userDtoMapper.fromUserToMeUserDto(user));
        fullUserInfoDto.setEducationSkillsDtoList(educationService.getEducationSkills(user.getId()));
        fullUserInfoDto.setUserCompanySkillsDtoList(companyService.getUserCompanyDtoList(user.getId()));
        fullUserInfoDto.setHistorySkillsDtoList(historyService.getAllUserHistory(user.getId(), createPageRequest(10,0)));
        fullUserInfoDto.setExperienceSkillsDtoList(experienceService.getExperienceSkillsById(user.getId()));
        fullUserInfoDto.setCoursesSkillsListDtoList(coursesService.getCoursesByUserId(user.getId()));
        fullUserInfoDto.setUserLinkDtoList(linkService.findAllUserLinks(user.getId()));
        fullUserInfoDto.setUserSkillDtoList(skillService.findAllSkillsByUserId(user.getUid()));
        fullUserInfoDto.setUserLinkDto(linkService.getUserImgByUid(user.getUid()));
        return fullUserInfoDto;
    }

    @Override
    public GenderDto changeGender(GenderDto gender, String id) {
        User user = userRepository.findByUid(id);
        user.setGender(genderDtoMapper.fromGenderDtoToGender(gender));
        userRepository.save(user);
        return genderDtoMapper.fromGenderToGenderDto(user.getGender());
    }

    @Override
    public CityDto changeCity(CityDto cityDto, String id) {
        User user = userRepository.findByUid(id);
        user.setCity(cityDtoMapper.fromCityDtoToCity(cityDto));
        userRepository.save(user);
        return cityDtoMapper.fromCityToCityDto(user.getCity());
    }

    @Override
    public List<HistorySkillsDto> getPageOfHistory(int size, int page, String name) {
        return historyService.getAllUserHistory(userRepository.findByUsername(name).getId(), createPageRequest(size,page));
    }

    private Pageable createPageRequest(int size, int page) {
        return new PageRequest(page, size);
    }

    @Override
    public long getCountOfHistory(String name) {
        return historyService.getCountOfHistory(userRepository.findByUsername(name).getId());
    }
}
