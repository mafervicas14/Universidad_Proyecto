package com.ibm.academia.universidad.controllers;

import com.ibm.academia.universidad.exceptions.NotFoundException;
import com.ibm.academia.universidad.models.entities.Carrera;
import com.ibm.academia.universidad.models.entities.Persona;
import com.ibm.academia.universidad.exceptions.BadRequestException;
import com.ibm.academia.universidad.services.AlumnoDAO;
import com.ibm.academia.universidad.services.CarreraDAO;
import com.ibm.academia.universidad.services.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/alumno")
public class AlumnoController
{

    @Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO alumnoDAO;

    @Autowired
    private CarreraDAO carreraDAO;

    /**
     * EndPoint para crear un objeto Persona de tipo Alumno
     * @param alumno Objeto alumno con la información a crear
     * @return Retorna un objeto Persona de tipo alumno con código httpstatus 201
     * @author Mafervicas 05/15/2022
     */
    @PostMapping()
    public ResponseEntity<?> crearAlumno(@RequestBody Persona alumno)
    {
       Persona alumnoGuardado= alumnoDAO.guardar(alumno);
        return new ResponseEntity<Persona>(alumnoGuardado, HttpStatus.CREATED);
    }

    /**
     * EndPoint para listar alumnos
     * @return Retorna listado de todos los Alumnos
     * @author Mafervicas 05/15/2022
     */
    @GetMapping("/lista/alumnos")
    public ResponseEntity<?> obtenerTodos()
    {
        List<Persona> alumnos = (List<Persona>) alumnoDAO.buscarTodos();
        if(alumnos.isEmpty())
            throw  new BadRequestException("No existen alumnos");
        return new ResponseEntity<List<Persona>>(alumnos, HttpStatus.OK);
    }

    /**
     * EndPoint para mostrar un objeto de tipo Persona Alumno
     * @param alumnoId Parámetro para buscar el Alumno
     * @return Retorna un objeto de tipo Persona con su información
     * @NotFoundException En caso de que falle encontrando el objeto alumno
     * @author Mafervicas 05/15/2022
     */
    @GetMapping("/alumnoId/{alumnoId}")
    public ResponseEntity<?> obtenerAlumnoPorId(@PathVariable Integer alumnoId)
    {
        Optional<Persona> oAlumno = alumnoDAO.buscarPorId(alumnoId);
        if(!oAlumno.isPresent())
            throw new BadRequestException(String.format("El alumno con ID: %d no existe", alumnoId));

        return new ResponseEntity<List<Persona>>((List<Persona>) oAlumno.get(), HttpStatus.OK);
    }

    /**
     * EndPoint para actualizar un objeto de tipo Persona alumno
     * @param alumnoId Parámetro para buscar el alumno
     * @param alumno Objeto con la información a modificar
     * @return Retorna un objeto de tipo Persona alumno con la información actualizada
     * @NotFoundException En caso de que falle actualizando el objeto alumno
     * @author Mafervicas 05/15/2022
     */
    @PutMapping("/upd/alumnoId/{alumnoId}")
    public ResponseEntity<?> actualizarProfesor(@PathVariable Integer alumnoId, @RequestBody Persona alumno)
    {

        Optional<Persona> oAlumno = alumnoDAO.buscarPorId(alumnoId);

        if(!oAlumno.isPresent())
            throw new NotFoundException(String.format("El alumno con id %d no existe", alumnoId));

        Persona alumnoUpdate = ((AlumnoDAO)alumnoDAO).actualizar(oAlumno.get(), alumno);
        return new ResponseEntity<Persona>(alumnoUpdate, HttpStatus.OK);

    }



    /**
     * EndPoint para eliminar un objeto de tipo alumno
     * @param alumnoId Parámetro para identificar al alumno
     * @return Retorna una respuesta sobre la eliminación de ese alumno
     * @NotFoundException En caso de que no exista el alumno con ese ID a eliminar
     * @author Mafervicas 05/15/2022
     */

    @DeleteMapping("/alumnoId/{alumnoId}")
    public ResponseEntity<?> eliminarAlumno(@PathVariable Integer alumnoId)
    {
        Optional<Persona> oAlumno = alumnoDAO.buscarPorId(alumnoId);

        if(!oAlumno.isPresent())
            throw new NotFoundException(String.format("El alumno con ID: %d no existe", alumnoId));

        alumnoDAO.eliminarPorId(alumnoId);
        return new ResponseEntity<String>("Alumno ID: " + alumnoId + " se eliminó satisfactoriamente", HttpStatus.NO_CONTENT);
    }

    /**
     * EndPoint para asignar a un objeto de tipo alumno una carrera
     * @param alumnoId Parámetro para identificar al alumno
     * @param
     * @return Retorna una respuesta sobre la eliminación de esa carrera
     * @NotFoundException En caso de que no exista el alumno con ese ID a eliminar
     * @author Mafervicas 05/15/2022
     */
    @PutMapping("/alumnoId/{alumnoId}/carrera/{carreraId}")
    public ResponseEntity<?> asignarCarreraAlumno(@PathVariable Integer carreraId, @PathVariable Integer alumnoId)
    {
        Optional<Persona> oAlumno = alumnoDAO.buscarPorId(alumnoId);
        if(!oAlumno.isPresent())
            throw new NotFoundException(String.format("Alumno con ID: %d no existe", alumnoId));
        Optional<Carrera> oCarrera = carreraDAO.buscarPorId(carreraId);
        if(!oCarrera.isPresent())
            throw new NotFoundException(String.format("Carrera con ID: %d no existe", carreraId));
        Persona alumno = ((AlumnoDAO)alumnoDAO).asociarCarreraAlumno(oAlumno.get(),oCarrera.get());
        return new ResponseEntity<Persona>(alumno, HttpStatus.OK);

    }

}



