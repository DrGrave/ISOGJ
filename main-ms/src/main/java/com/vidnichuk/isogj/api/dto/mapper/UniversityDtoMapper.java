package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.UniversityDto;
import com.vidnichuk.isogj.api.model.University;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UniversityDtoMapper {
    UniversityDto fromUniversityToUniversityDto(University university);
}
