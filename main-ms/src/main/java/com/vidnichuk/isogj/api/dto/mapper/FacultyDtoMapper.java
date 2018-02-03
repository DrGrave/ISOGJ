package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.FacultyDto;
import com.vidnichuk.isogj.api.model.Faculty;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacultyDtoMapper {
    FacultyDto fromFacultyToFacultyDto(Faculty faculty);
    Faculty fromFacultyDtoToFaculty(FacultyDto facultyDto);
}
