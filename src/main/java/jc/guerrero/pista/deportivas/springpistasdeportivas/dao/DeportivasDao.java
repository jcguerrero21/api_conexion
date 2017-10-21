package jc.guerrero.pista.deportivas.springpistasdeportivas.dao;

import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.AlquilerPista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Pista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Rol;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Usuario;


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
}
