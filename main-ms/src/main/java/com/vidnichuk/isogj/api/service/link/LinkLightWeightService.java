package com.vidnichuk.isogj.api.service.link;

import com.vidnichuk.isogj.api.dto.model.UserLinkDto;

import java.util.List;

public interface LinkLightWeightService {
    List<UserLinkDto> getLinksToUser(Long id);
}
