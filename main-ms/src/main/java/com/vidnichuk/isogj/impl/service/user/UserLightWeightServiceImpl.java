package com.vidnichuk.isogj.impl.service.user;

import com.vidnichuk.isogj.api.dto.TempUserDTO;
import com.vidnichuk.isogj.api.mappers.TempUserMapper;
import com.vidnichuk.isogj.api.service.user.UserLightWeightService;
import com.vidnichuk.isogj.api.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLightWeightServiceImpl implements UserLightWeightService {


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private TempUserMapper tempUserMapper;

    @Autowired
    private UserService userService;

    @Override
    public void registerUser(TempUserDTO tempUserDTO) {
        userService.registerUser(tempUserMapper.fromTempUserDTOToTempUser(tempUserDTO));
    }
}
