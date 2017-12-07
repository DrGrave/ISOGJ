package com.vidnichuk.isogj.api.dto.mapper;


import com.vidnichuk.isogj.api.dto.model.VacancyDto;
import com.vidnichuk.isogj.api.model.Vacancy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * mapper to vacancy object
 */
@Mapper(componentModel = "spring")
public interface VacancyDtoMapper {

    @Mapping(source = "typeOfVacancy.name", target = "typeOfVacancy" )
    VacancyDto fromVacancyToVacancyDTO(Vacancy vacancy);


    @Mapping(source = "typeOfVacancy", target = "typeOfVacancy.name")
    Vacancy fromVacancyDtoToVacancy(VacancyDto vacancyDto);

    List<Vacancy> fromListOfVacancyDTOToListOfVacancy(List<VacancyDto> vacancyDtoList);

    List<VacancyDto> fromListOfVacancyToListOfVacancyDTO(List<Vacancy> vacancyList);
}
