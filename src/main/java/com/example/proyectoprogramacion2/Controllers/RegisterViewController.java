package com.example.proyectoprogramacion2.Controllers;

import com.example.proyectoprogramacion2.model.SistemaConcierto;
import com.example.proyectoprogramacion2.model.Usuario;
import com.example.proyectoprogramacion2.patterns.UsuarioBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RegisterViewController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtTelefono;

    @FXML
    private PasswordField txtPassword;

    @FXML
    public void registrarUsuario(ActionEvent event){

        if(txtNombre.getText().isEmpty()){

            mostrarError("Ingrese un nombre");
            return;
        }

        if(txtCorreo.getText().isEmpty()){

            mostrarError("Ingrese un correo");
            return;

        }
        if(!txtCorreo.getText().contains("@")){

            mostrarError("correo invalido, ingrese: @");
            return;
        }

        String telefono = txtTelefono.getText();

        if(!telefono.matches("\\d+")){

            mostrarError("El teléfono solo debe contener números");
            return;
        }

        if(telefono.length() != 10){

            mostrarError("El teléfono debe tener 10 números");
            return;
        }

        if(txtPassword.getText().length() < 4){

            mostrarError("La contraseña debe tener mínimo 4 caracteres");
            return;
        }

        Usuario nuevo = new UsuarioBuilder()

                .nombre(txtNombre.getText())

                .correo(txtCorreo.getText())

                .telefono(txtTelefono.getText())

                .contrasena(txtPassword.getText())

                .build();

        SistemaConcierto
                .getInstancia()
                .agregarUsuario(nuevo);

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle("Registro Exitoso");

        alerta.setHeaderText(null);

        alerta.setContentText("Usuario registrado correctamente");

        alerta.showAndWait();

        volverLogin(event);
    }

    @FXML
    public void volverLogin(ActionEvent event){

        try{

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/com/example/proyectoprogramacion2/LoginView.fxml"
                    )
            );

            Parent root = loader.load();

            Stage stage = (Stage) txtNombre
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
