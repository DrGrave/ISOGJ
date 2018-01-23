package com.vidnichuk.isogj.impl.service.gender;

import com.vidnichuk.isogj.api.dao.GenderRepository;
import com.vidnichuk.isogj.api.dto.mapper.GenderDtoMapper;
import com.vidnichuk.isogj.api.dto.model.GenderDto;
import com.vidnichuk.isogj.api.model.Gender;
import com.vidnichuk.isogj.api.service.gender.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenderServiceImpl implements GenderService{
    @Autowired
    private GenderRepository genderRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private GenderDtoMapper genderDtoMapper;

    @Override
    public List<GenderDto> getAllGenders() {
        List<GenderDto> genderDtoList = new ArrayList<>();
        for (Gender gender: genderRepository.findAll()){
            genderDtoList.add(genderDtoMapper.fromGenderToGenderDto(gender));
        }
        return genderDtoList;
    }
}
