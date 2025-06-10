package com.programacion.paint.clases;

public class PincelBasico implements PincelCirculo{
    public static final int RADIO = 1;

    PincelBasico(){
    }

    @Override
    public int getRadio() {
        return RADIO;
    }

    @Override
    public String toString() {
        return "Pincel básico";
    }
}
