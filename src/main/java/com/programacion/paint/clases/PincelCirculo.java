package com.programacion.paint.clases;

import javafx.scene.canvas.GraphicsContext;

public interface PincelCirculo extends Pincel{
    public int getRadio();
    public default void dibujar(GraphicsContext g, Punto p) {
        throw new UnsupportedOperationException("no programado");
    }
}
