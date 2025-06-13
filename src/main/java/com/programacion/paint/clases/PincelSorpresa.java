package com.programacion.paint.clases;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class PincelSorpresa implements Pincel{

    PincelSorpresa(){
    }

    @Override
    public String toString() {
        return "Pincel Sorpresa";
    }

    private Pincel getPincelAleatorio(){

        List<TipoPincel> pinceles = Arrays.stream(TipoPincel.values())
                .filter(tipo -> !esExcluido(tipo))
                .collect(java.util.stream.Collectors.toList());

        // Elegir uno aleatoriamente usando programación funcional
        return pinceles.stream()
                .skip(new Random().nextInt(pinceles.size()))
                .findFirst()
                .map(TipoPincel::getPincel)
                .orElse(new PincelBasico()); // Fallback por seguridad
    }

    //Método auxiliar para filtrar pinceles
    private boolean esExcluido(TipoPincel tipo) {
        String nombre = tipo.toString().toLowerCase();
        return nombre.contains("constelacion") ||
                nombre.contains("sorpresa") ||
                nombre.contains("continuo") ||
                nombre.contains("psicodelico");
    }

    @Override
    public void dibujar(GraphicsContext g, Punto p) {
        Supplier<Pincel> pincelSupplier = this::getPincelAleatorio;
        pincelSupplier.get().dibujar(g, p);
    }
}
