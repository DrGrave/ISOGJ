package com.vidnichuk.isogj.api.dto.mapper;


import com.vidnichuk.isogj.api.dto.model.N_A_VacancyDto;
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
    N_A_VacancyDto fromVacancyToVacancyDTO(Vacancy vacancy);

    @Mappings({
        @Mapping(source = "typeOfVacancy", target = "typeOfVacancy.name"),
        @Mapping(source = "companyName", target = "company.name")
    })
    Vacancy fromVacancyDtoToVacancy(N_A_VacancyDto NAVacancyDto);

    List<Vacancy> fromListOfVacancyDTOToListOfVacancy(List<N_A_VacancyDto> NAVacancyDtoList);

    List<N_A_VacancyDto> fromListOfVacancyToListOfVacancyDTO(List<Vacancy> vacancyList);
}
