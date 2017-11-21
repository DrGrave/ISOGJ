package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.entity.UserCityToWork;
import com.vidnichuk.isogj.api.service.UserCityToWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/UserCity")
public class UserCityController {
    @Autowired
    private UserCityToWorkService userCityToWorkService;

    /**
     * request
     * /UserCity/
     * @return
     * all UserCityToWork objects
     */
    @GetMapping("/")
    public ResponseEntity<List<UserCityToWork>> getAllUserCity(){
        List<UserCityToWork> userCityToWorkList = userCityToWorkService.getAllUserCityToWork();
        if (userCityToWorkList != null){
            return new ResponseEntity<List<UserCityToWork>>(userCityToWorkList, HttpStatus.OK);
        } return new ResponseEntity<List<UserCityToWork>>(HttpStatus.NOT_FOUND);
    }

}
