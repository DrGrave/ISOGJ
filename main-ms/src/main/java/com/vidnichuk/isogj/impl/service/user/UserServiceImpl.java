package com.vidnichuk.isogj.impl.service.user;

import com.vidnichuk.isogj.api.dao.*;
import com.vidnichuk.isogj.api.dto.mapper.*;
import com.vidnichuk.isogj.api.dto.model.*;
import com.vidnichuk.isogj.api.model.TempUser;
import com.vidnichuk.isogj.api.model.User;
import com.vidnichuk.isogj.api.model.UserLink;
import com.vidnichuk.isogj.api.service.mail.EmailService;
import com.vidnichuk.isogj.api.service.user.UserService;
import com.vidnichuk.isogj.impl.client.AuthServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
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
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user: userRepository.findAll()){
            userDtoList.add(userDtoMapper.fromUserToUserDto(user));
        }
        return userDtoList;
    }

    @Transactional
    @Override
    public void approveUser(String link) {
        TempUser tempUser = tempUserRepository.findByConfirmLink(link);
        User user = tempUserToUserMapper.tempUserToUser(tempUser);
        user.setTypeOfUser(typeOfUserRepository.findAll().get(0));
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
    public UserDto getUserWithMoreInfo(Long id) {
        return userDtoMapper.fromUserToUserDto(userRepository.findById(id));
    }

    @Override
    public MeUserDto getUserByUsername(String username) {
        return userDtoMapper.fromUserToMeUserDto(userRepository.findByUsername(username));
    }

    @Override
    public GenderDto changeGender(GenderDto gender, long id) {
        User user = userRepository.findById(id);
        user.setGender(genderDtoMapper.fromGenderDtoToGender(gender));
        userRepository.save(user);
        return genderDtoMapper.fromGenderToGenderDto(user.getGender());
    }

    @Override
    public CityDto changeCity(CityDto cityDto, long id) {
        User user = userRepository.findById(id);
        user.setCity(cityDtoMapper.fromCityDtoToCity(cityDto));
        userRepository.save(user);
        return cityDtoMapper.fromCityToCityDto(user.getCity());
    }

}
