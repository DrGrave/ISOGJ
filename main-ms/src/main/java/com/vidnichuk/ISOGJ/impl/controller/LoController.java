package com.vidnichuk.ISOGJ.impl.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
@RefreshScope
public class LoController {


    @Value("${ololo.lo}")
    private String lo;


    @RequestMapping(path = "/lo", method = RequestMethod.GET)
    public String lo() {
        return lo;
    }

}
