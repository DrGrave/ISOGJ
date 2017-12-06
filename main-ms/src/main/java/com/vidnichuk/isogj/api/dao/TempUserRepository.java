package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.entity.TempUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TempUserRepository extends JpaRepository<TempUser, Long> {
    TempUser findByConfirmLink(String confirmLink);

    TempUser findByUsername(String username);

    TempUser findByEmail(String email);
}
