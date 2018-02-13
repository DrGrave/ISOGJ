package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Long>{
    List<Vacancy> findAllByCompanyId(long id);
}
