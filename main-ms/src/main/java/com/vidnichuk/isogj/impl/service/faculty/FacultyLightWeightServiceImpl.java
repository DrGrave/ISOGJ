package com.vidnichuk.isogj.impl.service.faculty;

import com.vidnichuk.isogj.api.dto.model.FacultyDto;
import com.vidnichuk.isogj.api.dto.model.UniversityDto;
import com.vidnichuk.isogj.api.service.faculty.FacultyLightWeightService;
import com.vidnichuk.isogj.api.service.faculty.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyLightWeightServiceImpl implements FacultyLightWeightService{

    @Autowired
    private FacultyService facultyService;

    @Override
    public List<FacultyDto> findFacultysByPartNameAndUniversity(String name, UniversityDto universityDto) {
        return facultyService.findFacultysByPartNameAndUniversity(name, universityDto);
    }
}
