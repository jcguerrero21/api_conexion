package jc.guerrero.pista.deportivas.springpistasdeportivas.web;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.AlquilerPista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Pista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Rol;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Usuario;
import jc.guerrero.pista.deportivas.springpistasdeportivas.service.DeportivasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Juan Carlos on 27/09/2017.
 */

@Controller
@RequestMapping(path = "/deportivas")
public class DeportivasController {

    @Autowired
    private DeportivasService deportivasService;

    /**
     * Insertar usuarios
     *
     * @param usuario
     */
    @RequestMapping(value = "/insertarUsuario", produces = "application/json", method = RequestMethod.POST)
    public void insertarUsuario(@RequestBody Usuario usuario, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            deportivasService.insertarUsuario(usuario);
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        deportivasService.insertarUsuario(usuario);
    }

    /**
     * Insertar Roles
     *
     * @param rol
     */
    @RequestMapping(value = "/insertarRol", produces = "application/json", method = RequestMethod.POST)
    public void insertarRol(@RequestBody Rol rol) {
        deportivasService.insertarRole(rol);
    }

    /**
     * Insertar Pista
     *
     * @param pista
     */
    @RequestMapping(path = "/insertarPista", produces = "application/json", method = RequestMethod.POST)
    public void insertarPista(@RequestBody Pista pista) {
        deportivasService.insertarPista(pista);
    }

    /**
     * Alquilar Pista
     *
     * @param alquilerPista
     */
    @RequestMapping(path = "/alquilerPista", produces = "application/json", method = RequestMethod.POST)
    public void alquilarPista(@RequestBody AlquilerPista alquilerPista) {
        deportivasService.alquilarPista(alquilerPista);
    }

    /**
     * listar todas las pistas
     *
     * @return
     */

    @RequestMapping(value = "/pistas", method = RequestMethod.GET, produces = "application/json")
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

    /**
     * listado de las pistas (con su hora de alquiler) que un usuario tiene alquiladas en una fecha concreta
     *
     * @return
     */
    @ApiOperation(value = "lisado de las pistas", response = Usuario.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Petición realizada correctamente", response = Usuario.class)}
    )
    @RequestMapping(value = "/pistasAlquiladas/{usuarioId}/{fecha}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<AlquilerPista>> getListadoPistasAlquiladasEnUnaFechaByUsuario(@PathVariable int usuarioId,
                                                                                             @PathVariable String fecha) {
        List alquilerPista = deportivasService.obtenerPistasAlquiladasPorUsuario(usuarioId, fecha);
        return new ResponseEntity<>(alquilerPista, HttpStatus.OK);
    }

    /**
     * borrar alquiler de pista de un usuario
     *
     * @param usuarioId
     * @param alquilerPista
     */
    @ApiOperation(value = "borrar alquiler de pista de un usuario", response = Usuario.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Petición realizada correctamente", response = Usuario.class)}
    )
    @RequestMapping(value = "/pistasAlquiladas/{usuarioId}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity borrarPistaAlquiladaPorUsuario(@PathVariable int usuarioId,
                                               @RequestBody AlquilerPista alquilerPista) {
        deportivasService.borrarPistaAlquiladaPorUsuario(alquilerPista, usuarioId);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * TOKEN
     *
     * @param userName
     * @param password
     */
    @RequestMapping(value = "/auth/login", method = RequestMethod.POST, produces = "application/json")
    public void obtenerTokenUsuario(@RequestBody String userName,
                                    @RequestBody String password) {
    }



}
