package jc.guerrero.pista.deportivas.springpistasdeportivas.domain;

import java.io.Serializable;

/**
 * Created by Juan Carlos on 26/09/2017.
 */

public class Pista implements Serializable {

    private int id_pista;
    private String nombre;
    private String ubicacion;
    private String Tipo;

    public Pista() {
    }

    public Pista(int id_pista, String nombre, String ubicacion, String tipo) {
        this.id_pista = id_pista;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        Tipo = tipo;
    }

    public int getId_pista() {
        return id_pista;
    }

    public Pista setId_pista(int id_pista) {
        this.id_pista = id_pista;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Pista setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public Pista setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
        return this;
    }

    public String getTipo() {
        return Tipo;
    }

    public Pista setTipo(String tipo) {
        Tipo = tipo;
        return this;
    }
}
