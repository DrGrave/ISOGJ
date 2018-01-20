package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.UserLink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserLinkRepository extends JpaRepository<UserLink, Long>{
    List<UserLink> findAllByUserId(long id);
    UserLink findByUserIdAndTypeOfLinkId(long userId, long typeOfLink);
}
