package com.ibm.academia.universidad.controllers;

import com.ibm.academia.universidad.exceptions.BadRequestException;
import com.ibm.academia.universidad.exceptions.NotFoundException;
import com.ibm.academia.universidad.models.entities.Aula;
import com.ibm.academia.universidad.services.AulaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    private AulaDAO aulaDAO;

    /**
     * EndPoint para mostrar todas las aulas
     * @return Retorna la lista de aulas
     * @BadRequestException En caso de que no existan Aulas (Lista vacía)
     * @author Mafervicas 05/16/2022
     */
    @GetMapping("/lista/aulas")
    public List<Aula> buscarTodas()
    {
        List<Aula> aulas = (List<Aula>) aulaDAO.buscarTodos();
        if(aulas.isEmpty())
            throw  new BadRequestException("No existen aulas");
        return aulas;
    }

    @PostMapping()
    public ResponseEntity<?> crearAula(@RequestBody Aula aula)
    {
        Aula aulaGuardada= aulaDAO.guardar(aula);
        return new ResponseEntity<Aula>(aulaGuardada, HttpStatus.CREATED);
    }

    /**
     * EndPoint para mostrar un Aula según su Id
     * @param aulaId Parámetro para buscar el Aula con ese Id
     * @return Retorna un objeto de tipo Aula con su información
     * @BadRequestException En caso de que no se encuentre ese Id en la lista
     * @author Mafervicas 05/15/2022
     */
    @GetMapping("/id/{aulaId}")
    public Aula buscarAulaPorId(@PathVariable Integer aulaId)
    {
        Optional<Aula> oAula = aulaDAO.buscarPorId(aulaId);
        if(!oAula.isPresent())
            throw new BadRequestException(String.format("El Aula con ID: %d no existe", aulaId));
        return  oAula.get();
    }


    /**
     * EndPoint para eliminar un objeto de tipo aula
     * @param aulaId Parámetro para buscar el aula
     * @return Retorna una respuesta sobre la eliminación de esa aula
     * @NotFoundException En caso de que no exista esa aula con ese ID a eliminar
     * @author Mafervicas 05/16/2022
     */
    @DeleteMapping("/carreraId/{aulaId}")
    public ResponseEntity<?> eliminarAula(@PathVariable Integer aulaId)
    {
        Map<String, Object> respuesta = new HashMap<String, Object>();
        Optional<Aula> aula = aulaDAO.buscarPorId(aulaId);

        if(!aula.isPresent())
            throw new NotFoundException(String.format("El aula con ID: %d no existe", aulaId));

        aulaDAO.eliminarPorId(aulaId);
        respuesta.put("Ok", "Aula ID " + aulaId + " eliminada existosamente");
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.ACCEPTED);
    }
}
