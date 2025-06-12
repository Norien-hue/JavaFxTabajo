package com.programacion.paint.clases;

import org.junit.Test;

import static org.junit.Assert.*;
public class PuntoTest {
    @Test(expected = IllegalArgumentException.class)
    public void test1(){
        Punto p = new Punto(-3,25);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test2(){
        Punto p = new Punto(3,-25);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test3(){
        Punto p = new Punto(-3,-25);
    }
    @Test
    public void test4(){
        Punto p = new Punto(3,25);
        assertEquals(3, p.x());
        assertEquals(25, p.y());
    }
}