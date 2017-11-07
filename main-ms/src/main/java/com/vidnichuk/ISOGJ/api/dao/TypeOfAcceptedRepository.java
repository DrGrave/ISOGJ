package com.vidnichuk.ISOGJ.api.dao;

import com.vidnichuk.ISOGJ.api.entity.TypeOfAccepted;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vadim on 07.11.2017.
 * repository to accepted entity
 */
public interface TypeOfAcceptedRepository extends JpaRepository<TypeOfAccepted, Long>{
    TypeOfAccepted findByIdTypeOfAccepted(int idTypeOfAccepted);
}
