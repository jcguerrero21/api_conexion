package jc.guerrero.pista.deportivas.springpistasdeportivas.domain;

import java.io.Serializable;
import java.sql.Time;

public class Horarios implements Serializable{

    public final static String HORA_10 = "10:00:00";
    public final static String HORA_11 = "11:00:00";
    public final static String HORA_12 = "12:00:00";
    public final static String HORA_13 = "13:00:00";
    public final static String HORA_14 = "14:00:00";
    public final static String HORA_17 = "17:00:00";
    public final static String HORA_18 = "18:00:00";
    public final static String HORA_19 = "19:00:00";
    public final static String HORA_20 = "20:00:00";
    public final static String HORA_21 = "21:00:00";

    public final static int HORA_10_ID = 1;
    public final static int HORA_11_ID = 2;
    public final static int HORA_12_ID = 3;
    public final static int HORA_13_ID = 4;
    public final static int HORA_14_ID = 5;
    public final static int HORA_17_ID = 6;
    public final static int HORA_18_ID = 7;
    public final static int HORA_19_ID = 8;
    public final static int HORA_20_ID = 9;
    public final static int HORA_21_ID = 10;

    private int id;
    private String hora;

    public Horarios(){
    }

    public Horarios(int id, String hora) {
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

    public String getHora() {
        return hora;
    }

    public Horarios setHora(String hora) {
        this.hora = hora;
        return this;
    }
}
