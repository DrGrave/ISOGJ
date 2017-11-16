package com.vidnichuk.isogj.api.service;

import com.vidnichuk.isogj.api.entity.Position;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to position repository
 */
public interface PositionService {
    /**
     *
     * @return
     * all positions
     */
    List<Position> getAllPosition();

    /**
     *
     * @param idOfPosition
     * id of position
     * @return
     * position with this id
     */
    Position getPositionById(int idOfPosition);

    /**
     *
     * @param position
     * save position
     */
    void savePosition(Position position);
}
