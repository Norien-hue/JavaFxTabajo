package com.programacion.paint.clases;

import javafx.scene.canvas.GraphicsContext;

public class PincelRectangulo implements Pincel{
    @Override
    public void dibujar(GraphicsContext g, Punto p) {
        this.dibujar(g, new Punto(10 , 10));
    }

    PincelRectangulo() {
    }

    @Override
    public String toString() {
        return "Pincel rectangular";
    }
}
