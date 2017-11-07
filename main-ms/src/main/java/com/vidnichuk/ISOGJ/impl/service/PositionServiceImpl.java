package com.vidnichuk.ISOGJ.impl.service;

import com.vidnichuk.ISOGJ.api.dao.PositionRepository;
import com.vidnichuk.ISOGJ.api.entity.Position;
import com.vidnichuk.ISOGJ.api.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implementation of position service
 */
@Service
public class PositionServiceImpl implements PositionService{
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<Position> getAllPosition() {
        return positionRepository.findAll();
    }

    @Override
    public Position getPositionById(int idOfPosition) {
        return positionRepository.findByIdOfPosition(idOfPosition);
    }

    @Override
    public void savePosition(Position position) {
        positionRepository.save(position);
    }
}
