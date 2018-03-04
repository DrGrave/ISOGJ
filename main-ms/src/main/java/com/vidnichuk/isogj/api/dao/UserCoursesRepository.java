package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.UserCourses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCoursesRepository extends JpaRepository<UserCourses, Long>{
    List<UserCourses> findAllByUser_Id(Long id);
    UserCourses findById(Long id);
}
