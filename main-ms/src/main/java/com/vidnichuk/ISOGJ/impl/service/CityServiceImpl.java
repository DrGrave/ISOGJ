package com.vidnichuk.ISOGJ.impl.service;

import com.vidnichuk.ISOGJ.api.dao.CityRepository;
import com.vidnichuk.ISOGJ.api.entity.City;
import com.vidnichuk.ISOGJ.api.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implementation of city service
 */
@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private CityRepository cityRepository;

    /**
     *
     * @return
     * list of all city's.
     */
    @Override
    public List<City> getListOfCitys() {
        return cityRepository.findAll();
    }

    /**
     *
     * @param idCity
     * id of city
     * @return
     * city with this id
     */
    @Override
    public City getCityById(int idCity) {
        return cityRepository.findByIdCity(idCity);
    }

    /**
     *
     * @param city
     * save city to DB
     */
    @Override
    public void saveCity(City city) {
        cityRepository.save(city);
    }
}
