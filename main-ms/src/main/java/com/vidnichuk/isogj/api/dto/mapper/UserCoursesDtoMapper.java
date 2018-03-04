package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.UserCoursesDto;
import com.vidnichuk.isogj.api.model.UserCourses;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserCoursesDtoMapper {
    UserCoursesDto fromUserCoursesToUserCoursesDto(UserCourses userCourses);
}
