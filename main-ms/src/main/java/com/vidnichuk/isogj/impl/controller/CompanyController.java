package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.dto.model.UserCompanyDto;
import com.vidnichuk.isogj.api.service.company.CompanyLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/company")
public class CompanyController {

    @Autowired
    private CompanyLightWeightService companyLightWeightService;

    @GetMapping("/user")
    public UserCompanyDto findEducationByUserId(@RequestParam("id") long id){
        return companyLightWeightService.getUserCompanyByUserId(id);
    }

}
