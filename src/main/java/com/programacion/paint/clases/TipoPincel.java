package com.programacion.paint.clases;

import java.util.List;

public enum TipoPincel {

    PINCEL_BASICO(new PincelBasico()),
    PINCEL_GORDO(new PincelGordo()),
    PINCEL_GROSOR_VARIABLE(new PincelGrosorVariable(2, 20)),
    PINCEL_CONTINUO(new PincelContinuo()),
    PINCEL_RECTANGULO(new PincelRectangulo()),
    PINCEL_ESTRELLA(new PincelEstrella()),
    PINCEL_SPRAY(new PincelSpray(new PincelGrosorVariable(2, 15), 70, 15)),
    PINCEL_CONSTELACION(new PincelSpray(new PincelEstrella(), 70, 15));


    private Pincel pincel;

    private TipoPincel(Pincel p){
        this.pincel = p;
    }

    public Pincel getPincel(){
        return this.pincel;
    }

    public static List<Pincel> getPinceles(){
        return List.of(
                TipoPincel.PINCEL_BASICO.getPincel(),
                TipoPincel.PINCEL_GORDO.getPincel(),
                TipoPincel.PINCEL_GROSOR_VARIABLE.getPincel(),
                TipoPincel.PINCEL_CONTINUO.getPincel(),
                TipoPincel.PINCEL_RECTANGULO.getPincel(),
                TipoPincel.PINCEL_ESTRELLA.getPincel(),
                TipoPincel.PINCEL_SPRAY.getPincel(),
                TipoPincel.PINCEL_CONSTELACION.getPincel()
        );
    }
}
