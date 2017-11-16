package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.entity.Summary;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to summary entity
 */
public interface SummaryRepository extends JpaRepository<Summary, Long>{
    /**
     *
     * @param idOfSummary
     * id of summary
     * @return
     * summary with this id
     */
    Summary findByIdOfSummary(int idOfSummary);
}
