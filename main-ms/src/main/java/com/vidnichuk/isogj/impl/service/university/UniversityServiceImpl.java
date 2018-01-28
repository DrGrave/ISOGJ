package com.vidnichuk.isogj.impl.service.university;


import com.vidnichuk.isogj.api.dao.UniversityRepository;
import com.vidnichuk.isogj.api.dto.mapper.UniversityDtoMapper;
import com.vidnichuk.isogj.api.dto.model.UniversityDto;
import com.vidnichuk.isogj.api.model.University;
import com.vidnichuk.isogj.api.service.University.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService{
    @Autowired
    private UniversityRepository universityRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UniversityDtoMapper universityDtoMapper;

    @Override
    public List<UniversityDto> getUniverstysByPartName(String name) {
        List<University> universities = universityRepository.findAllByNameContains(name);
        List<UniversityDto> universityDtos = new ArrayList<>();
        if (universities.size() > 6){
            universities = universities.subList(0,5);
        }
        for (University university : universities){
            universityDtos.add(universityDtoMapper.fromUniversityToUniversityDto(university));
        }
        return universityDtos;
    }
}
