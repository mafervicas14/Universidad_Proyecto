package com.ibm.academia.universidad.controllers;


import com.ibm.academia.universidad.exceptions.BadRequestException;
import com.ibm.academia.universidad.exceptions.NotFoundException;
import com.ibm.academia.universidad.models.entities.Pabellon;
import com.ibm.academia.universidad.services.PabellonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/pabellon")
public class PabellonController {

    @Autowired
    private PabellonDAO pabellonDAO;

    /**
     * EndPoint para mostrar todas los Pabellones
     * @return Retorna la lista de pabellones
     * @BadRequestException En caso de que no existan Pabellones (Lista vacía)
     * @author Mafervicas 05/16/2022
     */
    @GetMapping("/lista/pabellones")
    public List<Pabellon> buscarTodas()
    {
        List<Pabellon> pabellones = (List<Pabellon>) pabellonDAO.buscarTodos();
        if(pabellones.isEmpty())
            throw  new BadRequestException("No existen pabellones");
        return pabellones;
    }

    /**
     * EndPoint para crear Pabellones
     * @return Retorna la creación del pabellon y el estatus HTTP
     * @author Mafervicas 05/16/2022
     */
    @PostMapping()
    public ResponseEntity<?> crearPabellon(@RequestBody Pabellon pabellon)
    {
        Pabellon pabellonGuardado= pabellonDAO.guardar(pabellon);
        return new ResponseEntity<Pabellon>(pabellonGuardado, HttpStatus.CREATED);
    }

    /**
     * EndPoint para mostrar un Pabellón según su Id
     * @param pabellonId Parámetro para buscar el Pabellón con ese Id
     * @return Retorna un objeto de tipo Pabellón con su información
     * @BadRequestException En caso de que no se encuentre ese Id del Pabellón
     * @author Mafervicas 05/15/2022
     */
    @GetMapping("/id/{pabellonId}")
    public Pabellon buscarPabellonPorId(@PathVariable Integer pabellonId)
    {
        Optional<Pabellon> oPabellon = pabellonDAO.buscarPorId(pabellonId);
        if(!oPabellon.isPresent())
            throw new BadRequestException(String.format("El Pabellon con ID: %d no existe", pabellonId));
        return  oPabellon.get();
    }

    /**
     * EndPoint para eliminar un objeto de tipo aula
     * @param pabellonId Parámetro para buscar el aula
     * @return Retorna una respuesta sobre la eliminación de esa aula
     * @NotFoundException En caso de que no exista esa aula con ese ID a eliminar
     * @author Mafervicas 05/16/2022
     */
    @DeleteMapping("/pabellonId/{pabellonId}")
    public ResponseEntity<?> eliminarPabellon(@PathVariable Integer pabellonId)
    {
        Map<String, Object> respuesta = new HashMap<String, Object>();
        Optional<Pabellon> pabellon = pabellonDAO.buscarPorId(pabellonId);

        if(!pabellon.isPresent())
            throw new NotFoundException(String.format("El pabellon con ID: %d no existe", pabellonId));

        pabellonDAO.eliminarPorId(pabellonId);
        respuesta.put("Ok", "Pabellon ID " + pabellonId + " eliminada existosamente");
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.ACCEPTED);
    }
}
