package com.programacion.paint.controlador;

import com.programacion.paint.clases.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorFrmPaint implements Initializable {

    @FXML
    private BorderPane panel;

    @FXML
    private Button btnNuevo;

    @FXML
    private Button btnAbrir;

    @FXML
    private Button btnGuardar;

    @FXML
    private ImageView imgPinceles;

    @FXML
    private ComboBox<Pincel> cmbPinceles;

    @FXML
    private ColorPicker cpkColor;

    @FXML
    private Canvas cnvLienzo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicializarIconos();
        inicializarComboBox();
        nuevaImagen(null);
    }

    private void inicializarIconos() {
        try {

            Image iconoNuevo = new Image(getClass().getResourceAsStream("/icons/nuevo.png"));
            Image iconoAbrir = new Image(getClass().getResourceAsStream("/icons/abrir.png"));
            Image iconoGuardar = new Image(getClass().getResourceAsStream("/icons/guardar.png"));
            Image iconoPincel = new Image(getClass().getResourceAsStream("/icons/pincel.png"));


            ImageView imgNuevo = new ImageView(iconoNuevo);
            imgNuevo.setFitHeight(16);
            imgNuevo.setFitWidth(16);
            btnNuevo.setGraphic(imgNuevo);

            ImageView imgAbrir = new ImageView(iconoAbrir);
            imgAbrir.setFitHeight(16);
            imgAbrir.setFitWidth(16);
            btnAbrir.setGraphic(imgAbrir);

            ImageView imgGuardar = new ImageView(iconoGuardar);
            imgGuardar.setFitHeight(16);
            imgGuardar.setFitWidth(16);
            btnGuardar.setGraphic(imgGuardar);

            // Imagen para el ImageView de pinceles
            imgPinceles.setImage(iconoPincel);

        } catch (Exception e) {
            System.out.println("No se pudieron cargar los iconos: " + e.getMessage());
        }
    }

    private void inicializarComboBox() {
        // Obtener todos los pinceles de la enumeración TipoPincel
        cmbPinceles.getItems().addAll(TipoPincel.getPinceles());

        // Seleccionar el primer pincel por defecto
        if (!cmbPinceles.getItems().isEmpty()) {
            cmbPinceles.getSelectionModel().selectFirst();
        }
    }

    @FXML
    private void empezarDibujar(MouseEvent event) {
        Pincel pincelSeleccionado = cmbPinceles.getSelectionModel().getSelectedItem();

        if (pincelSeleccionado != null) {
            if (pincelSeleccionado instanceof Reseteable) {
                ((Reseteable) pincelSeleccionado).resetear();
            }

            dibujarPunto(event);
        }
    }

    @FXML
    private void dibujarPunto(MouseEvent event) {
        Pincel pincelSeleccionado = cmbPinceles.getSelectionModel().getSelectedItem();

        if (pincelSeleccionado != null) {
            GraphicsContext gc = cnvLienzo.getGraphicsContext2D();

            Punto punto = new Punto(event.getX(), event.getY());

            pincelSeleccionado.dibujar(gc, punto);
        }
    }

    @FXML
    private void nuevaImagen(ActionEvent event) {
        GraphicsContext gc = cnvLienzo.getGraphicsContext2D();

        javafx.scene.paint.Paint colorActual = gc.getFill();

        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, cnvLienzo.getWidth(), cnvLienzo.getHeight());

        gc.setFill(colorActual);
    }

    @FXML
    private void cambiarColor(ActionEvent event) {
        Color colorSeleccionado = cpkColor.getValue();

        if (colorSeleccionado != null) {
            GraphicsContext gc = cnvLienzo.getGraphicsContext2D();
            gc.setFill(colorSeleccionado);
            gc.setStroke(colorSeleccionado);
        }
    }

    @FXML
    private void abrirImagen(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir Imagen");

        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter(
                "Archivos de Imagen", "*.png", "*.jpg", "*.jpeg", "*.gif", "*.bmp");
        fileChooser.getExtensionFilters().add(imageFilter);

        Stage stage = (Stage) cnvLienzo.getScene().getWindow();
        File archivoSeleccionado = fileChooser.showOpenDialog(stage);

        if (archivoSeleccionado != null) {
            try {
                Image imagen = new Image(archivoSeleccionado.toURI().toString());

                GraphicsContext gc = cnvLienzo.getGraphicsContext2D();
                gc.drawImage(imagen, 0, 0);

            } catch (Exception e) {
                System.err.println("Error al cargar la imagen: " + e.getMessage());
            }
        }
    }

    @FXML
    private void guardarImagen(ActionEvent event) {
        try {
            javafx.geometry.Bounds boundsInLocal = cnvLienzo.getBoundsInLocal();
            javafx.geometry.Bounds boundsInScreen = cnvLienzo.localToScreen(boundsInLocal);

            Robot robot = new Robot();
            BufferedImage screenshot = robot.createScreenCapture(
                    new Rectangle(
                            (int) boundsInScreen.getMinX(),
                            (int) boundsInScreen.getMinY(),
                            (int) boundsInScreen.getWidth(),
                            (int) boundsInScreen.getHeight()
                    )
            );

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Guardar Imagen");

            FileChooser.ExtensionFilter pngFilter = new FileChooser.ExtensionFilter(
                    "Archivos PNG", "*.png");
            fileChooser.getExtensionFilters().add(pngFilter);
            fileChooser.setInitialFileName("dibujo.png");

            Stage stage = (Stage) cnvLienzo.getScene().getWindow();
            File archivoDestino = fileChooser.showSaveDialog(stage);

            if (archivoDestino != null) {
                ImageIO.write(screenshot, "png", archivoDestino);
                System.out.println("Imagen guardada: " + archivoDestino.getAbsolutePath());
            }

        } catch (AWTException | IOException e) {
            System.err.println("Error al guardar la imagen: " + e.getMessage());
        }
    }
}