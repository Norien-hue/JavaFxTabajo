package com.programacion.paint.clases;

public class PincelGalletas extends PincelSpray{

    PincelGalletas() {
        super(new PincelEstrella(), 10, 200);
    }

    @Override
    public String toString() {
        return "Pincel Galletas";
    }
}
