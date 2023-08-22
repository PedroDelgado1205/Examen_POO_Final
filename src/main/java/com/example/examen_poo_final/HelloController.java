package com.example.examen_poo_final;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import jdk.internal.access.JavaNioAccess;
import modelo.User;
import modelo.UserDAO;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private TextField nombre;

    @FXML
    private PasswordField clave;

    @FXML
    private void onHelloButtonClick() throws IOException {
        String usuario = nombre.getText();
        String contraseña = clave.getText();

        User user = new User(usuario, contraseña);

        UserDAO userDAO = new UserDAO();
        int idUsuario = userDAO.consulta(user);

        if (idUsuario != 0) {
            cargarVentanaInicio();
        } else {
            nombre.setText("error al ingresar");
        }
    }

    private void cargarVentanaInicio() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Inicio.fxml"));
        Pane pane = fxmlLoader.load();

        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(new Scene(pane));
        stage.show();
    }

}
