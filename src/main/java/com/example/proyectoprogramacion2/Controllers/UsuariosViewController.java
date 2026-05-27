package com.example.proyectoprogramacion2.Controllers;

import com.example.proyectoprogramacion2.model.Usuario;
import com.example.proyectoprogramacion2.singleton.SistemaConcierto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private ComboBox<String> comboRol;

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

            colId.setCellValueFactory(
                    new PropertyValueFactory<>("ID")
            );

            colNombre.setCellValueFactory(
                    new PropertyValueFactory<>("nombre")
            );

            colCorreo.setCellValueFactory(
                    new PropertyValueFactory<>("correo")
            );

            colTelefono.setCellValueFactory(
                    new PropertyValueFactory<>("rol")
            );

            ObservableList<Usuario> usuarios =
                    FXCollections.observableArrayList(
                            SistemaConcierto
                                    .getInstancia()
                                    .getUsuarios()
                    );

            tablaUsuarios.setItems(usuarios);

            comboRol.getItems().addAll(
                    "ADMIN",
                    "CLIENTE"
            );
        }
    @FXML
    public void crearUsuario() {

        Usuario nuevo = new Usuario(

                "U" + (
                        SistemaConcierto
                                .getInstancia()
                                .getUsuarios()
                                .size() + 1
                ),

                txtNombre.getText(),

                txtCorreo.getText(),

                "000000",

                comboRol.getValue(),

                txtPassword.getText()
        );

        SistemaConcierto
                .getInstancia()
                .agregarUsuario(nuevo);

        tablaUsuarios.getItems().setAll(
                SistemaConcierto
                        .getInstancia()
                        .getUsuarios()
        );

        limpiarCampos();
    }
    @FXML
    public void eliminarUsuario() {

        Usuario seleccionado =
                tablaUsuarios
                        .getSelectionModel()
                        .getSelectedItem();

        if (seleccionado != null) {

            SistemaConcierto
                    .getInstancia()
                    .getUsuarios()
                    .remove(seleccionado);

            tablaUsuarios.getItems().setAll(
                    SistemaConcierto
                            .getInstancia()
                            .getUsuarios()
            );
        }
    }
    public void limpiarCampos() {

        txtNombre.clear();

        txtCorreo.clear();

        txtPassword.clear();

        comboRol.setValue(null);
    }
    }

