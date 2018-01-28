package com.vidnichuk.isogj.impl.service.university;


import com.vidnichuk.isogj.api.dto.model.UniversityDto;
import com.vidnichuk.isogj.api.service.University.UniversityLightWeightService;
import com.vidnichuk.isogj.api.service.University.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityLightWeightServiceImpl implements UniversityLightWeightService{
    @Autowired
    private UniversityService universityService;

    @Override
    public List<UniversityDto> getUniversitysByPartName(String name) {
        return universityService.getUniverstysByPartName(name);
    }
}
