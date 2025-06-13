package com.programacion.paint.controlador;

import com.programacion.paint.clases.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
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

            Image icN = new Image(getClass().getResourceAsStream("icons/nuevo.png"));
            Image icA = new Image(getClass().getResourceAsStream("icons/abrir.png"));
            Image icG = new Image(getClass().getResourceAsStream("icons/guardar.png"));
            Image icP = new Image(getClass().getResourceAsStream("icons/pincel.png"));


            ImageView imgN = new ImageView(icN);
            imgN.setFitHeight(16);
            imgN.setFitWidth(16);
            btnNuevo.setGraphic(imgN);

            ImageView imgA = new ImageView(icA);
            imgA.setFitHeight(16);
            imgA.setFitWidth(16);
            btnAbrir.setGraphic(imgA);

            ImageView imgG = new ImageView(icG);
            imgG.setFitHeight(16);
            imgG.setFitWidth(16);
            btnGuardar.setGraphic(imgG);
            imgPinceles.setImage(icP);

        } catch (Exception e) {
            System.out.println("No se pudieron cargar los iconos: " + e.getMessage());
        }
    }

    private void inicializarComboBox() {
        cmbPinceles.getItems().addAll(TipoPincel.getPinceles());

        if (!cmbPinceles.getItems().isEmpty()) {
            cmbPinceles.getSelectionModel().selectFirst();
        }
    }

    @FXML
    private void empezarDibujar(MouseEvent event) {
        Pincel seleccionPincel = cmbPinceles.getSelectionModel().getSelectedItem();

        if (seleccionPincel != null) {
            if (seleccionPincel instanceof Reseteable) {
                ((Reseteable) seleccionPincel).resetear();
            }

            dibujarPunto(event);
        }
    }

    @FXML
    private void dibujarPunto(MouseEvent event) {
        Pincel seleccionPincel = cmbPinceles.getSelectionModel().getSelectedItem();

        if (seleccionPincel != null) {
            GraphicsContext gc = cnvLienzo.getGraphicsContext2D();

            Punto pnt = new Punto(event.getX(), event.getY());

            seleccionPincel.dibujar(gc, pnt);
        }
    }

    @FXML
    private void nuevaImagen(ActionEvent event) {
        GraphicsContext graphics = cnvLienzo.getGraphicsContext2D();

        javafx.scene.paint.Paint colorRelleno = graphics.getFill();

        graphics.setFill(Color.WHITE);
        graphics.fillRect(0, 0, cnvLienzo.getWidth(), cnvLienzo.getHeight());

        graphics.setFill(colorRelleno);
    }

    @FXML
    private void cambiarColor(ActionEvent event) {
        Color seleccionColor = cpkColor.getValue();

        if (seleccionColor != null) {
            GraphicsContext graphics = cnvLienzo.getGraphicsContext2D();
            graphics.setFill(seleccionColor);
        }
    }

    @FXML
    private void abrirImagen(ActionEvent event) {
        FileChooser seleccionador = new FileChooser();
        seleccionador.setTitle("Abrir Img");

        File file = seleccionador.showOpenDialog(panel.getScene().getWindow());

        if (file != null) {
            try {
                Image image = new Image(file.toURI().toString());

                GraphicsContext gc = cnvLienzo.getGraphicsContext2D();

                gc.clearRect(0, 0, cnvLienzo.getWidth(), cnvLienzo.getHeight());

                gc.drawImage(image, 0, 0);

            } catch (Exception e) {
                System.out.println("Error al cargar la imagen: " + e.getMessage());
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("El archivo seleccionado no es una imagen válida.");
                alert.show();
            }
        }
    }

    @FXML
    private void guardarImagen(ActionEvent event) {
        try {
            javafx.geometry.Bounds dimCanvas = cnvLienzo.getBoundsInLocal();
            javafx.geometry.Bounds coordenadas = cnvLienzo.localToScreen(dimCanvas);

            Robot robot = new Robot();
            BufferedImage screenshot = robot.createScreenCapture(
                    new Rectangle(
                            (int) coordenadas.getMinX(),
                            (int) coordenadas.getMinY(),
                            (int) coordenadas.getWidth(),
                            (int) coordenadas.getHeight()
                    )
            );

            FileChooser seleccionador = new FileChooser();
            seleccionador.setTitle("Guardar Imagen");

            Stage stage = (Stage) cnvLienzo.getScene().getWindow();
            File Destino = seleccionador.showSaveDialog(stage);

            if (Destino != null) {
                ImageIO.write(screenshot, "png", Destino);
                System.out.println("Imagen guardada: " + Destino.getAbsolutePath());
            }

        } catch (AWTException e) {
            System.err.println("Error al guardar la imagen: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al guardar la imagen: " + e.getMessage());
        }
    }
}