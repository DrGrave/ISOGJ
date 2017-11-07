package com.vidnichuk.ISOGJ.api.service;

import com.vidnichuk.ISOGJ.api.entity.TypeOfAccepted;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * service to type of accepted repository
 */
public interface TypeOfAcceptedService {
    List<TypeOfAccepted> getAllTypeOfAccepted();
    TypeOfAccepted getTypeOfAcceptedById(int idTypeOfAccepted);
    void saveTypeOfAccepted(TypeOfAccepted typeOfAccepted);
}
