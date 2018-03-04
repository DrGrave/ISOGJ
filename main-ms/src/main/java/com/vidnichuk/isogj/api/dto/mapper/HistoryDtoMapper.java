package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.HistoryDto;
import com.vidnichuk.isogj.api.model.History;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HistoryDtoMapper {
    HistoryDto fromHistoryToHistoryDto(History history);
}
