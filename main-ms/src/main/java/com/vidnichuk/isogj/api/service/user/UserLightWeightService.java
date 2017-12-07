package com.vidnichuk.isogj.api.service.user;

import com.vidnichuk.isogj.api.dto.TempUserDTO;
import com.vidnichuk.isogj.api.entity.TempUser;

public interface UserLightWeightService {

    void registerUser(TempUserDTO tempUserDTO);

    boolean checkUsername(String username);

    boolean checkEmail(String email);

    void approveRegistration(String link);
}
