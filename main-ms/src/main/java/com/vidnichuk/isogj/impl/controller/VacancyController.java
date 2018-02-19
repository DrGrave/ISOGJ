package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.dto.model.*;

import com.vidnichuk.isogj.api.service.vacancy.VacancyLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/vacancy")
public class VacancyController {
    @Autowired
    private VacancyLightWeightService vacancyLightWeightService;

    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @GetMapping("/all")
    public List<N_A_VacancyDto> getListOfVacancy(){
        return vacancyLightWeightService.getAllVacancy();
    }

    @GetMapping("/authorize/vacancys")
    public List<VacancyDto> getVacancyByCompanyId(@RequestParam("id") long id){
        return vacancyLightWeightService.getVacancyByCompanyId(id);
    }

    @GetMapping("/authorize/task")
    public List<VacancyTaskDto> getTasksByVacancyId(@RequestParam("id") long id){
        return vacancyLightWeightService.getTasksByVacancyId(id);
    }

    @GetMapping("/authorize/user")
    public List<UserDto> getUsersToVacancy(@RequestParam("id") long id) {
        return vacancyLightWeightService.getUsersByCompanyId(id, true ,true);
    }

    @GetMapping("/authorize/nuser")
    public List<UserDto> getNotUsersToVacancy(@RequestParam("id") long id){
        return vacancyLightWeightService.getUsersByCompanyId(id, true, false);
    }

    @GetMapping("/task/skills")
    public List<TaskSkillDto> getSkillsToTask(@RequestParam("id") long id){
        return vacancyLightWeightService.getSkillsToTask(id);
    }
}
