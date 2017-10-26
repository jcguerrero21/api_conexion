package jc.guerrero.pista.deportivas.springpistasdeportivas.dao;

import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.AlquilerPista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Pista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Rol;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Usuario;

import java.util.Date;
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
     * m�todo para insertar pistas deportivas
     *
     * @param pista
     */
    void insertPista(Pista pista);

    /**
     * m�todo para obtener la �ltima id de usuario existente
     *
     * @return
     */
    int getLastIdUsuarios();

    /**
     * m�todo para obtener la �ltima id de pista existente
     *
     * @return
     */
    int getLastIdPistas();

    /**
     * m�todo para obtener el listado de todas las pistas
     *
     * @return
     */
    List<Pista> getAllListaPistas();

    /**
     * m�todo para obtener las pistas por su tipo
     *
     * @return
     */
    List<Pista> getListaPistasByTipo(String tipo);

    /**
     * m�todo para obtener la pista por su id concreta
     *
     * @param pistaId
     * @return
     */
    Pista getPistaById(int pistaId);

    /**
     * m�todo para insertar un alquiler de una pista en una fecha y una hora concreta
     *
     * @param alquilerPista
     */
    void alquilarPista(AlquilerPista alquilerPista);

    /**
     * m�todo que devolver� un valor dependiendo de si una pista est� disponible en una fecha y hora determinada o no
     *
     * @param alquilerPista
     * @return
     */
    int comprobarPistaDisponibleFechaHora(AlquilerPista alquilerPista);

    /**
     * m�todo que nos devolvera las pistas que un usuario tiene alquiladas en una fecha que a�n no ha expirado
     *
     * @param usuarioId
     * @return
     */
    List<AlquilerPista> getPistaAlquiladaByUsuario(int usuarioId, String fecha);

    //void deleteAlquilerPista(AlquilerPista alquilerPista);
}
