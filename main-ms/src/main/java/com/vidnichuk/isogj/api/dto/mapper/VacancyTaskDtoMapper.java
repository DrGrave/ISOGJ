package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.VacancyTaskDto;
import com.vidnichuk.isogj.api.model.VacancyTask;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VacancyTaskDtoMapper {
    VacancyTaskDto fromVacancyTaskToVacancyTaskDto(VacancyTask vacancyTask);
}
