package com.vidnichuk.isogj.impl.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(path = "/")
public class LoController {


    private String lo = "lol";


    @RequestMapping(path = "/lol", method = RequestMethod.GET)
    public String lo(Principal principal) {
        return lo;
    }

}
