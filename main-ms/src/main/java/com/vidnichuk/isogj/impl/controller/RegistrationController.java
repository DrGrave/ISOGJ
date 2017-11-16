package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.entity.User;
import com.vidnichuk.isogj.api.service.GenderService;
import com.vidnichuk.isogj.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Vadim on 03.11.2017.
 * controller to registration page
 */
@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;
    @Autowired
    private GenderService genderService;

    /**
     *
     * @return
     * return list of genders to html
     */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.addObject("listGender", genderService.getListOfGenders());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    /**
     *
     * @param user
     * get object user from html page
     * @param bindingResult
     * result of binding
     * @return
     * return model to html
     */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findByEmail(user.getUserEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("login");

        }
        return modelAndView;
    }
}
