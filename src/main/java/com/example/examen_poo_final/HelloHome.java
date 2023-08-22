package com.example.examen_poo_final;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Pregunta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelloHome {

    private Stage currentStage; // Mantén una referencia al Stage actual

    public void setCurrentStage(Stage currentStage) {
        this.currentStage = currentStage;
    }

    @FXML
    private void onHelloButtonGame() throws IOException {
        cerrarVentanaActual();
        cargarVentana("Juego.fxml");
        List<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(new Pregunta("Pregunta 1", Arrays.asList("Opción 1", "Opción 2", "Opción 3", "Opción 4"), 0));
        preguntas.add(new Pregunta("Pregunta 2", Arrays.asList("Opción 1", "Opción 2", "Opción 3", "Opción 4"), 1));
        preguntas.add(new Pregunta("Pregunta 3", Arrays.asList("Opción 1", "Opción 2", "Opción 3", "Opción 4"), 2));

        HelloGame helloGame = new HelloGame(preguntas);
    }

    @FXML
    private void onHelloButtonHistory() throws IOException {
        cerrarVentanaActual();
        cargarVentana("Intentos.fxml");
    }

    @FXML
    private void onHelloButtonLogin() throws IOException {
        cerrarVentanaActual();
        cargarVentana("Login.fxml");
    }

    private void cerrarVentanaActual() {
        if (currentStage != null) {
            currentStage.close();
        }
    }

    private void cargarVentana(String fxmlFileName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFileName));
        Pane pane = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(pane));
        stage.show();
        setCurrentStage(stage);
    }
}
