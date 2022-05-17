package com.ibm.academia.universidad.repositories;

import com.ibm.academia.universidad.models.entities.Carrera;
import com.ibm.academia.universidad.models.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarreraRepository extends CrudRepository <Carrera, Integer>
{

    //Por métodos
    //@Query("select c from Carrera c where c.cantidadAnios =?1")
    public Iterable <Carrera> findCarrerasByCantidadAnios(Integer cantidadAnios);

    //@Query("select c from Carrera c where c.nombre like %?1%")
    public  Iterable <Carrera> findCarrerasByNombreContains(String nombre);

    //@Query("select c from Carrera c where upper(c.nombre) (like upper%?1%)")
    public  Iterable <Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
    

	//@Query("select c from Carrera c where c.cantidadAnios > ?1 ")
    public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);

    @Query("select p from Persona p where p.nombre = ?1 and p.apellido = ?2")
    public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);


    @Query("select c from Carrera c join fetch c.profesores p where p.nombre = ?1 and p.apellido = ?2")
    public Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellid(String nombre, String apellido);


}
