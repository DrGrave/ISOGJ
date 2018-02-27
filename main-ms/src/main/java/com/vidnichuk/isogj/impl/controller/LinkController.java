package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.dto.model.TypeOfLinkDto;
import com.vidnichuk.isogj.api.dto.model.UserLinkDto;
import com.vidnichuk.isogj.api.model.UserLink;
import com.vidnichuk.isogj.api.service.link.LinkLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
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
    public UserLinkDto getUserImg(Principal principal){
        return linkLightWeightService.getImgToUser(principal.getName());
    }

    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @GetMapping("/userlistimg")
    public UserLinkDto getUserImgToUserList(@RequestParam("id") String uid) { return linkLightWeightService.getImgToUserList(uid); }

    @GetMapping("/links/all")
    public List<TypeOfLinkDto> getAllTypesOfLinks(){
       return linkLightWeightService.getAllTypesOfLink();
    }

    @PostMapping("/links/change")
    public List<UserLinkDto> changeLink(@Valid @RequestBody UserLinkDto userLinkDto, @RequestParam("id") String id){
        return linkLightWeightService.changeLink(userLinkDto, id);
    }

    @PostMapping("/links/add")
    public List<UserLinkDto> addLink(@Valid @RequestBody UserLinkDto userLinkDto, @RequestParam("id") String id){
        return linkLightWeightService.addLink(userLinkDto, id);
    }

    @PostMapping("/links/img/change")
    public UserLinkDto setUserImg(@Valid @RequestBody UserLinkDto userLinkDto, @RequestParam("id") String id){
        return linkLightWeightService.addUserImg(userLinkDto, id);
    }

    @PostMapping("links/delete")
    public List<UserLinkDto> deleteLink(@Valid @RequestBody UserLinkDto userLinkDto, @RequestParam("id") String id){
        return linkLightWeightService.deleteLink(userLinkDto, id);
    }
}
