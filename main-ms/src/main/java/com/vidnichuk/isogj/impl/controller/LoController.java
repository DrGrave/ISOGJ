package com.vidnichuk.isogj.impl.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(path = "/")
public class LoController {


    private String lo = "lol";


    @PreAuthorize("#oauth2.hasScope('server')")
    @RequestMapping(path = "/lol", method = RequestMethod.GET)
    public String lo(OAuth2Authentication principal) {
        return lo;
    }

}
