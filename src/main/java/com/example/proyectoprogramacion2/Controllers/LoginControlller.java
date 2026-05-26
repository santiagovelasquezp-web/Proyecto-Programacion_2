package com.example.proyectoprogramacion2.Controllers;

import com.example.proyectoprogramacion2.singleton.SistemaConcierto;
import com.example.proyectoprogramacion2.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginControlller {

    @FXML
    private TextField txtCorreo;

    @FXML
    private Button btnIngresar;
    @FXML
    private PasswordField txtPassword;

    public void iniciarSesion(ActionEvent event) {
        try {
            String correo = txtCorreo.getText();
            String password = txtPassword.getText(); // Capturamos la clave

            Usuario usuarioEncontrado = null;
            for (Usuario u : SistemaConcierto.getInstancia().getUsuarios()) {

                if (u.getCorreo().equalsIgnoreCase(correo) && u.getContrasena().equals(password)) {
                    usuarioEncontrado = u;
                    break;
                }
            }

            if (usuarioEncontrado == null) {
                System.out.println("Correo o contraseña incorrectos");
                return;
            }

            // Si pasó la validación, cargamos la vista según el correo
            FXMLLoader loader;
            if (usuarioEncontrado.getCorreo().equalsIgnoreCase("admin@gmail.com")) {
                loader = new FXMLLoader(getClass().getResource("/com/example/proyectoprogramacion2/AdminView.fxml"));
            } else {
                loader = new FXMLLoader(getClass().getResource("/com/example/proyectoprogramacion2/ClienteView.fxml"));
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