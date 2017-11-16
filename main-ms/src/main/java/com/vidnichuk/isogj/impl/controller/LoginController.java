package com.vidnichuk.isogj.impl.controller;


import com.vidnichuk.isogj.api.entity.User;
import com.vidnichuk.isogj.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



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
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id){
        User user = userService.findById(id);
        if (user != null){
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }


}