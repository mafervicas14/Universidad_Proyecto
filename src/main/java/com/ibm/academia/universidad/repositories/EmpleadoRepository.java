package com.ibm.academia.universidad.repositories;

import com.ibm.academia.universidad.enums.TipoEmpleado;
import com.ibm.academia.universidad.models.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("repositorioEmpleados")
public interface EmpleadoRepository extends PersonaRepository {

    @Query("select e from Empleado e where e.tipoEmpleado = ?1")
    public Optional<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);

}
