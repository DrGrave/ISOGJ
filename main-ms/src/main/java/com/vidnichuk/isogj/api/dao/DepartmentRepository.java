package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
    List<Department> findAllByNameContainsAndAndFacultyId(String name, Long id);
    Department findByName(String name);
}
