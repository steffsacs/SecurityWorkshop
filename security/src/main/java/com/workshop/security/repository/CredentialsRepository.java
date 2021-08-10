package com.workshop.security.repository;

import com.workshop.security.model.Credentials;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CredentialsRepository extends JpaRepository <Credentials,Integer> {

    List <Credentials> findByIdUser(int idUser);

    List <Credentials> findByDomainAndUser(String domain,String user);

    Credentials findByDomainAndIdUserAndUser(String domain,int idUser, String user);
}
