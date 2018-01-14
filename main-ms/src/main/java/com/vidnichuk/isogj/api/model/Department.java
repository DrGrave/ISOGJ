package com.vidnichuk.isogj.api.model;

import javax.persistence.*;

@Entity
@Table(name = "Department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Faculty")
    private Faculty faculty;

    @Column(name = "Name")
    private String name;
}
