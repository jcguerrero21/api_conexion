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
     * método para insertar pistas deportivas
     *
     * @param pista
     */
    void insertPista(Pista pista);

    /**
     * método para obtener la última id de usuario existente
     *
     * @return
     */
    int getLastIdUsuarios();

    /**
     * método para obtener si hay algún usuario en la base de datos
     *
     * @return
     */
    int getHayUsuarios();

    /**
     * método para obtener la última id de pista existente
     *
     * @return
     */
    int getLastIdPistas();

    /**
     * método para obtener si hay alguna pista insertada
     *
     * @return
     */
    int getHayPistas();

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

    /**
     * método para insertar un alquiler de una pista en una fecha y una hora concreta
     *
     * @param alquilerPista
     */
    void alquilarPista(AlquilerPista alquilerPista);

    /**
     * método que devolverá un valor dependiendo de si una pista está disponible en una fecha y hora determinada o no
     *
     * @param alquilerPista
     * @return
     */
    int comprobarPistaDisponibleFechaHora(AlquilerPista alquilerPista);

    /**
     * método que nos devolvera las pistas que un usuario tiene alquiladas en una fecha que aún no ha expirado
     *
     * @param usuarioId
     * @return
     */
    List<AlquilerPista> getPistaAlquiladaByUsuario(int usuarioId, String fecha);

    /**
     * método para borrar el alquiler de una pista que ha hecho un usuario
     *
     * @param alquilerPista
     * @param usuario
     */
    void deleteAlquilerPista(AlquilerPista alquilerPista, int usuario);

    /**
     * método que nos devuelve si hay un usuario existente con esa nombre de usuario y esa contraseña
     *
     * @param userName
     * @param password
     * @return
     */
    int getUsuarioByNameAndPassword(String userName, String password);
}
