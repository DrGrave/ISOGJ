package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.entity.City;
import com.vidnichuk.isogj.api.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/City")
public class CityController {
    @Autowired
    private CityService cityService;

    /**
     * request /City/
     * @return
     * all city
     */
    @GetMapping(name = "/")
    public ResponseEntity<List<City>> getAllCity(){
        List<City> cities = cityService.getListOfCitys();
        if (cities != null){
            return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
        }return new ResponseEntity<List<City>>(HttpStatus.NOT_FOUND);
    }
}
