package com.programacion.paint.clases;

import javafx.scene.canvas.GraphicsContext;

public class PincelRectangulo implements Pincel{
    @Override
    public void dibujar(GraphicsContext g, Punto p) {
        g.fillRect(p.x(), p.y(), 20, 20);
    }

    PincelRectangulo() {
    }

    @Override
    public String toString() {
        return "Pincel rectangular";
    }
}