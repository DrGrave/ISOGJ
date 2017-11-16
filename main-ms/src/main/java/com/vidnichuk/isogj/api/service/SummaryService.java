package com.vidnichuk.isogj.api.service;

import com.vidnichuk.isogj.api.entity.Summary;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to summary repository
 */
public interface SummaryService {
    /**
     *
     * @return
     * all of summary
     */
    List<Summary> getAllSummary();

    /**
     *
     * @param idSummary
     * id of summary
     * @return
     * summary with this id
     */
    Summary getByIdSummary(int idSummary);

    /**
     *
     * @param summary
     * save summary
     */
    void saveSummary(Summary summary);
}
