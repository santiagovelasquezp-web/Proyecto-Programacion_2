package com.example.proyectoprogramacion2.Controllers;

import com.example.proyectoprogramacion2.patterns.UsuarioBuilder;
import com.example.proyectoprogramacion2.model.Usuario;
import com.example.proyectoprogramacion2.model.SistemaConcierto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class UsuariosViewController implements Initializable {

        @FXML
        private TableView<Usuario> tablaUsuarios;

        @FXML
        private TableColumn<Usuario, String> colId;

        @FXML
        private TableColumn<Usuario, String> colNombre;

        @FXML
        private TableColumn<Usuario, String> colCorreo;

        @FXML
        private TableColumn<Usuario, String> colTelefono;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtTelefono;
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

            colId.setCellValueFactory(new PropertyValueFactory<>("ID"));

            colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

            colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));

            colTelefono.setCellValueFactory(new PropertyValueFactory<>("Telefono"));

            ObservableList<Usuario> usuarios = FXCollections.observableArrayList(SistemaConcierto.getInstancia().getUsuarios());

            tablaUsuarios.setItems(usuarios);

        }
    @FXML
    public void crearUsuario() {
        String telefono = txtTelefono.getText();

        if(!telefono.matches("\\d+")){

            mostrarError("El teléfono solo debe contener números");
            return;
        }

        if(telefono.startsWith("-")){

            mostrarError("El teléfono no puede ser negativo");
            return;
        }

        if(telefono.length() != 10){

            mostrarError("El teléfono debe tener 10 números");
            return;
        }

        Usuario nuevo = new UsuarioBuilder().nombre(txtNombre.getText()).correo(txtCorreo.getText()).telefono(txtTelefono.getText()).contrasena(txtPassword.getText()).build();

        SistemaConcierto.getInstancia().agregarUsuario(nuevo);

        tablaUsuarios.getItems().setAll(SistemaConcierto.getInstancia().getUsuarios());

        limpiarCampos();
    }
    @FXML
    public void eliminarUsuario() {

        Usuario seleccionado = tablaUsuarios.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {

            SistemaConcierto.getInstancia().getUsuarios().remove(seleccionado);

            tablaUsuarios.getItems().setAll(SistemaConcierto.getInstancia().getUsuarios());
        }
    }
    public void limpiarCampos() {

        txtNombre.clear();

        txtCorreo.clear();

        txtPassword.clear();

        txtTelefono.clear();
    }
    public void mostrarError(String mensaje){

        Alert alerta = new Alert(Alert.AlertType.ERROR);

        alerta.setTitle("Error");

        alerta.setHeaderText(null);

        alerta.setContentText(mensaje);

        alerta.showAndWait();
    }
    }

