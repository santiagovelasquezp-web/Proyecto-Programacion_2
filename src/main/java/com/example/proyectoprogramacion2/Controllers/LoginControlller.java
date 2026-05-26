package com.example.proyectoprogramacion2.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginControlller {

    @FXML
    private TextField txtCorreo;

    @FXML
    private Button btnIngresar;

    public void iniciarSesion(ActionEvent event) {

        try {


            String correo = txtCorreo.getText();

            FXMLLoader loader;

            // ADMIN

            if (correo.equalsIgnoreCase("admin@gmail.com")) {

                loader = new FXMLLoader(
                        getClass().getResource("/com/example/proyectoprogramacion2/AdminView.fxml")
                );

            } else {

                loader = new FXMLLoader(
                        getClass().getResource("/com/example/proyectoprogramacion2/ClienteView.fxml")
                );
            }

            Parent root = loader.load();

            Stage stage = (Stage) btnIngresar.getScene().getWindow();

            stage.setScene(new Scene(root));

            stage.show();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}