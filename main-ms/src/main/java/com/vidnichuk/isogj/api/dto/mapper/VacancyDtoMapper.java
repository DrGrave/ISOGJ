package com.vidnichuk.isogj.api.dto.mapper;


import com.vidnichuk.isogj.api.dto.model.N_A_VacancyDto;
import com.vidnichuk.isogj.api.dto.model.TypeOfVacancyDto;
import com.vidnichuk.isogj.api.dto.model.VacancyDto;
import com.vidnichuk.isogj.api.model.Vacancy;
import com.vidnichuk.isogj.api.model.type.TypeOfVacancy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * mapper to vacancy object
 */
@Mapper(componentModel = "spring")
public interface VacancyDtoMapper {

    TypeOfVacancyDto fromTypeOfVacancyToVacancyDto(TypeOfVacancy typeOfVacancy);
    N_A_VacancyDto fromVacancyToVacancyDTO(Vacancy vacancy);
    VacancyDto fromVacancyToVacancyDto(Vacancy vacancy);

}
