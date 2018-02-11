package com.vidnichuk.isogj.api.service.user;

import com.vidnichuk.isogj.api.dto.model.*;

import java.util.List;

public interface UserLightWeightService {

    boolean registerUser(TempUserDto tempUserDto);

    boolean checkUsername(String username);

    boolean checkEmail(String email);

    void approveRegistration(String link);

    List<UserDto> getAllUsers();

    UserDto getUserWithMoreInformation(Long id);

    MeUserDto getUserByUsername(String username);

    GenderDto changeGender(GenderDto gender, long id);

    CityDto changeCity(CityDto cityDto, long id);


}
