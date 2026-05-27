package com.example.proyectoprogramacion2.Controllers;

import com.example.proyectoprogramacion2.adapter.ExportadorDatos;
import com.example.proyectoprogramacion2.adapter.ReporteCSVAdapter;
import com.example.proyectoprogramacion2.model.Compra;
import com.example.proyectoprogramacion2.singleton.SistemaConcierto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardAdminController implements Initializable {

    @FXML
    private AnchorPane contenedorContenido;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        abrirEventos();
    }

    public void cargarVista(String archivo) {

        try {

            AnchorPane vista = FXMLLoader.load(
                    getClass().getResource("/com/example/proyectoprogramacion2/" + archivo));

            contenedorContenido.getChildren().setAll(vista);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @FXML
    public void abrirEventos() {

        cargarVista("EventosView.fxml");
    }

    @FXML
    public void abrirUsuarios() {

        cargarVista("UsuariosView.fxml");
    }

    @FXML
    public void abrirCompras() {

        cargarVista("ComprasView.fxml");
    }

    @FXML
    public void abrirMetricas() {

        cargarVista("MetricasView.fxml");
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

            Stage stage = (Stage) contenedorContenido.getScene().getWindow();

            stage.setScene(new Scene(root));

            stage.show();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @FXML
    public void GenerarReporte(ActionEvent event) {

        List<Compra> todasLasCompras =
                SistemaConcierto.getInstancia().getCompras();

        ExportadorDatos exportador = new ReporteCSVAdapter();

        String contenidoCSV =
                exportador.exportar(todasLasCompras);

        System.out.println("=== REPORTE CSV ===");

        System.out.println(contenidoCSV);
    }
}
