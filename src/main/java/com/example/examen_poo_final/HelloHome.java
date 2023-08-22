package com.example.examen_poo_final;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloGame {

    private Stage currentStage; // Mantén una referencia al Stage actual

    public void setCurrentStage(Stage currentStage) {
        this.currentStage = currentStage;
    }

    @FXML
    private void onHelloButtonGame() throws IOException {
        cerrarVentanaActual();
        cargarVentana("Juego.fxml");
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
        Pane pane = fxmlLoader.load(); // Cargar el contenido del archivo FXML

        Stage stage = new Stage(); // Crear una instancia de Stage
        stage.setScene(new Scene(pane)); // Establecer la escena con el contenido cargado
        stage.show(); // Mostrar el stage

        setCurrentStage(stage); // Establecer el nuevo Stage como ventana actual
    }
}
