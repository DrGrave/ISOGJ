package com.vidnichuk.isogj.impl.service.link;

import com.vidnichuk.isogj.api.dto.model.TypeOfLinkDto;
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
    public UserLinkDto getImgToUser(String uid) {
        return linkService.getUserImgByUsername(uid);
    }

    @Override
    public List<TypeOfLinkDto> getAllTypesOfLink() {
        return linkService.getAllTypesOfLink();
    }

    @Override
    public List<UserLinkDto> changeLink(UserLinkDto userLinkDto, String id) {
        return linkService.changeLink(userLinkDto, id);
    }

    @Override
    public List<UserLinkDto> addLink(UserLinkDto userLinkDto, String id) {
        return linkService.addLink(userLinkDto, id);
    }

    @Override
    public UserLinkDto addUserImg(UserLinkDto userLinkDto, String id) {
        return linkService.addUserImg(userLinkDto, id);
    }

    @Override
    public List<UserLinkDto> deleteLink(UserLinkDto userLinkDto, String id) {
        return linkService.deleteLink(userLinkDto, id);
    }

    @Override
    public UserLinkDto getImgToUserList(String uid) {
        return linkService.getUserImgByUid(uid);
    }
}
