package com.programacion.paint.clases;

public class PincelContinuo extends PincelBasico implements Reseteable{
    private Punto puntoPrevio;

    PincelContinuo(){
        throw new UnsupportedOperationException("no programado");
    }

    @Override
    public void resetear() {
        throw new UnsupportedOperationException("no programado");
    }
}
