package jc.guerrero.pista.deportivas.springpistasdeportivas.service;

import jc.guerrero.pista.deportivas.springpistasdeportivas.dao.DeportivasDao;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.AlquilerPista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Pista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Rol;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Juan Carlos on 26/09/2017.
 */
@Service
public class DeportivasManager implements DeportivasService {

    @Autowired
    private DeportivasDao deporDao;

    public void insertarUsuario(Usuario usuario) {
        deporDao.insertUsuario(usuario);
    }

    public void insertarRole(Rol rol) {
        deporDao.insertRol(rol);
    }

    public void insertarPista(Pista pista){
        deporDao.insertPista(pista);
    }

    public void insertarFechaAlquiler(AlquilerPista alquilerPista){
        deporDao.insertFechaAqlquiler(alquilerPista);
    }

}
