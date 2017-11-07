package com.vidnichuk.ISOGJ.api.dao;

import com.vidnichuk.ISOGJ.api.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to position
 */
public interface PositionRepository extends JpaRepository<Position, Long>{
    Position findByIdOfPosition(int idPosition);
}
