package com.vidnichuk.ISOGJ.impl.controller;

import com.vidnichuk.ISOGJ.api.entity.User;
import com.vidnichuk.ISOGJ.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Vadim on 03.11.2017.
 * controller to home page
 */
@Controller
public class HomeController {

    @Autowired
    private UserService userService;


    /**
     *
     * @return
     * return model to html page
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(auth.getName());
        modelAndView.addObject("user", user);
        modelAndView.addObject("userGender", user.getGender());
        modelAndView.addObject("role", user.getRoles().toArray()[0]);

        modelAndView.setViewName("home");
        return modelAndView;

    }
}
