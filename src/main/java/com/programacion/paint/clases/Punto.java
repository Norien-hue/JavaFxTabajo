package com.programacion.paint.clases;

public record Punto(double x, double y) {
    public Punto{
        if (this.x()<0 || this.y()<0){
            throw new IllegalArgumentException();
        }
    }
}
