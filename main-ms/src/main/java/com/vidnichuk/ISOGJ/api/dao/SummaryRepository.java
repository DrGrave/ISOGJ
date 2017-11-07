package com.vidnichuk.ISOGJ.api.dao;

import com.vidnichuk.ISOGJ.api.entity.Summary;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to summary entity
 */
public interface SummaryRepository extends JpaRepository<Summary, Long>{
    Summary findByIdOfSummary(int idOfSummary);
}
