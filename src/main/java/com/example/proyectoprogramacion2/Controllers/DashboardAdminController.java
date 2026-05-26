package com.example.proyectoprogramacion2.Controllers;
import com.example.proyectoprogramacion2.model.Evento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.example.proyectoprogramacion2.builder.EventoBuilder;

public class DashboardAdminController implements Initializable {

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
    private TextField txtNombreEvento;

    @FXML
    private TextField txtCiudadEvento;

    @FXML
    private TextField txtCategoriaEvento;

    private ObservableList<Evento> listaEventos =
            FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        colId.setCellValueFactory(new PropertyValueFactory<>("IDEvento"));

        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        colCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));

        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));



        Evento evento1 = new EventoBuilder()
                .setIdEvento("E001")
                .setNombre("Concierto Rock")
                .setCategoria("Rock")
                .setDescripcion("Evento de rock")
                .setCiudad("Bogotá")
                .setFecha(LocalDate.now())
                .setHora(LocalTime.now())
                .build();

        Evento evento2 = new EventoBuilder()
                .setIdEvento("E002")
                .setNombre("Festival Pop")
                .setCategoria("Pop")
                .setDescripcion("Evento pop")
                .setCiudad("Medellín")
                .setFecha(LocalDate.now())
                .setHora(LocalTime.now())
                .build();

        listaEventos.add(evento1);

        listaEventos.add(evento2);

        tablaEventos.setItems(listaEventos);
    }
    public void crearEvento() {

        Evento nuevoEvento = new EventoBuilder()

                .setIdEvento("E00" + (listaEventos.size() + 1))

                .setNombre(txtNombreEvento.getText())

                .setCiudad(txtCiudadEvento.getText())

                .setCategoria(txtCategoriaEvento.getText())

                .setFecha(LocalDate.now())

                .setHora(LocalTime.now())

                .build();

        listaEventos.add(nuevoEvento);

        tablaEventos.setItems(listaEventos);

        txtNombreEvento.clear();

        txtCiudadEvento.clear();

        txtCategoriaEvento.clear();
    }
}
