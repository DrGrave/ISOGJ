package com.vidnichuk.isogj.api.service.link;

import com.vidnichuk.isogj.api.dto.model.UserLinkDto;

import java.util.List;

public interface LinkService {
    List<UserLinkDto> findAllUserLinks(Long id);
    UserLinkDto getUserImgByUserId(long id);
}
