package com.vidnichuk.isogj.impl.service.user;

import com.vidnichuk.isogj.api.dao.TempUserRepository;
import com.vidnichuk.isogj.api.dao.TypeOfUserRepository;
import com.vidnichuk.isogj.api.dao.UserRepository;
import com.vidnichuk.isogj.api.model.TempUser;
import com.vidnichuk.isogj.api.model.User;
import com.vidnichuk.isogj.api.dto.mapper.TempUserToUserMapper;
import com.vidnichuk.isogj.api.service.user.UserService;
import com.vidnichuk.isogj.impl.service.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TempUserRepository tempUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TypeOfUserRepository typeOfUserRepository;


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private TempUserToUserMapper tempUserToUserMapper;


    private EmailService emailService = new EmailService();

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
        return (userRepository.findByEmail(email) == null && tempUserRepository.findByEmail(email) == null);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void approvedUser(String link) {
        TempUser tempUser = tempUserRepository.findByConfirmLink(link);
        User user = tempUserToUserMapper.tempUserToUser(tempUser);
        user.setTypeOfUser(typeOfUserRepository.findAll().get(0));
        userRepository.save(user);
        tempUserRepository.delete(tempUser);
    }

    @Override
    public void registerUser(TempUser tempUser) {
        tempUser.setPassword(passwordEncoder.encode(tempUser.getPassword()));

        UUID uuid = UUID.randomUUID();
        while (tempUserRepository.findByConfirmLink(uuid.toString()) != null) {
            uuid = UUID.randomUUID();
        }

        tempUser.setConfirmLink(uuid.toString());
        emailService.sendEmail(tempUser);
        tempUserRepository.save(tempUser);
    }
}
