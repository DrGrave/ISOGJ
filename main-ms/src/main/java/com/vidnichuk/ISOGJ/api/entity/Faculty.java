package com.vidnichuk.ISOGJ.api.entity;

import javax.persistence.*;

/**
 * Created by Vadim on 06.11.2017.
 * faculty entity
 */
@Entity
@Table(name = "Faculty")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFaculty;

    @ManyToOne
        @JoinColumn(name = "Univercity")
    private String univercity;
}
