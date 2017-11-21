package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.entity.Company;
import com.vidnichuk.isogj.api.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/Company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    /**
     * request
     * /Company/
     * @return
     * all company
     */
    @GetMapping(name = "/")
    public ResponseEntity<List<Company>> getAllCompany(){
        List<Company> companyList = companyService.getAllCompany();
        if (companyList != null){
            return new ResponseEntity<List<Company>>(companyList, HttpStatus.OK);
        } return new ResponseEntity<List<Company>>(HttpStatus.NOT_FOUND);
    }
}
