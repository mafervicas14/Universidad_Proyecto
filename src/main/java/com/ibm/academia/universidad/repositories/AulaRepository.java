package com.ibm.academia.universidad.repositories;


import com.ibm.academia.universidad.enums.Pizzaron;
import com.ibm.academia.universidad.enums.TipoEmpleado;
import com.ibm.academia.universidad.models.entities.Aula;
import com.ibm.academia.universidad.models.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AulaRepository extends CrudRepository<Aula, Integer> {

    @Query(value = "SELECT * FROM universidad.aulas WHERE tipo_pizarron = ?1", nativeQuery = true )
    public Iterable<Aula> findAulasbyPizarron (Pizzaron pizzaron);

}
