package com.vidnichuk.isogj.api.entity;



import javax.persistence.*;


/**
 * Type of user object
 */
@Entity
@Table(name = "TypeOfUser")
public class TypeOfUser {


    /**
     * identity of user type
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeOfUser;

    /**
     * name of user type
     */
    @Column(name = "NameOfTypeUser")
    private String nameOfTypeUser;

    /**
     *
     * @return
     * id of type
     */
    public int getIdTypeOfUser() {
        return idTypeOfUser;
    }

    /**
     *
     * @param idTypeOfUser
     * set id type of user
     */
    public void setIdTypeOfUser(int idTypeOfUser) {
        this.idTypeOfUser = idTypeOfUser;
    }

    /**
     *
     * @return
     * name of type user
     */
    public String getNameOfTypeUser() {
        return nameOfTypeUser;
    }

    /**
     *
     * @param nameOfTypeUser
     * set name of type user
     */
    public void setNameOfTypeUser(String nameOfTypeUser) {
        this.nameOfTypeUser = nameOfTypeUser;
    }
}
