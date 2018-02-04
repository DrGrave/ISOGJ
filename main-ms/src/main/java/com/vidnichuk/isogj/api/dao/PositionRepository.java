package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Long>{
    List<Position> findAllByNameContains(String name);
}
