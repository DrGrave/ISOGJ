package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.CompanyDto;
import com.vidnichuk.isogj.api.model.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyDtoMapper {
    CompanyDto fromCompanyToCompanyDto(Company company);
}
