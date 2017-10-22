package jc.guerrero.pista.deportivas.springpistasdeportivas.dao;

import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.AlquilerPista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Pista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Rol;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Usuario;

import java.util.List;


/**
 * Created by Juan Carlos on 26/09/2017.
 */
public interface DeportivasDao {

    /**
     * metodo para insertar usuarios
     *
     * @param usuario
     */
    void insertUsuario(Usuario usuario);

    /**
     * metodo para insertar roles
     *
     * @param rol
     */
    void insertRol(Rol rol);

    /**
     * método para insertar pistas deportivas
     *
     * @param pista
     */
    void insertPista(Pista pista);

    /**
     * método para insertar la fecha y hora de alquiler de las pistas
     *
     * @param alquilerPista
     */
    void insertFechaAqlquiler(AlquilerPista alquilerPista);

    /**
     * método para obtener la última id de usuario existente
     *
     * @return
     */
    int getLastIdUsuarios();

    /**
     * método para obtener la última id de pista existente
     *
     * @return
     */
    int getLastIdPistas();

    /**
     * método para obtener el listado de todas las pistas
     *
     * @return
     */
    List<Pista> getAllListaPistas();

    /**
     * método para obtener las pistas por su tipo
     *
     * @return
     */
    List<Pista> getListaPistasByTipo(String tipo);

    /**
     * método para obtener la pista por su id concreta
     *
     * @param pistaId
     * @return
     */
    Pista getPistaById(int pistaId);
}
