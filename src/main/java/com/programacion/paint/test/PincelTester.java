package com.programacion.paint.test;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PincelTester extends Application {

    // 1. Definir la interfaz para los pinceles
    public interface TipoPinceI {
        void dibujarLinea(GraphicsContext gc, double x1, double y1, double x2, double y2);
    }

    // 2. Pincel de prueba (cambiar por el pincel deseado)
    public static final TipoPinceI TIPO_PINCEL = (gc, x1, y1, x2, y2) -> {
        gc.setStroke(Color.BLACK); // Usa el color configurado previamente
        gc.setLineWidth(1);        // Grosor por defecto
        gc.strokeLine(x1, y1, x2, y2);
    };

    public static void main(String[] args) {
        launch(args); // Inicia la aplicación JavaFX
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Configuración del Canvas
        Canvas canvas = new Canvas(400, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Configuración del contenedor
        StackPane root = new StackPane();
        root.getChildren().add(canvas);

        // Configuración de la escena
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Probador de Pinceles");

        // Configurar color de relleno (como indica el requerimiento)
        gc.setFill(Color.BLACK);

        primaryStage.show();

        // Dibujar después de mostrar la ventana
        Platform.runLater(() -> {
            dibujarDiagonal(gc);
        });
    }

    // Método auxiliar para dibujar la diagonal
    private void dibujarDiagonal(GraphicsContext gc) {
        TIPO_PINCEL.dibujarLinea(gc, 0, 0, 400, 400);
    }
}