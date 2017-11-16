package com.vidnichuk.isogj.impl.service;

import com.vidnichuk.isogj.api.dao.SummaryRepository;
import com.vidnichuk.isogj.api.entity.Summary;
import com.vidnichuk.isogj.api.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implementation of summary servcie
 */
@Service
public class SummaryServiceImpl implements SummaryService{
    @Autowired
    private SummaryRepository summaryRepository;

    /**
     *
     * @return
     * all summary
     */
    @Override
    public List<Summary> getAllSummary() {
        return summaryRepository.findAll();
    }

    /**
     *
     * @param idSummary
     * id of summary
     * @return
     * summary with this id
     */
    @Override
    public Summary getByIdSummary(int idSummary) {
        return summaryRepository.findByIdOfSummary(idSummary);
    }

    /**
     *
     * @param summary
     * save summary
     */
    @Override
    public void saveSummary(Summary summary) {
        summaryRepository.save(summary);
    }
}
