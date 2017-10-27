package jc.guerrero.pista.deportivas.springpistasdeportivas.service;

import jc.guerrero.pista.deportivas.springpistasdeportivas.dao.DeportivasDao;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.AlquilerPista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Pista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Rol;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Juan Carlos on 26/09/2017.
 */
@Service
public class DeportivasManager implements DeportivasService {

    @Autowired
    private DeportivasDao deporDao;

    public void insertarUsuario(Usuario usuario) {
        //comprobamos si hay algun usuario insertado y si no lo hay le pasamos la id a 1
        if (deporDao.getHayUsuarios() == 0){
            usuario.setId(1);
            deporDao.insertUsuario(usuario);
        } else { //creamos una variable para ir aumentando la id del usuario
            int usuarioId = deporDao.getLastIdUsuarios();
            usuario.setId(usuarioId + 1);
            deporDao.insertUsuario(usuario);
        }
    }

    public void insertarRole(Rol rol) {
        deporDao.insertRol(rol);
    }

    public void insertarPista(Pista pista) {
        //comprobamos si hay alguna pista insertada y si no lo hay le pasamos la id a 1
        if (deporDao.getHayPistas() == 0){
            pista.setId(1);
            deporDao.insertPista(pista);
        } else { //si la hay creamos una variable que nos devuelva la ultima id de la pista y le aumentamos +1
            int pistaId = deporDao.getLastIdUsuarios();
            pista.setId(pistaId + 1);
            deporDao.insertPista(pista);
        }
    }

    public List<Pista> getListadoTodasLasPistas() {
        return deporDao.getAllListaPistas();
    }

    public List<Pista> getListaPistasPorTipo(String tipo) {
        return deporDao.getListaPistasByTipo(tipo);
    }

    public Pista getPistaConcretaPorId(int pistaId) {
        return deporDao.getPistaById(pistaId);
    }

    public void alquilarPista(AlquilerPista alquilerPista) {
        //comprobamos si podemos alquilar esa pista, que no este alquilada ya por alguien en la misma fecha y hora
        int horaId = UtilidadesDeportivas.convertirHorasTipoStrToInt(alquilerPista.getHora().getHora()); //Con este método conseguimos pasar el String de la hora que nos venga con su id correspondiente
        alquilerPista.getHora().setId(horaId);
        if(deporDao.comprobarPistaDisponibleFechaHora(alquilerPista) > 0) {
            System.out.println("Esa pista ya esta cogido en esa fecha y hora concretas");
        } else {
            deporDao.alquilarPista(alquilerPista);
        }
    }

    public List<AlquilerPista> obtenerPistasAlquiladasPorUsuario(int usuarioId, String fecha){
        return deporDao.getPistaAlquiladaByUsuario(usuarioId, fecha);
    }

    public void borrarPistaAlquiladaPorUsuario(AlquilerPista alquilerPista, int usuarioId){
        int horaId = UtilidadesDeportivas.convertirHorasTipoStrToInt(alquilerPista.getHora().getHora());
        alquilerPista.getHora().setId(horaId);
        deporDao.deleteAlquilerPista(alquilerPista, usuarioId);
    }

}
