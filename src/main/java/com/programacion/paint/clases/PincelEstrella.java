package com.programacion.paint.clases;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.InputStream;

public class PincelEstrella implements Pincel{
    private static final Image ESTRELLA = new Image(ClassLoader.getSystemResourceAsStream("estrella.png"));

    @Override
    public void dibujar(GraphicsContext g, Punto p) {
        g.drawImage(ESTRELLA, p.x(), p.y());
    }

    PincelEstrella() {
    }

    @Override
    public String toString() {
        return "Pincel estrella";
    }
}