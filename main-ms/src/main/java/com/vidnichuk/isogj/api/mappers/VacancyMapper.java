package com.vidnichuk.isogj.api.mappers;


import com.vidnichuk.isogj.api.dto.VacancyDTO;
import com.vidnichuk.isogj.api.entity.Vacancy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * mapper to vacancy object
 */
@Mapper(componentModel = "spring")
public interface VacancyMapper {

    @Mapping(source = "typeOfVacancy.name", target = "typeOfVacancy" )
    VacancyDTO fromVacancyToVacancyDTO(Vacancy vacancy);


    @Mapping(source = "typeOfVacancy", target = "typeOfVacancy.name")
    Vacancy fromVacancyDtoToVacancy(VacancyDTO vacancyDTO);

    List<Vacancy> fromListOfVacancyDTOToListOfVacancy(List<VacancyDTO> vacancyDTOList);

    List<VacancyDTO> fromListOfVacancyToListOfVacancyDTO(List<Vacancy> vacancyList);
}
