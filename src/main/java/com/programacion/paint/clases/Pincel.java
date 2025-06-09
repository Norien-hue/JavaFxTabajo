package com.programacion.paint.clases;

import javafx.scene.canvas.GraphicsContext;

public interface Pincel {
    public void dibujar(GraphicsContext g, Punto p);
}
