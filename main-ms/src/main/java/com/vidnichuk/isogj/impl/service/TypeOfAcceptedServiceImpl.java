package com.vidnichuk.isogj.impl.service;

import com.vidnichuk.isogj.api.dao.TypeOfAcceptedRepository;
import com.vidnichuk.isogj.api.entity.TypeOfAccepted;
import com.vidnichuk.isogj.api.service.TypeOfAcceptedService;
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

    /**
     *
     * @return
     * all types of accepted
     */
    @Override
    public List<TypeOfAccepted> getAllTypeOfAccepted() {
        return typeOfAcceptedRepository.findAll();
    }

    /**
     *
     * @param idTypeOfAccepted
     * id of type of accepted
     * @return
     * type of accepted with this id
     */
    @Override
    public TypeOfAccepted getTypeOfAcceptedById(int idTypeOfAccepted) {
        return typeOfAcceptedRepository.findByIdTypeOfAccepted(idTypeOfAccepted);
    }

    /**
     *
     * @param typeOfAccepted
     * save type of accepted
     */
    @Override
    public void saveTypeOfAccepted(TypeOfAccepted typeOfAccepted) {
        typeOfAcceptedRepository.save(typeOfAccepted);
    }
}
