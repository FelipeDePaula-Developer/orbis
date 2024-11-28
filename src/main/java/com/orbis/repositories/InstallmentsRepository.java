package com.orbis.repositories;

import com.orbis.entities.Contract;
import com.orbis.entities.Installments;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface InstallmentsRepository extends CrudRepository<Installments, Integer>, JpaSpecificationExecutor<Installments> {

}