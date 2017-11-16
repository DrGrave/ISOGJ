package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to vacancy entity
 */
public interface VacancyRepository extends JpaRepository<Vacancy, Long>{
    /**
     *
     * @param idVacancy
     * id of vacancy
     * @return
     * vacancy with this id
     */
    Vacancy findByIdVacancy(int idVacancy);
}
