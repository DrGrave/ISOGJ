package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UniversityRepository extends JpaRepository<University, Long>{
    List<University> findAllByNameContains(String name);
}
