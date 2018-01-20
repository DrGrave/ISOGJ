package com.vidnichuk.isogj.impl.service.link;

import com.vidnichuk.isogj.api.dao.UserLinkRepository;
import com.vidnichuk.isogj.api.dto.mapper.UserLinkDtoMapper;
import com.vidnichuk.isogj.api.dto.model.UserLinkDto;
import com.vidnichuk.isogj.api.model.UserLink;
import com.vidnichuk.isogj.api.service.link.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LinkServiceImpl implements LinkService{

    @Autowired
    private UserLinkRepository userLinkRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserLinkDtoMapper userLinkDtoMapper;

    @Override
    public List<UserLinkDto> findAllUserLinks(Long id) {
        List<UserLinkDto> userLinkDtos = new ArrayList<>();
        for (UserLink userLink : userLinkRepository.findAllByUserId(id)){
            if (userLink.getTypeOfLink().getId() != 1) {
                userLinkDtos.add(userLinkDtoMapper.fromUserLinkToUserLinkDto(userLink));
            }
        }
        return userLinkDtos;
    }

    @Override
    public UserLinkDto getUserImgByUserId(long id) {
        return userLinkDtoMapper.fromUserLinkToUserLinkDto(userLinkRepository.findByUserIdAndTypeOfLinkId(id, 1));
    }
}
