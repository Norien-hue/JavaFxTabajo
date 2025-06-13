package com.programacion.paint;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Programa extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage ventana){
        FXMLLoader loader = new FXMLLoader();
        try{
            Scene scene = new Scene(loader.load(ClassLoader.getSystemResourceAsStream("frmPaint.fxml")));

            ventana.setScene(scene);
            ventana.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    /*
    getClass().getResource("/java/resources/frmPaint.fxml")

    FXMLLoader loader = new FXMLLoader();
        try{
            Scene escena = new Scene(loader.load(ClassLoader.getSystemResourceAsStream("frmRobot.fxml")));
            ventana.setScene(escena);
            ventana.show();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
     */
}