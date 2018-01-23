package com.vidnichuk.isogj.impl.service.gender;

import com.vidnichuk.isogj.api.dto.model.GenderDto;
import com.vidnichuk.isogj.api.service.gender.GenderLightWeightService;
import com.vidnichuk.isogj.api.service.gender.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderLightWeightServiceImpl implements GenderLightWeightService{
    @Autowired
    private GenderService genderService;

    @Override
    public List<GenderDto> getAllGenders() {
        return genderService.getAllGenders();
    }
}
