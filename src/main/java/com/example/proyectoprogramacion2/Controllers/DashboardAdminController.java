package com.example.proyectoprogramacion2.Controllers;
import com.example.proyectoprogramacion2.adapter.ExportadorDatos;
import com.example.proyectoprogramacion2.adapter.ReporteCSVAdapter;
import com.example.proyectoprogramacion2.model.Compra;
import com.example.proyectoprogramacion2.model.Evento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ResourceBundle;
import com.example.proyectoprogramacion2.builder.EventoBuilder;
import com.example.proyectoprogramacion2.singleton.SistemaConcierto;
import javafx.stage.Stage;

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
    private SistemaConcierto sistema = SistemaConcierto.getInstancia();
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

        sistema.agregarEvento(evento1);

        sistema.agregarEvento(evento2);

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

        sistema.agregarEvento(nuevoEvento);

        tablaEventos.setItems(listaEventos);

        txtNombreEvento.clear();

        txtCiudadEvento.clear();

        txtCategoriaEvento.clear();
    }
    @FXML
    public void cerrarSesion(ActionEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/com/example/proyectoprogramacion2/LoginView.fxml"
                    )
            );

            Parent root = loader.load();

            Stage stage = (Stage) tablaEventos.getScene().getWindow();

            stage.setScene(new Scene(root));

            stage.show();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public void GenerarReporte(ActionEvent event) {
        List<Compra> todasLasCompras = SistemaConcierto.getInstancia().getCompras();

        ExportadorDatos exportador = new ReporteCSVAdapter();
        String contenidoCSV = exportador.exportar(todasLasCompras);

        System.out.println("--- REPORTE GENERADO ---");
        System.out.println(contenidoCSV);
    }
}
