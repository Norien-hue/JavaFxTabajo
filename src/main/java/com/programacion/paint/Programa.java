package com.programacion.paint;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Programa extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/java/resources/frmPaint.fxml"));
        Scene scene = new Scene(loader.load());

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}