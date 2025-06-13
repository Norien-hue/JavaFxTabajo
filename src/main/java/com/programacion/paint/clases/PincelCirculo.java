package com.programacion.paint.clases;

import javafx.scene.canvas.GraphicsContext;

public interface PincelCirculo extends Pincel{
    public int getRadio();
    public default void dibujar(GraphicsContext g, Punto p) {
        double radio = getRadio();
        g.fillOval(p.x() - radio, p.y() - radio, radio*2, radio*2);
    }
}
