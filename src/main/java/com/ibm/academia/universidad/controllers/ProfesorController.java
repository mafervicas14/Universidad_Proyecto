package com.ibm.academia.universidad.controllers;


import com.ibm.academia.universidad.exceptions.BadRequestException;
import com.ibm.academia.universidad.exceptions.NotFoundException;
import com.ibm.academia.universidad.models.entities.Persona;
import com.ibm.academia.universidad.services.AlumnoDAO;
import com.ibm.academia.universidad.services.CarreraDAO;
import com.ibm.academia.universidad.services.PersonaDAO;
import com.ibm.academia.universidad.services.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profesor")
public class ProfesorController
{
    @Autowired
    @Qualifier("profesorDAOImpl")
    private PersonaDAO profesorDAO;

    @Autowired
    private CarreraDAO carreraDAO;

    /**
     * EndPoint para crear un objeto Persona de tipo Profesor
     * @param profesor Objeto profesor con la información a crear
     * @return Retorna un objeto Persona de tipo profesor con código httpstatus 201
     * @author Mafervicas 05/16/2022
     */
    @PostMapping()
    public ResponseEntity<?> crearProfesor(@RequestBody Persona profesor)
    {
        Persona profesorGuardado= profesorDAO.guardar(profesor);
        return new ResponseEntity<Persona>(profesorGuardado, HttpStatus.CREATED);
    }

    /**
     * EndPoint para listar profesores
     * @return Retorna listado de todos los Profesores
     * @author Mafervicas 05/16/2022
     */
    @GetMapping("/lista/profesores")
    public ResponseEntity<?> obtenerTodos()
    {
        List<Persona> profesores = (List<Persona>) profesorDAO.buscarTodos();
        if(profesores.isEmpty())
            throw  new BadRequestException("No existen alumnos");
        return new ResponseEntity<List<Persona>>(profesores, HttpStatus.OK);
    }

    /**
     * EndPoint para mostrar un objeto de tipo Persona Profesor
     * @param profesorId Parámetro para buscar el Pofesor
     * @return Retorna un objeto de tipo Persona con su información
     * @NotFoundException En caso de que falle encontrando el objeto profesor
     * @author Mafervicas 05/15/2022
     */
    @GetMapping("/profesorId/{profesorId}")
    public ResponseEntity<?> obtenerProfesorPorId(@PathVariable Integer profesorId)
    {
        Optional<Persona> oProfesor = profesorDAO.buscarPorId(profesorId);
        if(!oProfesor.isPresent())
            throw new BadRequestException(String.format("El profesor con ID: %d no existe", profesorId));

        return new ResponseEntity<List<Persona>>((List<Persona>) oProfesor.get(), HttpStatus.OK);
    }


    /**
     * EndPoint para actualizar un objeto de tipo Persona profesor
     * @param profesorId Parámetro para buscar el alumno
     * @param profesor Objeto con la información a modificar
     * @return Retorna un objeto de tipo Persona profesor con la información actualizada
     * @NotFoundException En caso de que falle actualizando el objeto profesor
     * @author Mafervicas 05/16/2022
     */
    @PutMapping("/upd/profesorId/{profesorId}")
    public ResponseEntity<?> actualizarProfesor(@PathVariable Integer profesorId, @RequestBody Persona profesor)
    {

        Optional<Persona> oProfesor = profesorDAO.buscarPorId(profesorId);

        if(!oProfesor.isPresent())
            throw new NotFoundException(String.format("El alumno con id %d no existe", profesorId));

        Persona profesorUpdate = ((ProfesorDAO)profesorDAO).actualizar(oProfesor.get(), profesor);
        return new ResponseEntity<Persona>(profesorUpdate, HttpStatus.OK);

    }

    /**
     * EndPoint para eliminar un objeto de tipo profesor
     * @param profesorId Parámetro para identificar al profesor
     * @return Retorna una respuesta sobre la eliminación de ese profesor
     * @NotFoundException En caso de que no exista el profesor con ese ID a eliminar
     * @author Mafervicas 05/16/2022
     */

    @DeleteMapping("/profesorId/{profesorId}")
    public ResponseEntity<?> eliminarProfesor(@PathVariable Integer profesorId)
    {
        Optional<Persona> oProfesor = profesorDAO.buscarPorId(profesorId);

        if(!oProfesor.isPresent())
            throw new NotFoundException(String.format("El profesor con ID: %d no existe", profesorId));

        profesorDAO.eliminarPorId(profesorId);
        return new ResponseEntity<String>("Profesor ID: " + profesorId + " se eliminó satisfactoriamente", HttpStatus.NO_CONTENT);
    }

}
