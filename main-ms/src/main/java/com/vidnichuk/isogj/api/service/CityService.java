package com.vidnichuk.isogj.api.service;

import com.vidnichuk.isogj.api.entity.City;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to city object
 */
public interface CityService {

    /**
     *
     * @return
     * list of city's
     */
    List<City> getListOfCitys();

    /**
     *
     * @param idCity
     * id of city
     * @return
     * city with this id
     */
    City getCityById(int idCity);

    /**
     *
     * @param city
     * save city in DB
     */
    void saveCity(City city);
}
