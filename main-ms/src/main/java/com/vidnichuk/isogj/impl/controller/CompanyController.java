package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.dto.model.*;
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

    @GetMapping("/vacancy/skills")
    public List<VacancySkillDto> getSkillsToVacancy(@RequestParam("id") long id){
        return companyLightWeightService.getVacancySkills(id);
    }

    @GetMapping("/position/skill/save")
    SkillDto saveSkill(@RequestParam("skillName") String name){
        return companyLightWeightService.saveSkill(name);
    }

    @GetMapping("/user")
    public List<UserCompanyDto> findEducationByUserId(@RequestParam("id") long id){
        return companyLightWeightService.getUserCompanyByUserId(id);
    }

    @GetMapping("/get")
    public List<CompanyDto> findCompanysByPartOfName(@RequestParam("name") String name){
        return companyLightWeightService.getCompanysByPartName(name);
    }

    @GetMapping("/position/get")
    public List<SkillsToPositionDto> findPositionsByPartOfName(@RequestParam("name") String name, @RequestParam("companyId") long companyId){
        return companyLightWeightService.getPositionsByPartName(name, companyId);
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

    @GetMapping("/authorize/maincompany")
    public UserFullCompanyDto getMainCompany(@RequestParam("id") long id){
        return companyLightWeightService.getMainCompany(id);
    }

    @GetMapping("/authorize/users")
    public List<UserDto> getUserToCompany(@RequestParam("id") long id){
        return companyLightWeightService.getUserToCompany(id, true);
    }

    @GetMapping("/authorize/notappusers")
    public List<UserDto> getNotApprovedUsers(@RequestParam("id") long id){
        return companyLightWeightService.getUserToCompany(id, false);
    }

    @GetMapping("/authorize/vacancys")
    public List<VacancyDto> getCompanyVacancy(@RequestParam("id") long id){
        return companyLightWeightService.getVacancys(id);
    }

    @GetMapping("/user/position")
    public UserCompanyDto getPositionByUserAndCompany(@RequestParam("idUser") long userId, @RequestParam("idCompany") long companyId){
        return companyLightWeightService.getUserPosition(userId, companyId);
    }

    @GetMapping("/position/savenew")
    public SkillsToPositionDto saveNewPosition(@RequestParam("positionName") String name){
        return companyLightWeightService.saveNewPosition(name);
    }

    @GetMapping("/savenew")
    public CompanyDto saveNewCompany(@RequestParam("companyName") String name){
        return  companyLightWeightService.saveNewCompany(name);
    }

    @PostMapping("/position/check")
    public  SkillsToPositionDto checkPosition(@Valid @RequestBody SkillsToPositionDto skillsToPositionDto){
        return companyLightWeightService.checkPosition(skillsToPositionDto);
    }

}
