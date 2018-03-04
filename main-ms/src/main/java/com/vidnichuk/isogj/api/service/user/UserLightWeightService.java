package com.vidnichuk.isogj.api.service.user;

import com.vidnichuk.isogj.api.dto.model.*;

import java.util.List;

public interface UserLightWeightService {

    boolean registerUser(TempUserDto tempUserDto);

    boolean checkUsername(String username);

    boolean checkEmail(String email);

    void approveRegistration(String link);

    List<UserListInfoDto> getAllUsers(int page, int size);

    UserDto getUserWithMoreInformation(String id);

    FullUserInfoDto getUserByUsername(String username);

    GenderDto changeGender(GenderDto gender, String id);

    CityDto changeCity(CityDto cityDto, String id);


    long getCountOfPublicUser();

    List<HistorySkillsDto> getPageOfHistory(int size, int page, String name);

    long getCountOfHistory(String name);
}
