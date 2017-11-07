package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.Summary;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to summary repository
 */
public interface SummaryService {
    // TODO: 07.11.2017 add java dock 
    List<Summary> getAllSummary();
    Summary getByIdSummary(int idSummary);
    void save(Summary summary);
}
