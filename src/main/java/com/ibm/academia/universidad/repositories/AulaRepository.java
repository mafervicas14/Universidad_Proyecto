package com.ibm.academia.universidad.repositories;


import com.ibm.academia.universidad.models.entities.Aula;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends CrudRepository<Aula, Integer> {
}
