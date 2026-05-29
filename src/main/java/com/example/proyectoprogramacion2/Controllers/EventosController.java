package com.example.proyectoprogramacion2.Controllers;

import com.example.proyectoprogramacion2.patterns.EventoBuilder;
import com.example.proyectoprogramacion2.enums.EstadoEvento;
import com.example.proyectoprogramacion2.model.Evento;
import com.example.proyectoprogramacion2.model.SistemaConcierto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;

import java.time.LocalTime;

import java.util.ResourceBundle;

public class EventosController implements Initializable {

    @FXML
    private TableView<Evento> tablaEventos;

    @FXML
    private TableColumn<Evento, String> colId;

    @FXML
    private TableColumn<Evento, String> colNombre;

    @FXML
    private TableColumn<Evento, String> colCiudad;

    @FXML
    private TableColumn<Evento, String> colCategoria;

    @FXML
    private TableColumn<Evento, String> colFecha;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCiudad;

    @FXML
    private TextField txtCategoria;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private DatePicker dateFecha;

    private ObservableList<Evento> listaEventos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colId.setCellValueFactory(
                new PropertyValueFactory<>("IDEvento")
        );

        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre")
        );

        colCiudad.setCellValueFactory(
                new PropertyValueFactory<>("ciudad")
        );

        colCategoria.setCellValueFactory(
                new PropertyValueFactory<>("categoria")
        );

        colFecha.setCellValueFactory(
                new PropertyValueFactory<>("fecha")
        );

        listaEventos = FXCollections.observableArrayList(
                SistemaConcierto.getInstancia().getEventos()
        );

        tablaEventos.setItems(listaEventos);
    }

    @FXML
    public void crearEvento(ActionEvent event) {

        Evento nuevoEvento = new EventoBuilder()

                .setIdEvento(
                        "E" + (listaEventos.size() + 1)
                )

                .setNombre(
                        txtNombre.getText()
                )

                .setCiudad(
                        txtCiudad.getText()
                )

                .setCategoria(
                        txtCategoria.getText()
                )

                .setDescripcion(
                        txtDescripcion.getText()
                )

                .setFecha(
                        dateFecha.getValue()
                )

                .setHora(
                        LocalTime.now()
                )

                .setEstado(
                        EstadoEvento.ACTIVO
                )

                .build();

        SistemaConcierto.getInstancia().agregarEvento(nuevoEvento);

        listaEventos.setAll(
                SistemaConcierto.getInstancia().getEventos()
        );

        limpiarCampos();
    }

    @FXML
    public void eliminarEvento(ActionEvent event) {

        Evento seleccionado =
                tablaEventos.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {

            SistemaConcierto
                    .getInstancia()
                    .getEventos()
                    .remove(seleccionado);

            listaEventos.setAll(
                    SistemaConcierto.getInstancia().getEventos()
            );
        }
    }

    public void limpiarCampos() {

        txtNombre.clear();

        txtCiudad.clear();

        txtCategoria.clear();

        txtDescripcion.clear();

        dateFecha.setValue(null);
    }
}