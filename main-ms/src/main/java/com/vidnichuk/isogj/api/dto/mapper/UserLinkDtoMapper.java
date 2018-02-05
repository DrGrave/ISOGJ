package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.UserLinkDto;
import com.vidnichuk.isogj.api.model.UserLink;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserLinkDtoMapper {
    UserLinkDto fromUserLinkToUserLinkDto(UserLink userLink);
    UserLink fromUserLinkDtoToUserLink(UserLinkDto userLinkDto);
}
