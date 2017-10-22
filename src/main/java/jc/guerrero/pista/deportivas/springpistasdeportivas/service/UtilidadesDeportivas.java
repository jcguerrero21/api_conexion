package jc.guerrero.pista.deportivas.springpistasdeportivas.service;

import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Horarios;

public class UtilidadesDeportivas {

    public static final String[] HORAS = new String[]{Horarios.HORA_10, Horarios.HORA_11, Horarios.HORA_12, Horarios.HORA_13, Horarios.HORA_14,
            Horarios.HORA_17, Horarios.HORA_18, Horarios.HORA_19, Horarios.HORA_20, Horarios.HORA_21};

    public static final Integer[] HORAS_ID = new Integer[]{Horarios.HORA_10_ID, Horarios.HORA_11_ID, Horarios.HORA_12_ID, Horarios.HORA_13_ID,
            Horarios.HORA_14_ID, Horarios.HORA_17_ID, Horarios.HORA_18_ID, Horarios.HORA_19_ID, Horarios.HORA_20_ID, Horarios.HORA_21_ID};

    //Hacemos un método para convertir el String de la hora a la id correspondiente
    public static int convertirHorasTipoStrToInt(String horaString) {
        int horaId = 0;

        for (int i = 0; i < HORAS.length && horaId == 0; i++) {
            if (HORAS[i].equals(horaString)){
                return HORAS_ID[i];
            }
        }

        return horaId;
    }

}
