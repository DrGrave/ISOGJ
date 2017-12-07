package com.vidnichuk.isogj.impl.service.user;

import com.vidnichuk.isogj.api.dto.mapper.UserDtoMapper;
import com.vidnichuk.isogj.api.service.UserLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLightWeightServiceImpl implements UserLightWeightService {
    @Autowired
    private UserDtoMapper userDtoMapper;



}
