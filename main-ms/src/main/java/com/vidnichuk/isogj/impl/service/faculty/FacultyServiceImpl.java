package com.vidnichuk.isogj.impl.service.faculty;

import com.vidnichuk.isogj.api.dao.FacultyRepository;
import com.vidnichuk.isogj.api.dto.mapper.FacultyDtoMapper;
import com.vidnichuk.isogj.api.dto.model.FacultyDto;
import com.vidnichuk.isogj.api.dto.model.UniversityDto;
import com.vidnichuk.isogj.api.model.Faculty;
import com.vidnichuk.isogj.api.service.faculty.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService{
    @Autowired
    private FacultyRepository facultyRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private FacultyDtoMapper facultyDtoMapper;

    @Override
    public List<FacultyDto> findFacultysByPartNameAndUniversity(String name, UniversityDto universityDto) {
        List<FacultyDto> facultyDtos = new ArrayList<>();
        for (Faculty faculty: facultyRepository.findAllByNameContainsAndUniversityId(name, universityDto.getId())){
            facultyDtos.add(facultyDtoMapper.fromFacultyToFacultyDto(faculty));
        }
        return facultyDtos;
    }
}
