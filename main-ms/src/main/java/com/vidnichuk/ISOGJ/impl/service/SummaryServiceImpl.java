package com.vidnichuk.ISOGJ.impl.service;

import com.vidnichuk.ISOGJ.api.dao.SummaryRepository;
import com.vidnichuk.ISOGJ.api.entity.Summary;
import com.vidnichuk.ISOGJ.api.service.SummaryService;
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

    @Override
    public List<Summary> getAllSummary() {
        return summaryRepository.findAll();
    }

    @Override
    public Summary getByIdSummary(int idSummary) {
        return summaryRepository.findByIdOfSummary(idSummary);
    }

    @Override
    public void save(Summary summary) {
        summaryRepository.save(summary);
    }
}
