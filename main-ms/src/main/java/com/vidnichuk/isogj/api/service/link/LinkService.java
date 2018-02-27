package com.vidnichuk.isogj.api.service.link;

import com.vidnichuk.isogj.api.dto.model.TypeOfLinkDto;
import com.vidnichuk.isogj.api.dto.model.UserLinkDto;

import java.util.List;

public interface LinkService {
    List<UserLinkDto> findAllUserLinks(Long id);
    UserLinkDto getUserImgByUsername(String username);

    List<TypeOfLinkDto> getAllTypesOfLink();

    List<UserLinkDto> changeLink(UserLinkDto userLinkDto, String id);

    List<UserLinkDto> addLink(UserLinkDto userLinkDto, String id);

    UserLinkDto addUserImg(UserLinkDto userLinkDto, String id);

    List<UserLinkDto> deleteLink(UserLinkDto userLinkDto, String id);

    UserLinkDto getUserImgByUid(String uid);
}
