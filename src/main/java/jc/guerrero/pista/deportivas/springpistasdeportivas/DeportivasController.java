package jc.guerrero.pista.deportivas.springpistasdeportivas;

import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.AlquilerPista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Pista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Rol;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Usuario;
import jc.guerrero.pista.deportivas.springpistasdeportivas.service.DeportivasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Juan Carlos on 27/09/2017.
 */

@Controller
@RequestMapping(path="/deportivas")
public class DeportivasController {

    @Autowired
    private DeportivasService deportivasService;

    /**
     * Insertar usuarios
     *
     * @param usuario
     */
    @RequestMapping(value = "/insertarUsuario", produces = "application/json", method = RequestMethod.POST)
    public void insertarUsuario (@RequestBody Usuario usuario) {
       deportivasService.insertarUsuario(usuario);
    }

    /**
     * Insertar Roles
     *
     * @param rol
     */
    @RequestMapping(value="/insertarRol", produces = "application/json", method = RequestMethod.POST)
    public void insertarRol(@RequestBody Rol rol) {
        deportivasService.insertarRole(rol);
    }

    /**
     * Insertar Pista
     *
     * @param pista
     */
    @RequestMapping(path="/insertarPista", produces = "application/json", method = RequestMethod.POST)
    public void insertarPista(@RequestBody Pista pista) {
        deportivasService.insertarPista(pista);
    }

    /**
     * Alquilar Pista
     *
     * @param alquilerPista
     */
    @RequestMapping(path="/alquilerPista", produces = "application/json", method = RequestMethod.POST)
    public void alquilarPista(@RequestBody AlquilerPista alquilerPista) {
        deportivasService.insertarFechaAlquiler(alquilerPista);
    }

    /**
     * listar todas las pistas
     *
     * @return
     */

    @RequestMapping(value = "/pistas", method = RequestMethod.GET,  produces = "application/json")
    public ResponseEntity<List<Pista>> getListadoPistas() {
        List pista = deportivasService.getListadoTodasLasPistas();
        return new ResponseEntity<>(pista, HttpStatus.OK);
    }

    /**
     * listar las pistas por su tipo
     *
     * @return
     */
    @RequestMapping(value = "/pistasTipo/{tipo}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Pista>> getListadoPistasPorTipo(@PathVariable String tipo) {
        List pista = deportivasService.getListaPistasPorTipo(tipo);
        return new ResponseEntity<>(pista, HttpStatus.OK);
    }

    /**
     * listar una pista concreta por si id
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/pistas/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Pista> getPistaConcreta(@PathVariable int id) {
        Pista pista = deportivasService.getPistaConcretaPorId(id);
        return new ResponseEntity<>(pista, HttpStatus.OK);
    }


}
