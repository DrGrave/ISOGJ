package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.entity.Position;
import com.vidnichuk.isogj.api.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/Position")
public class PositionController {
    @Autowired
    private PositionService positionService;

    /**
     * request
     * /Position/
     * @return
     * all positions
     */
    @GetMapping(name = "/")
    public ResponseEntity<List<Position>> getAllPosition(){
        List<Position> positionList = positionService.getAllPosition();
        if (positionList != null){
            return new ResponseEntity<List<Position>>(positionList, HttpStatus.OK);
        } return new ResponseEntity<List<Position>>(HttpStatus.NOT_FOUND);
    }
}
