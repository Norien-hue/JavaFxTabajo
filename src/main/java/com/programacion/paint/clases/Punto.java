package com.programacion.paint.clases;

public record Punto(double x, double y) {
    public Punto{
        if(x<0 || y<0){
            throw new IllegalArgumentException("Los parametros deben ser mayor o iguales a cero");
        }
    }

}
