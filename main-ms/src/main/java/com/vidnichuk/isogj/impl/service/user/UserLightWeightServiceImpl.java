package com.vidnichuk.isogj.impl.service.user;

import com.vidnichuk.isogj.api.dto.model.MeUserDto;
import com.vidnichuk.isogj.api.dto.model.TempUserDto;
import com.vidnichuk.isogj.api.dto.mapper.TempUserDtoMapper;
import com.vidnichuk.isogj.api.dto.model.UserDto;
import com.vidnichuk.isogj.api.service.user.UserLightWeightService;
import com.vidnichuk.isogj.api.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLightWeightServiceImpl implements UserLightWeightService {


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private TempUserDtoMapper tempUserDtoMapper;


    @Autowired
    private UserService userService;


    @Override
    public boolean registerUser(TempUserDto tempUserDto) {
        return userService.registerUser(tempUserDtoMapper.fromTempUserDTOToTempUser(tempUserDto));
    }

    @Override
    public boolean checkUsername(String username) {
        return userService.checkLogin(username);
    }

    @Override
    public boolean checkEmail(String email) {
        return userService.checkEmail(email);
    }

    @Override
    public void approveRegistration(String link) {
        userService.approveUser(link);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public UserDto getUserWithMoreInformation(Long id) {
        return userService.getUserWithMoreInfo(id);
    }

    @Override
    public MeUserDto getUserByUsername(String username) {
        return userService.getUserByUsername(username);
    }
}
