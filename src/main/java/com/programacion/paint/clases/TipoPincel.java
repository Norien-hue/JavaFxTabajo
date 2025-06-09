package com.programacion.paint.clases;

import java.util.List;

public enum TipoPincel {
    PINCEL_BASICO,PINCEL_GORDO, PINCEL_GROSOR_VARIABLE, PINCEL_CONTINUO, PINCEL_RECTANGULO, PINCEL_ESTRELLA;

    private Pincel pincel;

    private TipoPincel(Pincel p){
        throw new UnsupportedOperationException("no programado");
    }

    public Pincel getPincel(){
        throw new UnsupportedOperationException("no programado");
    }

    public static List<Pincel> getPinceles(){
        throw new UnsupportedOperationException("no programado");
    }
}
