package com.vidnichuk.ISOGJ.impl.controller;


import com.vidnichuk.ISOGJ.api.entity.User;
import com.vidnichuk.ISOGJ.api.service.GenderService;
import com.vidnichuk.ISOGJ.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

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

    /**
     *
     * @param id
     * get id user
     * @return
     * user with this id
     */
    @GetMapping("/User/{id}")
    public ResponseEntity<User> getSubjectsToProfessor(@PathVariable("id") Integer id){
        User user = userService.findById(id);
        if (user != null){
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }


}