package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to position
 */
public interface PositionRepository extends JpaRepository<Position, Long>{
    /**
     *
     * @param idPosition
     * id of position
     * @return
     * position with this id
     */
    Position findByIdOfPosition(int idPosition);
}
