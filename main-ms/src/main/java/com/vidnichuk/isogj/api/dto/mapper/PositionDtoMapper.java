package com.vidnichuk.isogj.api.dto.mapper;


import com.vidnichuk.isogj.api.dto.model.PositionDto;
import com.vidnichuk.isogj.api.model.Position;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PositionDtoMapper {
    PositionDto fromPositionToPositionDto(Position position);
}
