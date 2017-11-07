package com.vidnichuk.ISOGJ.api.dao;

import com.vidnichuk.ISOGJ.api.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to vacancy entity
 */
public interface VacancyRepository extends JpaRepository<Vacancy, Long>{
    Vacancy findByIdVacancy(int idVacancy);
}
