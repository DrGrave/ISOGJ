package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.entity.Summary;
import com.vidnichuk.isogj.api.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/Summary")
public class SummaryController {
    @Autowired
    private SummaryService summaryService;

    /**
     * request
     * /Summary/
     * @return
     * all summary
     */
    @GetMapping("/")
    public ResponseEntity<List<Summary>> getAllSummary(){
        List<Summary> summaryList = summaryService.getAllSummary();
        if (summaryList != null){
            return new ResponseEntity<List<Summary>>(summaryList, HttpStatus.OK);
        } return new ResponseEntity<List<Summary>>(HttpStatus.NOT_FOUND);
    }
}
