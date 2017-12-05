package com.vidnichuk.isogj.api.service.user;

import com.vidnichuk.isogj.api.dto.TempUserDTO;

public interface UserLightWeightService {

    void registerUser(TempUserDTO tempUserDTO);
}
