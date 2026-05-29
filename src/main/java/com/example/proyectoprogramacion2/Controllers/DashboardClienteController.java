package com.example.proyectoprogramacion2.Controllers;

import com.example.proyectoprogramacion2.model.SistemaConcierto;
import com.example.proyectoprogramacion2.model.Evento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DashboardClienteController {

    @FXML
    private FlowPane contenedorEventos;

    private SistemaConcierto sistema =
            SistemaConcierto.getInstancia();

    @FXML
    public void initialize() {

        for (Evento evento : sistema.getEventos()) {

            VBox card = new VBox();

            card.setSpacing(10);

            card.setPrefWidth(250);

            card.setStyle(
                    "-fx-background-color: white;" +
                            "-fx-padding: 18;" +
                            "-fx-background-radius: 15;" +
                            "-fx-border-radius: 15;" +
                            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.15), 10, 0, 0, 4);"
            );

            Label nombre = new Label(evento.getNombre());

            nombre.setStyle(
                    "-fx-font-size: 22px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-text-fill: #1E293B;"
            );

            Label ciudad = new Label(
                    "Ciudad: " + evento.getCiudad()
            );

            ciudad.setStyle(
                    "-fx-font-size: 14px;" +
                            "-fx-text-fill: #475569;"
            );

            Label categoria = new Label(
                    "Categoría: " + evento.getCategoria()
            );

            categoria.setStyle(
                    "-fx-font-size: 14px;" +
                            "-fx-text-fill: #475569;"
            );

            Button boton = new Button("Ver Evento");

            boton.setPrefWidth(150);

            boton.setOnAction(e -> {

                SistemaConcierto
                        .getInstancia()
                        .setEventoActual(evento);

                abrirCompraView();
            });

            card.getChildren().addAll(
                    nombre,
                    ciudad,
                    categoria,
                    boton
            );

            contenedorEventos.getChildren().add(card);
        }
    }

    public void abrirCompraView() {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/com/example/proyectoprogramacion2/CompraView.fxml"));

            Parent root = loader.load();

            Stage stage = new Stage();

            Scene scene = new Scene(root);

            stage.setScene(scene);

            stage.setTitle("Compra de Entrada");

            stage.show();

        } catch (Exception e) {

            e.printStackTrace();
        }
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

            Stage stage =
                    (Stage) contenedorEventos.getScene().getWindow();

            stage.setScene(new Scene(root));

            stage.show();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
