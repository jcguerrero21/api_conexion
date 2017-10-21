package jc.guerrero.pista.deportivas.springpistasdeportivas;

import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.AlquilerPista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Pista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Rol;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Usuario;
import jc.guerrero.pista.deportivas.springpistasdeportivas.service.DeportivasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Juan Carlos on 27/09/2017.
 */

@Controller
@RequestMapping(path="/deportivas")
public class MainController {

    @Autowired
    private DeportivasService deportivasService;

    /**
     * Insertar usuarios
     *
     * @param usuario
     */
    @RequestMapping(value = "/insertarUsuario", produces = "application/json", method = RequestMethod.POST)
    @ResponseBody public void insertarUsuario (@RequestBody Usuario usuario) {

       deportivasService.insertarUsuario(usuario);

    }

    /**
     * Insertar Roles
     *
     * @param rol
     */
    @PostMapping(path="/insertarRol")
    public @ResponseBody void insertarRol(@RequestBody Rol rol) {
        deportivasService.insertarRole(rol);
    }

    /**
     * Insertar Pista
     *
     * @param pista
     */
    @PostMapping(path="/insertarPista")
    public @ResponseBody void insertarPista(@RequestBody Pista pista) {
        deportivasService.insertarPista(pista);
    }

    /**
     * Alquilar Pista
     *
     * @param alquilerPista
     */
    @PostMapping(path="/alquilerPista")
    public @ResponseBody void alquilarPista(@RequestBody AlquilerPista alquilerPista) {
        deportivasService.insertarFechaAlquiler(alquilerPista);
    }
}
