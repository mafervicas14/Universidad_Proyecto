package com.ibm.academia.universidad.controllers;

import com.ibm.academia.universidad.exceptions.BadRequestException;
import com.ibm.academia.universidad.exceptions.NotFoundException;
import com.ibm.academia.universidad.models.entities.Persona;
import com.ibm.academia.universidad.services.CarreraDAO;
import com.ibm.academia.universidad.services.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    @Qualifier("empleadoDAOImpl")
    private PersonaDAO empleadoDAO;

    @Autowired
    private CarreraDAO carreraDAO;

    /**
     * EndPoint para crear un objeto Persona de tipo Empleado
     * @param empleado Objeto empleado con la información a crear
     * @return Retorna un objeto Persona de tipo empleado con código httpstatus 201
     * @author Mafervicas 05/16/2022
     */
    @PostMapping()
    public ResponseEntity<?> crearEmpleado(@RequestBody Persona empleado)
    {
        Persona empleadoGuardado= empleadoDAO.guardar(empleado);
        return new ResponseEntity<Persona>(empleadoGuardado, HttpStatus.CREATED);
    }

    /**
     * EndPoint para listar empleados
     * @return Retorna listado de todos los Empleados
     * @author Mafervicas 05/16/2022
     */
    @GetMapping("/lista/empleados")
    public ResponseEntity<?> obtenerTodos()
    {
        List<Persona> empleados = (List<Persona>) empleadoDAO.buscarTodos();
        if(empleados.isEmpty())
            throw  new BadRequestException("No existen empleados");
        return new ResponseEntity<List<Persona>>(empleados, HttpStatus.OK);
    }

    /**
     * EndPoint para mostrar un objeto de tipo Persona Empleado
     * @param empleadoId Parámetro para buscar el Empleado
     * @return Retorna un objeto de tipo Persona con su información
     * @NotFoundException En caso de que falle encontrando el objeto Empleado
     * @author Mafervicas 05/16/2022
     */
    @GetMapping("/empleadoId/{empleadoId}")
    public ResponseEntity<?> obtenerEmpleadoPorId(@PathVariable Integer empleadoId)
    {
        Optional<Persona> oEmpleado = empleadoDAO.buscarPorId(empleadoId);
        if(!oEmpleado.isPresent())
            throw new BadRequestException(String.format("El Empleado con ID: %d no existe", empleadoId));

        return new ResponseEntity<List<Persona>>((List<Persona>) oEmpleado.get(), HttpStatus.OK);
    }

    /**
     * EndPoint para eliminar un objeto de tipo Empleado
     * @param empleadoId Parámetro para identificar al Empleado
     * @return Retorna una respuesta sobre la eliminación de ese Empleado
     * @NotFoundException En caso de que no exista el Empleado con ese ID a eliminar
     * @author Mafervicas 05/16/2022
     */

    @DeleteMapping("/empleadoId/{empleadoId}")
    public ResponseEntity<?> eliminarEmpleado(@PathVariable Integer empleadoId)
    {
        Optional<Persona> oEmpleado = empleadoDAO.buscarPorId(empleadoId);

        if(!oEmpleado.isPresent())
            throw new NotFoundException(String.format("El alumno con ID: %d no existe", empleadoId));

        empleadoDAO.eliminarPorId(empleadoId);
        return new ResponseEntity<String>("Alumno ID: " + empleadoId + " se eliminó satisfactoriamente", HttpStatus.NO_CONTENT);
    }
}
