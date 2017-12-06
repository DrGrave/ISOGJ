package com.vidnichuk.isogj.api.service.user;

import com.vidnichuk.isogj.api.dto.TempUserDTO;
import com.vidnichuk.isogj.api.entity.TempUser;

public interface UserLightWeightService {

    void registerUser(TempUserDTO tempUserDTO);

    TempUser findByLogin(String username);

    TempUser findByEmail(String email);
}
