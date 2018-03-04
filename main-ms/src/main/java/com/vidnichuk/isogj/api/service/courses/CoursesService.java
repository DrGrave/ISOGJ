package com.vidnichuk.isogj.api.service.courses;

import com.vidnichuk.isogj.api.dto.model.CoursesSkillDto;
import com.vidnichuk.isogj.api.dto.model.CoursesSkillsListDto;

import java.util.List;

public interface CoursesService {
    List<CoursesSkillsListDto> getCoursesByUserId(Long id);

    CoursesSkillsListDto getOneByUserCoursesId(Long id);
}
