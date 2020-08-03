package edu.fiuba.algo3.modelo;

public class ModalidadOrdenada implements Modalidad {
    @Override
    public int calcularPuntaje(Respuesta respuestaJugador,Respuesta respuestaCorrecta){

       if(respuestaCorrecta.tieneIgualOrdenA(respuestaJugador)){
           return 10;
       }
       return 0;

    }
}
