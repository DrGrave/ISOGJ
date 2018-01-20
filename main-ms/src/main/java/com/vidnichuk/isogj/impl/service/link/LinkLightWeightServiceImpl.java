package com.vidnichuk.isogj.impl.service.link;

import com.vidnichuk.isogj.api.dto.model.UserLinkDto;
import com.vidnichuk.isogj.api.service.link.LinkLightWeightService;
import com.vidnichuk.isogj.api.service.link.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkLightWeightServiceImpl implements LinkLightWeightService{
    @Autowired
    private LinkService linkService;

    @Override
    public List<UserLinkDto> getLinksToUser(Long id) {
        return linkService.findAllUserLinks(id);
    }

    @Override
    public UserLinkDto getImgToUser(long id) {
        return linkService.getUserImgByUserId(id);
    }
}
