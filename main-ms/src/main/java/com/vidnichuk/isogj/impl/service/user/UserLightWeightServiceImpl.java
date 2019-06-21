package com.vidnichuk.isogj.impl.service.user;

import com.vidnichuk.isogj.api.dto.model.*;
import com.vidnichuk.isogj.api.dto.mapper.TempUserDtoMapper;
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
    public GenderDto changeGender(Long gender, String username) {
        return userService.changeGender(gender, username);
    }

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
    public List<UserListInfoDto> getAllUsers(int page, int size) {
        return userService.getAllUsers(page, size);
    }

    @Override
    public UserDto getUserWithMoreInformation(String id) {
        return userService.getUserWithMoreInfo(id);
    }

    @Override
    public FullUserInfoDto getUserByUsername(String username) {
        return userService.getUserByUsername(username);
    }

    @Override
    public CityDto changeCity(String cityName, String username) {
        return userService.changeCity(cityName, username);
    }

    @Override
    public long getCountOfPublicUser() {
        return userService.getCountOfPublicUser();
    }

    @Override
    public List<HistorySkillsDto> getPageOfHistory(int size, int page, String name) {
        return userService.getPageOfHistory(size, page, name);
    }

    @Override
    public long getCountOfHistory(String name) {
        return userService.getCountOfHistory(name);
    }

    @Override
    public FullUserInfoDto getUserByUid(String id) {
        return userService.getUserByUid(id);
    }
}
