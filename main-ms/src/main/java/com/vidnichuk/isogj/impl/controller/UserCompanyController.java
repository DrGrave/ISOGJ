package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.entity.UserCompany;
import com.vidnichuk.isogj.api.service.UserCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/UserCompany")
public class UserCompanyController {
    @Autowired
    private UserCompanyService userCompanyService;

    /**
     * request
     * /UserCompany/
     * @return
     * return all UserCompany objects
     */
    @GetMapping("/")
    public ResponseEntity<List<UserCompany>> getAllUserCompany(){
        List<UserCompany> userCompanyList = userCompanyService.getAllUserCompany();
        if (userCompanyList != null){
            return new ResponseEntity<List<UserCompany>>(userCompanyList, HttpStatus.OK);
        } return new ResponseEntity<List<UserCompany>>(HttpStatus.NOT_FOUND);
    }
}
