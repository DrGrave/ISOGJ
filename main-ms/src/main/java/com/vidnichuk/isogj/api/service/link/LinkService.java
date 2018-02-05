package com.vidnichuk.isogj.api.service.link;

import com.vidnichuk.isogj.api.dto.model.TypeOfLinkDto;
import com.vidnichuk.isogj.api.dto.model.UserLinkDto;

import java.util.List;

public interface LinkService {
    List<UserLinkDto> findAllUserLinks(Long id);
    UserLinkDto getUserImgByUserId(long id);

    List<TypeOfLinkDto> getAllTypesOfLink();

    List<UserLinkDto> changeLink(UserLinkDto userLinkDto, long id);

    List<UserLinkDto> addLink(UserLinkDto userLinkDto, long id);

    UserLinkDto addUserImg(UserLinkDto userLinkDto, long id);
}
