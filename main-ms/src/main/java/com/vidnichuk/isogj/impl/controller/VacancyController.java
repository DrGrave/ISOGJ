package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.entity.Vacancy;
import com.vidnichuk.isogj.api.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/Vacancy")
public class VacancyController {
    @Autowired
    private VacancyService vacancyService;

    /**
     * request
     * /Vacancy/
      * @return
     * all vacancy
     */
    @GetMapping("/")
    public ResponseEntity<List<Vacancy>> getAllVacancy(){
        List<Vacancy> vacancyList = vacancyService.getAllVacancy();
        if (vacancyList != null){
            return new ResponseEntity<List<Vacancy>>(vacancyList, HttpStatus.OK);
        } return new ResponseEntity<List<Vacancy>>(HttpStatus.NOT_FOUND);
    }
}
