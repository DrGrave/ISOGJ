package com.vidnichuk.isogj.impl.service.user;

import com.vidnichuk.isogj.api.dao.TempUserRepository;
import com.vidnichuk.isogj.api.dao.TypeOfUserRepository;
import com.vidnichuk.isogj.api.dao.UserRepository;
import com.vidnichuk.isogj.api.dto.mapper.TempUserDtoMapper;
import com.vidnichuk.isogj.api.model.TempUser;
import com.vidnichuk.isogj.api.model.User;
import com.vidnichuk.isogj.api.dto.mapper.TempUserToUserMapper;
import com.vidnichuk.isogj.api.service.mail.EmailService;
import com.vidnichuk.isogj.api.service.user.UserService;
import com.vidnichuk.isogj.impl.client.AuthServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.util.Assert.*;


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


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private TempUserToUserMapper tempUserToUserMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private TempUserDtoMapper tempUserDtoMapper;

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
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void approveUser(String link) {
        TempUser tempUser = tempUserRepository.findByConfirmLink(link);
        User user = tempUserToUserMapper.tempUserToUser(tempUser);
        user.setTypeOfUser(typeOfUserRepository.findAll().get(0));
        userRepository.save(user);
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
}
