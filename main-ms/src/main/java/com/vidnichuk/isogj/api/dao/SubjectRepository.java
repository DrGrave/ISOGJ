package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findAllByDepartmentId(long id);
}
