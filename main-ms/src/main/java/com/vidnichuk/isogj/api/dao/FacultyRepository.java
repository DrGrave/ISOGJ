package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long>{
    List<Faculty> findAllByNameContainsAndUniversityId(String name, Long id);
    Faculty findByName(String name);
}
