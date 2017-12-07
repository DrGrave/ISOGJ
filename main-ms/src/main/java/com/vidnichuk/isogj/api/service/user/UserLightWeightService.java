package com.vidnichuk.isogj.api.service.user;

import com.vidnichuk.isogj.api.dto.model.TempUserDto;

public interface UserLightWeightService {

    void registerUser(TempUserDto tempUserDto);

    boolean checkUsername(String username);

    boolean checkEmail(String email);

    void approveRegistration(String link);
}
