package com.vidnichuk.ISOGJ.serviceTest;

import com.vidnichuk.ISOGJ.api.entity.City;
import com.vidnichuk.ISOGJ.api.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Vadim on 07.11.2017.
 * city service test
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityServiceTest {
    @Autowired
    private CityService cityService;

    @Test
    public void saveCity(){
        City city = new City();
        city.setNameOfCity("Minsk");
        cityService.saveCity(city);
    }

    @Test
    public void findCityById(){
        cityService.getCityById(cityService.getListOfCitys().get(0).getIdCity()).getNameOfCity();
    }

    @Test
    public void findAllCity(){
        cityService.getListOfCitys().get(0).getNameOfCity();
    }
}
