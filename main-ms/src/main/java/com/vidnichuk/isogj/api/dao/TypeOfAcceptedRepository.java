package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.entity.TypeOfAccepted;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to accepted entity
 */
public interface TypeOfAcceptedRepository extends JpaRepository<TypeOfAccepted, Long>{
    /**
     *
     * @param idTypeOfAccepted
     * id of type of accepted
     * @return
     * type of accepted with this id
     */
    TypeOfAccepted findByIdTypeOfAccepted(int idTypeOfAccepted);
}
