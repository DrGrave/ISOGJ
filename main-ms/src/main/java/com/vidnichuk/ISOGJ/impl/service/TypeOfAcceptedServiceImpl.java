package com.vidnichuk.ISOGJ.impl.service;

import com.vidnichuk.ISOGJ.api.dao.TypeOfAcceptedRepository;
import com.vidnichuk.ISOGJ.api.entity.TypeOfAccepted;
import com.vidnichuk.ISOGJ.api.service.TypeOfAcceptedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vadim on 07.11.2017.
 * implementation of type of accepted service
 */
@Service
public class TypeOfAcceptedServiceImpl implements TypeOfAcceptedService{
    @Autowired
    private TypeOfAcceptedRepository typeOfAcceptedRepository;

    @Override
    public List<TypeOfAccepted> getAllTypeOfAccepted() {
        return typeOfAcceptedRepository.findAll();
    }

    @Override
    public TypeOfAccepted getTypeOfAcceptedById(int idTypeOfAccepted) {
        return typeOfAcceptedRepository.findByIdTypeOfAccepted(idTypeOfAccepted);
    }

    @Override
    public void saveTypeOfAccepted(TypeOfAccepted typeOfAccepted) {
        typeOfAcceptedRepository.save(typeOfAccepted);
    }
}
