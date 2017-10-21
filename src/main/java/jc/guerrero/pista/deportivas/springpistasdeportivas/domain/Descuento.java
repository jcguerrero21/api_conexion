package jc.guerrero.pista.deportivas.springpistasdeportivas.domain;

import java.io.Serializable;

/**
 * Created by Juan Carlos on 26/09/2017.
 */
public class Descuento implements Serializable {

    private int id;
    private String tipo;
    private String codigo;
    private Usuario id_usuario;

    public Descuento() {
    }

    public Descuento(int id, String tipo, String codigo, Usuario id_usuario) {
        super();
        this.id = id;
        this.tipo = tipo;
        this.codigo = codigo;
        this.id_usuario = id_usuario;
    }

    public int getId() {
        return id;
    }

    public Descuento setId(int id) {
        this.id = id;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public Descuento setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public String getCodigo() {
        return codigo;
    }

    public Descuento setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public Descuento setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
        return this;
    }
}
