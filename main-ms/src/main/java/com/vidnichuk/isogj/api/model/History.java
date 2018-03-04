package com.vidnichuk.isogj.api.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "History")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DateOfHistory")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "User")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Courses")
    private UserCourses userCourses;

    @ManyToOne
    @JoinColumn(name = "Experience")
    private Experience experience;


    @ManyToOne
    @JoinColumn(name = "Education")
    private Education education;

    @Column(name = "HistoryInfo")
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserCourses getUserCourses() {
        return userCourses;
    }

    public void setUserCourses(UserCourses userCourses) {
        this.userCourses = userCourses;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public String getHistoryInfo() {
        return historyInfo;
    }

    public void setHistoryInfo(String historyInfo) {
        this.historyInfo = historyInfo;
    }
}
