package com.vidnichuk.ISOGJ.api.dao;

import com.vidnichuk.ISOGJ.api.entity.TypeOfVacancy;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to type of vacancy
 */
public interface TypeOfVacancyRepository extends JpaRepository<TypeOfVacancy, Long>{
    /**
     *
     * @param idTypeOfVacancy
     * id of type of vacancy
     * @return
     * type of vacancy with this id
     */
    TypeOfVacancy findByIdTypeOfVacancy(int idTypeOfVacancy);
}