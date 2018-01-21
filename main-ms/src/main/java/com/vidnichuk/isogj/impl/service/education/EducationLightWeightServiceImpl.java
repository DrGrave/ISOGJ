package com.vidnichuk.isogj.impl.service.education;

import com.vidnichuk.isogj.api.dto.model.EducationDto;
import com.vidnichuk.isogj.api.dto.model.N_A_EducationDto;
import com.vidnichuk.isogj.api.service.education.EducationLightWeightService;
import com.vidnichuk.isogj.api.service.education.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationLightWeightServiceImpl implements EducationLightWeightService{

    @Autowired
    private EducationService educationService;

    @Override
    public List<EducationDto> getEducationById(Long id) {
        return educationService.findEducationById(id);
    }

    @Override
    public List<N_A_EducationDto> getLastEducationByUserId(long id) {
        return educationService.getLastEducationByUserId(id);
    }
}
