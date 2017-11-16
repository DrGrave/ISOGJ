package com.vidnichuk.isogj.api.dao;


import com.vidnichuk.isogj.api.entity.MyUserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserCredentialsDAO extends JpaRepository<MyUserCredentials, Long> {
    MyUserCredentials findByIdUserCredential(int id);
    MyUserCredentials findByUserLogin(String login);
}
