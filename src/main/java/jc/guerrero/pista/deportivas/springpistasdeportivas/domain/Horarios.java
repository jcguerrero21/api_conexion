package jc.guerrero.pista.deportivas.springpistasdeportivas.domain;

import java.io.Serializable;
import java.sql.Time;

public class Horarios implements Serializable{

    private int id;
    private Time hora;

    public Horarios(){
    }

    public Horarios(int id, Time hora) {
        this.id = id;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public Horarios setId(int id) {
        this.id = id;
        return this;
    }

    public Time getHora() {
        return hora;
    }

    public Horarios setHora(Time hora) {
        this.hora = hora;
        return this;
    }
}
