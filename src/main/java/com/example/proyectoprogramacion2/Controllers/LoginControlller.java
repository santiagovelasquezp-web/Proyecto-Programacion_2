package com.example.proyectoprogramacion2.Controllers;

import com.example.proyectoprogramacion2.model.SistemaConcierto;
import com.example.proyectoprogramacion2.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
            String password = txtPassword.getText(); // Captura la clave

            Usuario usuarioEncontrado = null;
            for (Usuario u : SistemaConcierto.getInstancia().getUsuarios()) {

                if (u.getCorreo().equalsIgnoreCase(correo) && u.getContrasena().equals(password)) {
                    usuarioEncontrado = u;
                    break;
                }
            }
            if (usuarioEncontrado == null) {
                mostrarError("Correo o contraseña incorrectos");
                return;
            }
            SistemaConcierto.getInstancia().setUsuarioActual(usuarioEncontrado);
            if(usuarioEncontrado.getNotificacionPendiente() != null){

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);

                alerta.setTitle("Nueva Notificación");

                alerta.setHeaderText(null);

                alerta.setContentText(
                        usuarioEncontrado.getNotificacionPendiente()
                );

                alerta.showAndWait();

                usuarioEncontrado.setNotificacionPendiente(null);
            }
            // Si pasó la validación, carga la vista según el correo
            FXMLLoader loader;
            if (usuarioEncontrado.getRol().equalsIgnoreCase("ADMIN")) {
                loader = new FXMLLoader(getClass().getResource("/com/example/proyectoprogramacion2/AdminView.fxml"));
            } else {
                loader = new FXMLLoader(getClass().getResource("/com/example/proyectoprogramacion2/ClienteView.fxml"));
            }
            if (usuarioEncontrado.getRol().equalsIgnoreCase("CLIENTE")) {
                SistemaConcierto.getInstancia().suscribir(usuarioEncontrado);
            }

            Parent root = loader.load();
            Stage stage = (Stage) btnIngresar.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void abrirRegistro(ActionEvent event){

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/proyectoprogramacion2/RegisterView.fxml"));

            Parent root = loader.load();

            Stage stage = (Stage) btnIngresar
                    .getScene()
                    .getWindow();

            stage.setScene(new Scene(root));

            stage.show();

        }catch (Exception e){

            e.printStackTrace();
        }
    }
    public void mostrarError(String mensaje){

        Alert alerta = new Alert(Alert.AlertType.ERROR);

        alerta.setTitle("Error");

        alerta.setHeaderText(null);

        alerta.setContentText(mensaje);

        alerta.showAndWait();
    }
}