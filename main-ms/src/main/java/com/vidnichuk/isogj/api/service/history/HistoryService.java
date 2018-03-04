package com.vidnichuk.isogj.api.service.history;

import com.vidnichuk.isogj.api.dto.model.HistorySkillsDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HistoryService {
    List<HistorySkillsDto> getAllUserHistory(Long id, Pageable pageable);

    long getCountOfHistory(Long id);
}
