package com.vidnichuk.isogj.impl.service.link;

import com.vidnichuk.isogj.api.dao.TypeOfLinkRepository;
import com.vidnichuk.isogj.api.dao.UserLinkRepository;
import com.vidnichuk.isogj.api.dao.UserRepository;
import com.vidnichuk.isogj.api.dto.mapper.TypeOfLinkDtoMapper;
import com.vidnichuk.isogj.api.dto.mapper.UserLinkDtoMapper;
import com.vidnichuk.isogj.api.dto.model.TypeOfLinkDto;
import com.vidnichuk.isogj.api.dto.model.UserLinkDto;
import com.vidnichuk.isogj.api.model.UserLink;
import com.vidnichuk.isogj.api.model.type.TypeOfLink;
import com.vidnichuk.isogj.api.service.link.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LinkServiceImpl implements LinkService{

    @Autowired
    private UserLinkRepository userLinkRepository;

    @Autowired
    private TypeOfLinkRepository typeOfLinkRepository;

    @Autowired
    private UserRepository userRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserLinkDtoMapper userLinkDtoMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private TypeOfLinkDtoMapper typeOfLinkDtoMapper;

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
    public UserLinkDto getUserImgByUsername(String username) {
        return userLinkDtoMapper.fromUserLinkToUserLinkDto(userLinkRepository.findByUserIdAndTypeOfLinkId(userRepository.findByUsername(username).getId(), 1));
    }

    @Override
    public List<TypeOfLinkDto> getAllTypesOfLink() {
        List<TypeOfLinkDto> typeOfLinkDtos = new  ArrayList<>();
        for (TypeOfLink typeOfLink : typeOfLinkRepository.findAll()){
            if (typeOfLink.getId() != 1) {
                typeOfLinkDtos.add(typeOfLinkDtoMapper.fromTypeOfLinkToTypeOfLinkDto(typeOfLink));
            }
        }
        return typeOfLinkDtos;
    }

    @Override
    public List<UserLinkDto> changeLink(UserLinkDto userLinkDto, String id) {
        UserLink userLink = userLinkDtoMapper.fromUserLinkDtoToUserLink(userLinkDto);
        userLink.setUser(userRepository.findByUid(id));
        userLinkRepository.save(userLink);
        List<UserLinkDto> userLinkDtos = new ArrayList<>();
        for (UserLink usLink : userLinkRepository.findAllByUserId(userRepository.findByUid(id).getId())){
            if (usLink.getTypeOfLink().getId() != 1) {
                userLinkDtos.add(userLinkDtoMapper.fromUserLinkToUserLinkDto(usLink));
            }
        }
        return userLinkDtos;
    }

    @Override
    public List<UserLinkDto> addLink(UserLinkDto userLinkDto, String id) {
        List<UserLinkDto> userLinkDtos = new ArrayList<>();
        UserLink userLink = userLinkDtoMapper.fromUserLinkDtoToUserLink(userLinkDto);
        userLink.setUser(userRepository.findByUid(id));
        userLinkRepository.save(userLink);
        for (UserLink usLink : userLinkRepository.findAllByUserId(userRepository.findByUid(id).getId())){
            if (usLink.getTypeOfLink().getId() != 1) {
                userLinkDtos.add(userLinkDtoMapper.fromUserLinkToUserLinkDto(usLink));
            }
        }
        return userLinkDtos;
    }

    @Override
    public UserLinkDto addUserImg(UserLinkDto userLinkDto, String id) {
        UserLink us = userLinkRepository.findByUserIdAndTypeOfLinkId(userRepository.findByUid(id).getId(), typeOfLinkRepository.findByName("Img").getId());
        us.setLink(userLinkDtoMapper.fromUserLinkDtoToUserLink(userLinkDto).getLink());
        userLinkRepository.save(us);
        return userLinkDtoMapper.fromUserLinkToUserLinkDto(us);
    }

    @Override
    public List<UserLinkDto> deleteLink(UserLinkDto userLinkDto, String id) {
        UserLink userLink = userLinkDtoMapper.fromUserLinkDtoToUserLink(userLinkDto);
        userLink.setUser(userRepository.findByUid(id));
        userLinkRepository.delete(userLink);
        List<UserLinkDto> userLinkDtos = new ArrayList<>();
        for (UserLink usLink : userLinkRepository.findAllByUserId(userRepository.findByUid(id).getId())){
            if (usLink.getTypeOfLink().getId() != 1) {
                userLinkDtos.add(userLinkDtoMapper.fromUserLinkToUserLinkDto(usLink));
            }
        }
        return userLinkDtos;
    }

    @Override
    public UserLinkDto getUserImgByUid(String uid) {
        return userLinkDtoMapper.fromUserLinkToUserLinkDto(userLinkRepository.findByUserIdAndTypeOfLinkId(userRepository.findByUid(uid).getId(), 1));
    }
}
