package jc.guerrero.pista.deportivas.springpistasdeportivas.service;

import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.AlquilerPista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Pista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Rol;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Usuario;

import java.util.Date;
import java.util.List;

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
     * m�todo para obtener el listado de todas las pistas
     *
     * @return
     */
    List<Pista> getListadoTodasLasPistas();

    /**
     * m�todo para obtener las pistas por su tipo
     *
     * @return
     */
    List<Pista> getListaPistasPorTipo(String tipo);

    /**
     * m�todo para obtener la pista por su id concreta
     *
     * @param pistaId
     * @return
     */
    Pista getPistaConcretaPorId(int pistaId);

    /**
     * m�todo para que un usuario pueda alquilar una pista en una fecha y hora concreta
     *
     * @param alquilerPista
     */
    void alquilarPista(AlquilerPista alquilerPista);

    /**
     * m�todo para obtener las pistas que tiene un usuario alquiladas en una fecha concreta
     *
     * @param usuarioId
     * @return
     */
    List<AlquilerPista> obtenerPistasAlquiladasPorUsuario(int usuarioId, String fecha);

    /**
     * m�todo para borrar una pista que un usuario tenga alquilada
     *
     * @param alquilerPista
     * @param usuarioId
     */
    void borrarPistaAlquiladaPorUsuario(AlquilerPista alquilerPista, int usuarioId);
}
