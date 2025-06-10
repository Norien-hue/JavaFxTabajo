package com.programacion.paint.clases;

import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

public class PincelGrosorVariable extends PincelCirculoDinamico{
    private int radioMinimo;
    private int radioMaximo;


    PincelGrosorVariable(int min, int max) {
        super(min);
        if (min<0 || max<0){
            throw new IllegalArgumentException("Los radios debe de ser positivo");
        }else{
            this.radioMaximo = max;
            this.radioMinimo = min;
        }
    }

    @Override
    public void setRadio(int radio) {
        if (radio<radioMinimo || radio>radioMaximo){
            throw new IllegalArgumentException("El radio debe estar comperndido entre "+this.radioMinimo+" y "+this.radioMaximo);
        }else{
            super.setRadio(radio);
        }
    }

    public int getRadioMinimo(){
        return this.radioMinimo;
    }

    public int getRadioMaximo(){
        return this.radioMaximo;
    }

    @Override
    public void dibujar(GraphicsContext g, Punto p) {
        this.setRadio(new Random().nextInt(this.radioMinimo, this.radioMaximo));
        super.dibujar(g, p);
    }

    @Override
    public String toString() {
        return "Pincel de grosor variable";
    }
}
