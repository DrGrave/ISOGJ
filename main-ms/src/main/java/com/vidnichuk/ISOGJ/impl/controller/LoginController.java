package com.vidnichuk.ISOGJ.impl.controller;


import com.vidnichuk.ISOGJ.api.entity.User;
import com.vidnichuk.ISOGJ.api.service.GenderService;
import com.vidnichuk.ISOGJ.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by vadim on 16.10.17.
 * controller to login
 */
@RestController
public class LoginController {
    @Autowired
    private UserService userService;


    /**
     *
     * @return
     * return model to html
     */
    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }




}