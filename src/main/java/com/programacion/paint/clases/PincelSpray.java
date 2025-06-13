package com.programacion.paint.clases;

import javafx.scene.canvas.GraphicsContext;

import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class PincelSpray extends PincelCirculoDinamico{
    private Pincel pincel;
    private int densidad;

    PincelSpray(Pincel p, int r, int d) {
        super(r);
        this.pincel = p;
        this.densidad =d;
    }

    @Override
    public void dibujar(GraphicsContext g, Punto p) {
        IntStream.range(0, densidad)
                .forEach(i -> {
                    int r = new Random().nextInt(this.getRadio()) + 1;
                    double gr = new Random().nextDouble() * 360;

                    double a = Math.toRadians(gr);
                    g.fillOval(p.x() + r * cos(a), p.y() + r * sin(a), this.getRadio()*2, this.getRadio()*2);
                });
    }
}
