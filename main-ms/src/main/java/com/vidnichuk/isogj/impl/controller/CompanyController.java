package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.dto.model.CompanyDto;
import com.vidnichuk.isogj.api.dto.model.PositionDto;
import com.vidnichuk.isogj.api.dto.model.UserCompanyDto;
import com.vidnichuk.isogj.api.service.company.CompanyLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/company")
public class CompanyController {

    @Autowired
    private CompanyLightWeightService companyLightWeightService;

    @GetMapping("/user")
    public List<UserCompanyDto> findEducationByUserId(@RequestParam("id") long id){
        return companyLightWeightService.getUserCompanyByUserId(id);
    }

    @GetMapping("/getname")
    public List<CompanyDto> findCompanysByPartOfName(@RequestParam("name") String name){
        return companyLightWeightService.getCompanysByPartName(name);
    }

    @GetMapping("/position/getname")
    public List<PositionDto> findPositionsByPartOfName(@RequestParam("name") String name){
        return companyLightWeightService.getPositionsByPartName(name);
    }

    @PostMapping("/change")
    public List<UserCompanyDto> changeCompany(@Valid @RequestBody UserCompanyDto companyDto, @RequestParam("id") Long id){
        return companyLightWeightService.changeCompany(companyDto, id);
    }

    @PostMapping("/add")
    public List<UserCompanyDto> addCompany(@Valid @RequestBody UserCompanyDto companyDto, @RequestParam("id") Long id){
        return companyLightWeightService.addCompany(companyDto, id);
    }

    @PostMapping("/delete")
    public List<UserCompanyDto> deleteCompany(@Valid @RequestBody UserCompanyDto companyDto, @RequestParam("id") Long id){
        return companyLightWeightService.deleteCompany(companyDto, id);
    }

}
