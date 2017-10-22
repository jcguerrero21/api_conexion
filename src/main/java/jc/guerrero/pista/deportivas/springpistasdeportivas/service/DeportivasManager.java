package jc.guerrero.pista.deportivas.springpistasdeportivas.service;

import jc.guerrero.pista.deportivas.springpistasdeportivas.dao.DeportivasDao;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.AlquilerPista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Pista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Rol;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Juan Carlos on 26/09/2017.
 */
@Service
public class DeportivasManager implements DeportivasService {

    @Autowired
    private DeportivasDao deporDao;

    public void insertarUsuario(Usuario usuario) {
        //creamos una variable para ir aumentando la id del usuario
        int usuarioId = deporDao.getLastIdUsuarios();
        usuario.setId(usuarioId+1);
        deporDao.insertUsuario(usuario);
    }

    public void insertarRole(Rol rol) {
        deporDao.insertRol(rol);
    }

    public void insertarPista(Pista pista){
        //creamos una variable para ir aumentando la id de la pista usuario
        pista.setId_pista(deporDao.getLastIdPistas()+1);
        deporDao.insertPista(pista);
    }

    public void insertarFechaAlquiler(AlquilerPista alquilerPista){
        deporDao.insertFechaAqlquiler(alquilerPista);
    }

    public List<Pista> getListadoTodasLasPistas(){
        return deporDao.getAllListaPistas();
    }

    public List<Pista> getListaPistasPorTipo(String tipo){
        return deporDao.getListaPistasByTipo(tipo);
    }

    public Pista getPistaConcretaPorId(int pistaId){
        return deporDao.getPistaById(pistaId);
    }

}
