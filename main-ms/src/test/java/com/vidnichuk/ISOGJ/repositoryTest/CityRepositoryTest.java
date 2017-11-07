package com.vidnichuk.ISOGJ.repositoryTest;

import com.vidnichuk.ISOGJ.api.dao.CityRepository;
import com.vidnichuk.ISOGJ.api.entity.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * Created by Vadim on 07.11.2017.
 * test of city repository
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CityRepositoryTest {
    @Autowired
    private CityRepository cityRepository;

    /**
     * try to save city
     */
    @Test
    public void saveCity(){
        City city = new City();
        city.setNameOfCity("Minsk");
        cityRepository.save(city);
    }

    /**
     * try to find city
     */
    @Test
    public void findCity(){
        City city = new City();
        city.setNameOfCity("Minsk");
        cityRepository.save(city);
        cityRepository.findByIdCity(cityRepository.findAll().get(0).getIdCity()).getNameOfCity();
    }
}
