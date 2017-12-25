package com.vidnichuk.isogj.api.dto.mapper;


import com.vidnichuk.isogj.api.dto.model.VacancyDto;
import com.vidnichuk.isogj.api.model.Vacancy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * mapper to vacancy object
 */
@Mapper(componentModel = "spring")
public interface VacancyDtoMapper {

    @Mappings({
            @Mapping(source = "typeOfVacancy.name", target = "typeOfVacancy"),
            @Mapping(source = "company.name", target = "companyName")
    })
    VacancyDto fromVacancyToVacancyDTO(Vacancy vacancy);

    @Mappings({
        @Mapping(source = "typeOfVacancy", target = "typeOfVacancy.name"),
        @Mapping(source = "companyName", target = "company.name")
    })
    Vacancy fromVacancyDtoToVacancy(VacancyDto vacancyDto);

    List<Vacancy> fromListOfVacancyDTOToListOfVacancy(List<VacancyDto> vacancyDtoList);

    List<VacancyDto> fromListOfVacancyToListOfVacancyDTO(List<Vacancy> vacancyList);
}
