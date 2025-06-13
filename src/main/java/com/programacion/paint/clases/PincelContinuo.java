package com.programacion.paint.clases;

import javafx.scene.canvas.GraphicsContext;

public class PincelContinuo extends PincelBasico implements Reseteable{
    private Punto puntoPrevio;

    PincelContinuo(){
        this.puntoPrevio = null;
    }

    @Override
    public void resetear() {
        this.puntoPrevio = null;
    }

    @Override
    public void dibujar(GraphicsContext g, Punto p) {
        if (this.puntoPrevio == null){
            double radio = getRadio();
            g.fillOval(p.x() - radio, p.y() - radio, radio * 2, radio * 2);
            this.puntoPrevio = p;
        }else{
            g.strokeLine(this.puntoPrevio.x(), this.puntoPrevio.y(), p.x(), p.y());
            this.puntoPrevio = p;
        }
    }

    @Override
    public String toString() {
        return "Pincel continuo";
    }
}
