package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.EducationDto;
import com.vidnichuk.isogj.api.model.Education;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EducationDtoMapper {

    EducationDto formEducationToEducationDto(Education education);
}
