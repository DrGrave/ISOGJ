package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.TypeOfUserDto;
import com.vidnichuk.isogj.api.model.type.TypeOfUser;

public interface TypeOfUserDtoMapper {
    TypeOfUserDto fromTypeOfUserToTypeOfUserDto(TypeOfUser typeOfUser);
}
