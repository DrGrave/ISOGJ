package com.vidnichuk.isogj.api.service.faculty;

import com.vidnichuk.isogj.api.dto.model.FacultyDto;
import com.vidnichuk.isogj.api.dto.model.UniversityDto;

import java.util.List;

public interface FacultyService {
    List<FacultyDto> findFacultysByPartNameAndUniversity(String name, UniversityDto universityDto);
}
