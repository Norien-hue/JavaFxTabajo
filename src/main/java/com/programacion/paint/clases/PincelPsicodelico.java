package com.programacion.paint.clases;

import javafx.scene.canvas.GraphicsContext;

import java.awt.*;
import java.util.Random;

public class PincelPsicodelico extends PincelSorpresa{
    PincelPsicodelico(){
    }

    @Override
    public String toString() {
        return "Pincel Psicodélico";
    }

    private Color getColorAleatorio(){
        int[] rgb = new Random().ints(3, 0, 255).toArray();
        return Color.getHSBColor((float)rgb[0] ,(float)rgb[1], (float)rgb[2]);
    }

    @Override
    public void dibujar(GraphicsContext g, Punto p) {

        javafx.scene.paint.Paint colorOriginal = g.getFill();

        g.setFill(this.getColorAleatorio());

        super.dibujar(g, p);
    }
}
