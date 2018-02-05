package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.dto.model.TypeOfLinkDto;
import com.vidnichuk.isogj.api.dto.model.UserLinkDto;
import com.vidnichuk.isogj.api.model.UserLink;
import com.vidnichuk.isogj.api.service.link.LinkLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class LinkController {

    @Autowired
    private LinkLightWeightService linkLightWeightService;

    @GetMapping("/links")
    public List<UserLinkDto> findUserLinksByUserId(@RequestParam("id") long id){
        return linkLightWeightService.getLinksToUser(id);
    }

    @GetMapping("/img")
    public UserLinkDto getUserImg(@RequestParam("id") long id){
        return linkLightWeightService.getImgToUser(id);
    }

    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @GetMapping("/userlistimg")
    public UserLinkDto getUserImgToUserList(@RequestParam("id") long id) { return linkLightWeightService.getImgToUser(id); }

    @GetMapping("/links/all")
    public List<TypeOfLinkDto> getAllTypesOfLinks(){
       return linkLightWeightService.getAllTypesOfLink();
    }

    @PostMapping("/links/change")
    public List<UserLinkDto> changeLink(@Valid @RequestBody UserLinkDto userLinkDto, @RequestParam("id") long id){
        return linkLightWeightService.changeLink(userLinkDto, id);
    }

    @PostMapping("/links/add")
    public List<UserLinkDto> addLink(@Valid @RequestBody UserLinkDto userLinkDto, @RequestParam("id") long id){
        return linkLightWeightService.addLink(userLinkDto, id);
    }

    @PostMapping("/links/img/change")
    public UserLinkDto setUserImg(@Valid @RequestBody UserLinkDto userLinkDto, @RequestParam("id") long id){
        return linkLightWeightService.addUserImg(userLinkDto, id);
    }
}
