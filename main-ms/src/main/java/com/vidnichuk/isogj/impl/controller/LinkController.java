package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.dto.model.UserLinkDto;
import com.vidnichuk.isogj.api.service.link.LinkLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
