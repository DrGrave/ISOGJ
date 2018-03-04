package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long>{
    List<History> findAllByUser_Id(Long id);
}
