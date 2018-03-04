package com.vidnichuk.isogj.api.dto.model;

import java.util.Date;

public class UserCoursesDto {
    private Long id;
    private CoursesDto courses;
    private Date dateOfStart;
    private Date dateOfEnd;
    private boolean ifCoursesPass;

    public UserCoursesDto(Long id, CoursesDto courses, Date dateOfStart, Date dateOfEnd, boolean ifCoursesPass) {
        this.id = id;
        this.courses = courses;
        this.dateOfStart = dateOfStart;
        this.dateOfEnd = dateOfEnd;
        this.ifCoursesPass = ifCoursesPass;
    }

    public UserCoursesDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CoursesDto getCourses() {
        return courses;
    }

    public void setCourses(CoursesDto courses) {
        this.courses = courses;
    }

    public Date getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public Date getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(Date dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    public boolean isIfCoursesPass() {
        return ifCoursesPass;
    }

    public void setIfCoursesPass(boolean ifCoursesPass) {
        this.ifCoursesPass = ifCoursesPass;
    }
}
