package com.vidnichuk.isogj.api.dto.model;

import java.util.Date;

public class HistoryDto {
    private Long id;

    private Date date;
    private UserCoursesDto userCourses;

    private ExperienceDto experience;

    private EducationDto education;

    private String historyInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserCoursesDto getUserCourses() {
        return userCourses;
    }

    public void setUserCourses(UserCoursesDto userCourses) {
        this.userCourses = userCourses;
    }

    public ExperienceDto getExperience() {
        return experience;
    }

    public void setExperience(ExperienceDto experience) {
        this.experience = experience;
    }

    public EducationDto getEducation() {
        return education;
    }

    public void setEducation(EducationDto education) {
        this.education = education;
    }

    public String getHistoryInfo() {
        return historyInfo;
    }

    public void setHistoryInfo(String historyInfo) {
        this.historyInfo = historyInfo;
    }
}
