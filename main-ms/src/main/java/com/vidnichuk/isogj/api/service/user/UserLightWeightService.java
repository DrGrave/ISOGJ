package com.vidnichuk.isogj.api.service.user;

import com.vidnichuk.isogj.api.dto.model.TempUserDto;
import com.vidnichuk.isogj.api.dto.model.UserDto;

import java.util.List;

public interface UserLightWeightService {

    boolean registerUser(TempUserDto tempUserDto);

    boolean checkUsername(String username);

    boolean checkEmail(String email);

    void approveRegistration(String link);

    List<UserDto> getAllUsers();
}
