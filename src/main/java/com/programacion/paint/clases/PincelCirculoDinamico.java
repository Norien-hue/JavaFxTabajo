package com.programacion.paint.clases;

public class PincelCirculoDinamico implements PincelCirculo{
    private int radio;

    PincelCirculoDinamico(int radio){
        if (radio<0){
            throw new IllegalArgumentException("El radio debe de ser positivo");
        }else{
            this.radio = radio;
        }
    }

    @Override
    public int getRadio() {
        return this.radio;
    }

    public void setRadio(int radio){
        if (radio<0){
            throw new IllegalArgumentException("El radio debe de ser positivo");
        }else{
            this.radio = radio;
        }
    }
}
