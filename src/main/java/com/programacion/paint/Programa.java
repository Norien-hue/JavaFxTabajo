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
    public void start(Stage vtn){
        try{
            FXMLLoader cargador = new FXMLLoader();
            Scene scene =new Scene(
                    cargador.load(ClassLoader.getSystemResourceAsStream("frmPaint.fxml"))
            );
            vtn.setScene(scene);
            vtn.show();
        }catch (IOException error){
            System.out.println(error.getMessage());
        }

    }
}