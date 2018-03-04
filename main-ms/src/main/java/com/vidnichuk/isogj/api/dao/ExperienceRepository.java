package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Long>{
    List<Experience> findAllByUser_Id(Long id);
}
