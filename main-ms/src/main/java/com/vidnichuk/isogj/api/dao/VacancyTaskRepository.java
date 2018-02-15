package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.VacancyTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacancyTaskRepository extends JpaRepository<VacancyTask, Long>{
    List<VacancyTask> findAllByVacancyId(long id);
}
