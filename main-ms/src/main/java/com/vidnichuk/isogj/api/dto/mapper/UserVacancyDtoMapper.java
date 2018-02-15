package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.UserVacancyDto;
import com.vidnichuk.isogj.api.model.VacancyUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserVacancyDtoMapper {
    UserVacancyDto fromUserVacancyToUserVacancyDto(VacancyUser vacancyUser);
}
