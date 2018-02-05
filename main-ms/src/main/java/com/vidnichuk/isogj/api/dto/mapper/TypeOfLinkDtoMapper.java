package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.TypeOfLinkDto;
import com.vidnichuk.isogj.api.model.type.TypeOfLink;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeOfLinkDtoMapper {
    TypeOfLinkDto fromTypeOfLinkToTypeOfLinkDto(TypeOfLink typeOfLink);
}
