package com.ibm.academia.universidad.repositories;

import com.ibm.academia.universidad.entities.Carrera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends CrudRepository <Carrera, Integer> {

}
