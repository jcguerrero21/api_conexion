package jc.guerrero.pista.deportivas.springpistasdeportivas.domain;

import java.io.Serializable;

/**
 * Created by Juan Carlos on 26/09/2017.
 */

public class Rol implements Serializable {

    public static final String TIPO_ROL_ADMIN = "administrador";
    public static final String TIPO_ROL_USUARIO = "usuario";

    private int id;
    private String nombre;

    public Rol(){
    }

    public Rol(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    public int getId() {
        return id;
    }

    public Rol setId(int id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Rol setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
}
