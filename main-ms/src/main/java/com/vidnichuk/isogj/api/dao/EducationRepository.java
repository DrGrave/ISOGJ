package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Long> {
    List<Education> findAllByUser_Id(long id);
}
