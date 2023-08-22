package com.example.examen_poo_final;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Pregunta;

import java.io.IOException;
import java.util.*;

public class HelloGame {

    @FXML
    private Label preguntaLabel;

    @FXML
    private Button opcionButton1;

    @FXML
    private Button opcionButton2;

    @FXML
    private Button opcionButton3;

    @FXML
    private Button opcionButton4;

    private List<Pregunta> preguntas = new ArrayList<>();
    private int indicePreguntaActual;

    private Set<Integer> preguntasMostradas = new HashSet<>();
    private int preguntasRestantes;

    public HelloGame(List<Pregunta> preguntas) {
        cargarPregunta();
        preguntasRestantes = this.preguntas.size();
        if (preguntasRestantes > 0) {
            cargarPregunta();
        } else {
            // No hay preguntas disponibles, redirigir a la pantalla de resultados
            cargarPantallaResultado();
        }
    }

    public HelloGame(){
        int reguntasRestantes = this.preguntas.size();
        if (preguntasRestantes > 0) {
            cargarPregunta();
        } else {
            // No hay preguntas disponibles, redirigir a la pantalla de resultados
            cargarPantallaResultado();
        }
    }
    
    private void cargarPantallaResultado() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Resultado.fxml"));
            Pane pane = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(pane));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void cargarPregunta() {
        Pregunta pregunta = preguntas.get(indicePreguntaActual);
        List<String> opciones = pregunta.getOpciones();

        preguntaLabel.setText(pregunta.getTexto());
        opcionButton1.setText(opciones.get(0));
        opcionButton2.setText(opciones.get(1));
        opcionButton3.setText(opciones.get(2));
        opcionButton4.setText(opciones.get(3));
    }


    private int obtenerIndicePreguntaAleatoria() {
        Random random = new Random();
        return random.nextInt(preguntas.size());
    }

    @FXML
    private void onHelloButtonOp1() {
        verificarRespuestaSeleccionada(0);
    }

    @FXML
    private void onHelloButtonOp2() {
        verificarRespuestaSeleccionada(1);
    }

    @FXML
    private void onHelloButtonOp3() {
        verificarRespuestaSeleccionada(2);
    }

    @FXML
    private void onHelloButtonOp4() {
        verificarRespuestaSeleccionada(3);
    }

    private void verificarRespuestaSeleccionada(int indiceRespuesta) {
        int correctas = 0;
        int incorrectas = 0;
        Pregunta preguntaActual = preguntas.get(indicePreguntaActual);
        if (preguntaActual.getRespuestaCorrecta() == indiceRespuesta) {
            correctas ++;
        } else {
            incorrectas ++;
        }

        if (preguntasRestantes > 0) {
            indicePreguntaActual = obtenerIndicePreguntaAleatoria();
            cargarPregunta();
        } else {
            // No hay más preguntas disponibles, redirigir a la pantalla de resultados
            cargarPantallaResultado();
        }
    }

}