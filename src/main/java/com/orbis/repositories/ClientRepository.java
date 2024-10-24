package com.orbis.repositories;

import com.orbis.entities.Client;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ClientRepository extends CrudRepository<Client, Integer>, JpaSpecificationExecutor<Client> {

    @Query("SELECT u FROM Client u WHERE u.cpf = :cpf")
    Client findByCpf(String cpf);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN TRUE ELSE FALSE END FROM Client u WHERE u.cpf = :cpf")
    boolean existsClientByCpf(String cpf);
}