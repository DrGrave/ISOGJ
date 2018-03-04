package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.ExperienceDto;
import com.vidnichuk.isogj.api.model.Experience;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExperienceDtoMapper {
    ExperienceDto fromExperienceToExperienceDtoMapper(Experience experience);
}
