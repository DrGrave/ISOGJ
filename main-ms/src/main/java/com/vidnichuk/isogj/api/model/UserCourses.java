package com.vidnichuk.isogj.api.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "UserCourses")
public class UserCourses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Courses")
    private Courses courses;

    @ManyToOne
    @JoinColumn(name = "User")
    private User user;

    @Column(name = "DateOfStart")
    private Date dateOfStart;

    @Column(name = "DateOfEnd")
    private Date dateOfEnd;

    @Column(name = "IfCoursesPass")
    private boolean ifCoursesPass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
