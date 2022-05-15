package com.ibm.academia.universidad.repositories;

import com.ibm.academia.universidad.entities.Carrera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends CrudRepository <Carrera, Integer>
{

    //Por métodos
    //@Query("select c from Carrera c where c.cantidadAnios =?1")
    public Iterable <Carrera> findCarrerasByCantidadAnios(Integer cantidadAnios);

    //@Query("select c from Carrera c where c.nombre like %?1%")
    public  Iterable <Carrera> findCarrerasByNombreContains(String nombre);

    //@Query("select c from Carrera c where upper(c.nombre) like upper(%?1%)")
    public  Iterable <Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
    

	//@Query("select c from Carrera c where c.cantidadAnios > ?1 ")
    public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);

}
