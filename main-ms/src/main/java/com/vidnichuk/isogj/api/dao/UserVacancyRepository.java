package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.VacancyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserVacancyRepository extends JpaRepository<VacancyUser, Long>{
    List<VacancyUser> findAllByVacancyIdAndIfAcceptedUserAndIfCompanyAccepted(long id, boolean us, boolean comp);
}
