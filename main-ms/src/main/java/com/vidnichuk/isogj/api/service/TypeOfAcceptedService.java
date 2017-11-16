package com.vidnichuk.isogj.api.service;

import com.vidnichuk.isogj.api.entity.TypeOfAccepted;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to type of accepted repository
 */
public interface TypeOfAcceptedService {

    /**
     *
     * @return
     * all types of accepted
     */
    List<TypeOfAccepted> getAllTypeOfAccepted();

    /**
     *
     * @param idTypeOfAccepted
     * id of type of accepted
     * @return
     * type of accepted with this id
     */
    TypeOfAccepted getTypeOfAcceptedById(int idTypeOfAccepted);

    /**
     *
     * @param typeOfAccepted
     * save type of accepted
     */
    void saveTypeOfAccepted(TypeOfAccepted typeOfAccepted);
}
