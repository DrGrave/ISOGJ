package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.type.TypeOfLink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfLinkRepository extends JpaRepository<TypeOfLink, Long>{
    TypeOfLink findByName(String name);
}
