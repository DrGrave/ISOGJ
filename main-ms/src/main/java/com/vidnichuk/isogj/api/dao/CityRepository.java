package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to city entity
 */
public interface CityRepository extends JpaRepository<City, Long> {
    /**
     *
     * @param idCity
     * id of city
     * @return
     * city with this id
     */
    City findByIdCity(int idCity);
}
