package jc.guerrero.pista.deportivas.springpistasdeportivas.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Juan Carlos on 26/09/2017.
 */
public class AlquilerPista implements Serializable {

    private Usuario id_usuario;
    private Pista id_pista;
    private Date fecha_reserva;
    private Horarios hora;

    public AlquilerPista() {
    }

    public AlquilerPista(Usuario id_usuario, Pista id_pista, Date fecha_reserva, Horarios hora) {
        this.id_usuario = id_usuario;
        this.id_pista = id_pista;
        this.fecha_reserva = fecha_reserva;
        this.hora = hora;
    }

    public Horarios getHora() {
        return hora;
    }

    public void setHora(Horarios hora) {
        this.hora = hora;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public AlquilerPista setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
        return this;
    }

    public Pista getId_pista() {
        return id_pista;
    }

    public AlquilerPista setId_pista(Pista id_pista) {
        this.id_pista = id_pista;
        return this;
    }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public AlquilerPista setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
        return this;
    }
}
