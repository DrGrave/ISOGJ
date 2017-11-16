package com.vidnichuk.isogj.api.entity;

import javax.persistence.*;

/**
 * Created by Vadim on 07.11.2017.
 * type of accepted
 */
@Entity
@Table(name = "TypeOfAccepted")
public class TypeOfAccepted {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeOfAccepted;

    @Column(name = "NameOfAccepted")
    private String nameOfAccepted;

    public int getIdTypeOfAccepted() {
        return idTypeOfAccepted;
    }

    public void setIdTypeOfAccepted(int idTypeOfAccepted) {
        this.idTypeOfAccepted = idTypeOfAccepted;
    }

    public String getNameOfAccepted() {
        return nameOfAccepted;
    }

    public void setNameOfAccepted(String nameOfAccepted) {
        this.nameOfAccepted = nameOfAccepted;
    }
}
