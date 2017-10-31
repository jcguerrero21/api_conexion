package jc.guerrero.pista.deportivas.springpistasdeportivas.web;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jc.guerrero.pista.deportivas.springpistasdeportivas.security.JwtUtil;
import jc.guerrero.pista.deportivas.springpistasdeportivas.security.LoginFilter;
import jc.guerrero.pista.deportivas.springpistasdeportivas.security.SecurityConfig;
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
    @ApiOperation(value = "Insertar Usuarios", response = Usuario.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Petición realizada correctamente", response = AlquilerPista.class)}
    )
    @RequestMapping(value = "/insertarUsuario", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity insertarUsuario(@RequestBody Usuario usuario, HttpServletRequest request) {
        deportivasService.insertarUsuario(usuario);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Insertar Roles
     *
     * @param rol
     */
    @ApiOperation(value = "Insertar Roles", response = Rol.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Petición realizada correctamente", response = Rol.class)}
    )
    @RequestMapping(value = "/insertarRol", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity insertarRol(@RequestBody Rol rol) {
        deportivasService.insertarRole(rol);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Insertar Pista
     *
     * @param pista
     */
    @ApiOperation(value = "Insertar Pista", response = Pista.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Petición realizada correctamente", response = Pista.class)}
    )
    @RequestMapping(path = "/insertarPista", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity insertarPista(@RequestBody Pista pista) {
        deportivasService.insertarPista(pista);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Alquilar Pista
     *
     * @param alquilerPista
     */
    @ApiOperation(value = "Insertar el alquiler de una pista", response = AlquilerPista.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Petición realizada correctamente", response = AlquilerPista.class)}
    )
    @RequestMapping(path = "/alquilerPista", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity alquilarPista(@RequestBody AlquilerPista alquilerPista) {
        deportivasService.alquilarPista(alquilerPista);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * listar todas las pistas
     *
     * @return
     */
    @ApiOperation(value = "listado de todas las pistas que hay", response = Pista.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Petición realizada correctamente", response = Pista.class)}
    )
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
    @ApiOperation(value = "listado de todas las pistas que hay por su tipo", response = Pista.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Petición realizada correctamente", response = Pista.class)}
    )
    @RequestMapping(value = "/pistasTipo/{tipo}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Pista>> getListadoPistasPorTipo(@PathVariable String tipo) {
        List pistatipo = deportivasService.getListaPistasPorTipo(tipo);
        return new ResponseEntity<>(pistatipo, HttpStatus.OK);
    }

    /**
     * listar una pista concreta por si id
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "listado de una pista concreta por su id", response = Pista.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Petición realizada correctamente", response = Pista.class)}
    )
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
    @ApiOperation(value = "lisado de las pistas que un usuario tiene alquiladas", response = AlquilerPista.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Petición realizada correctamente", response = AlquilerPista.class)}
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
    @ApiOperation(value = "borrar alquiler de pista de un usuario", response = AlquilerPista.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Petición realizada correctamente", response = AlquilerPista.class)}
    )
    @RequestMapping(value = "/pistasAlquiladas/{usuarioId}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity borrarPistaAlquiladaPorUsuario(@PathVariable int usuarioId,
                                                         @RequestBody AlquilerPista alquilerPista) {
        deportivasService.borrarPistaAlquiladaPorUsuario(alquilerPista, usuarioId);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * TOKEN
     */
    @ApiOperation(value ="Obtener el token", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Petición realizada correctamente", response = AlquilerPista.class)}
    )
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public void obtenerTokenUsuario() {
        //Si estamos probando desde postman o alguna aplicacio similar, nos vamos al apartado headers y ahi aparecerá nuesro token donde pone authorization
    }


}
