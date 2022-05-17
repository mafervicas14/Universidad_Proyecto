package com.ibm.academia.universidad.repositories;

import com.ibm.academia.universidad.models.entities.Carrera;
import com.ibm.academia.universidad.models.entities.Pabellon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PabellonRepository extends CrudRepository<Pabellon, Integer>
{
    @Query("select p from Pabellon p where p.nombre = ?1 ")
    public Iterable<Pabellon> findPabellonByName(String nombre);
}
