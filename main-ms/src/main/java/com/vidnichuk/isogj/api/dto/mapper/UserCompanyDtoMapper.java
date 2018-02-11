package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.UserCompanyDto;
import com.vidnichuk.isogj.api.dto.model.UserFullCompanyDto;
import com.vidnichuk.isogj.api.model.UserCompany;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserCompanyDtoMapper {

    UserCompanyDto fromUserCompanyToUserCompanyDto(UserCompany userCompany);

    UserCompany fromUserCompanyDtoToUserCompany(UserCompanyDto userCompanyDto);

    UserFullCompanyDto fromUserCompanyToUserFullCompanyDto(UserCompany userCompany);
}
