package jc.guerrero.pista.deportivas.springpistasdeportivas.service;

import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.AlquilerPista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Pista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Rol;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Usuario;

/**
 * Created by Juan Carlos on 26/09/2017.
 */
public interface DeportivasService {

    /**
     * m�todo para insertar usuarios
     *
     * @param usuario
     */
    void insertarUsuario(Usuario usuario);

    /**
     * m�todo para insertar roles
     *
     * @param rol
     */
    void insertarRole(Rol rol);

    /**
     * m�todo para insertar pistas deportivas
     *
     * @param pista
     */
    void insertarPista(Pista pista);

    /**
     * m�todo para insertar la fecha de alquiler de la pista
     *
     * @param alquilerPista
     */
    void insertarFechaAlquiler(AlquilerPista alquilerPista);
}
