package com.ibm.academia.universidad.repositories;

import com.ibm.academia.universidad.entities.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface PersonaRepository extends CrudRepository<Persona, Integer> {
}
