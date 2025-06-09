package com.programacion.paint.clases;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PincelEstrella implements Pincel{
    private static final Image ESTRELLA = null;

    @Override
    public void dibujar(GraphicsContext g, Punto p) {
        throw new UnsupportedOperationException("no programado");
    }

    PincelEstrella(){
        throw new UnsupportedOperationException("no programado");
    }
}
