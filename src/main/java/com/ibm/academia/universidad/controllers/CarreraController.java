package com.ibm.academia.universidad.controllers;


import com.ibm.academia.universidad.exceptions.NotFoundException;
import com.ibm.academia.universidad.models.entities.Carrera;
import com.ibm.academia.universidad.exceptions.BadRequestException;
import com.ibm.academia.universidad.services.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Controller que crea y permite consumir las APIs para Carrera
 * @author Mafervicas 06/15/2022
 */

@RestController
@RequestMapping("/carrera")
public class CarreraController
{

    @Autowired
    private CarreraDAO carreraDAO;

    /**
     * EndPoint para mostrar todas las carreras
     * @return Retorna la lista de carreras
     * @BadRequestException En caso de que no existan carreras (Lista vacía)
     * @author Mafervicas 05/15/2022
     */
    @GetMapping("/lista/carreras")
    public List<Carrera> buscarTodas()
    {
        List<Carrera> carreras = (List<Carrera>) carreraDAO.buscarTodos();
        if(carreras.isEmpty())
            throw  new BadRequestException("No existen carreras");
        return carreras;
    }

    /**
     * EndPoint para mostrar una carrera según su Id
     * @param carreraId Parámetro para buscar la carrera con ese Id
     * @return Retorna un objeto de tipo Carrera con su información
     * @BadRequestException En caso de que no se encuentre ese Id en la lista
     * @author Mafervicas 05/15/2022
     */
    @GetMapping("/id/{carreraId}")
    public Carrera buscarCarreraPorId(@PathVariable Integer carreraId)
    {
        Optional<Carrera> oCarrera = carreraDAO.buscarPorId(carreraId);
        if(!oCarrera.isPresent())
            throw new BadRequestException(String.format("La carrera con ID: %d no existe", carreraId));

        return  oCarrera.get();
    }

    /**
     * EndPoint para guardar/agregar una nueva Carrera
     * @param carrera Objeto con la información a modificar
     * @Param result Muestra si encontró un error y de ser así anexa el mensaje previamente especificado
     * @return Retorna si hubo un error al agregar la carrera o si se pudo crear correctamente, la información
     * @author Mafervicas 05/15/2022
     */
    @PostMapping
    public ResponseEntity<?> guardarCarrera(@Valid @RequestBody Carrera carrera, BindingResult result)
    {
        Map<String, Object> validaciones = new HashMap<String, Object>();
        if(result.hasErrors())
        {
            List<String> listaErrores = result.getFieldErrors()
                    .stream()
                    .map(errores -> "Campo: '" + errores.getField() + "'" + errores.getDefaultMessage())
                    .collect(Collectors.toList());
            validaciones.put("Lista Errores", listaErrores);
            return new ResponseEntity<Map<String, Object>>(validaciones, HttpStatus.BAD_REQUEST);
        }

        Carrera carreraGuardada = carreraDAO.guardar(carrera);
        return new ResponseEntity<Carrera>(carreraGuardada, HttpStatus.CREATED);
    }


    /**
     * EndPoint para actualizar un objeto de tipo carrera
     * @param carreraId Parámetro para buscar la carrera
     * @param carrera Objeto con la información a modificar
     * @return Retorna un objeto de tipo Carrera con la información actualizada
     * @NotFoundException En caso de que falle actualizando el objeto carrera
     * @author Mafervicas 05/15/2022
     */

    @PutMapping("/upd/carreraId/{carreraId}")
    public ResponseEntity<?> actualizarCarrera(@PathVariable Integer carreraId, @RequestBody Carrera carrera)
    {

        Optional<Carrera> oCarrera = carreraDAO.buscarPorId(carreraId);

        if(!oCarrera.isPresent())
            throw new NotFoundException(String.format("La carrera con id %d no existe", carreraId));

        Carrera carreraUpdate = carreraDAO.actualizar(oCarrera.get(), carrera);
        return new ResponseEntity<Carrera>(carreraUpdate, HttpStatus.OK);

    }

    /**
     * EndPoint para eliminar un objeto de tipo carrera
     * @param carreraId Parámetro para buscar la carrera
     * @return Retorna una respuesta sobre la eliminación de esa carrera
     * @NotFoundException En caso de que no exista esa carrera con ese ID a eliminar
     * @author Mafervicas 05/15/2022
     */

    @DeleteMapping("/carreraId/{carreraId}")
    public ResponseEntity<?> eliminarCarrera(@PathVariable Integer carreraId)
    {
        Map<String, Object> respuesta = new HashMap<String, Object>();
       Optional<Carrera> carrera = carreraDAO.buscarPorId(carreraId);

       if(!carrera.isPresent())
           throw new NotFoundException(String.format("La carera con ID: %d no existe", carreraId));

        carreraDAO.eliminarPorId(carreraId);
        respuesta.put("Ok", "Carrera ID " + carreraId + " eliminada existosamente");
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.ACCEPTED);
    }
}
