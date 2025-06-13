package com.programacion.paint.test;

import com.programacion.paint.clases.Pincel;
import com.programacion.paint.clases.Punto;
import javafx.scene.canvas.GraphicsContext;

public class LineaDiagonal {
    private Pincel pincel;

    public LineaDiagonal(Pincel p){
        this.pincel = p;
    }

    public void dibujarLinea(GraphicsContext g){
        double alto = g.getCanvas().getHeight();
        double ancho = g.getCanvas().getWidth();

        int min = alto>ancho? (int)ancho / 20 : (int)alto / 20;
        for(int i = 0; i<min; i++){
            pincel.dibujar(g, new Punto(i*20, i*20));
        }
    }
}
