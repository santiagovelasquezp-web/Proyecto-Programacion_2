package com.example.proyectoprogramacion2.Controllers;
import com.example.proyectoprogramacion2.model.SistemaConcierto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PagoPSEController {

    @FXML
    private ComboBox<String> comboBanco;

    @FXML
    private TextField txtDocumento;

    @FXML
    public void initialize() {

        comboBanco.getItems().addAll("Bancolombia", "Davivienda", "Nequi", "BBVA");
    }

    @FXML
    public void confirmarPago(ActionEvent event) {

        if (comboBanco.getValue() == null) {

            mostrarError("Seleccione un banco");
            return;
        }

        if (txtDocumento.getText().isEmpty()) {

            mostrarError("Ingrese documento");
            return;
        }
        SistemaConcierto.getInstancia().agregarCompra(CompraViewController.compraActual);

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle("Compra Exitosa");

        alerta.setHeaderText(null);

        alerta.setContentText(
                "Compra confirmada\n\n" +
                        "Total: $" + CompraViewController.total
        );

        alerta.showAndWait();
    }

    private void mostrarError(String mensaje) {

        Alert alerta = new Alert(Alert.AlertType.ERROR);

        alerta.setContentText(mensaje);

        alerta.showAndWait();
    }
}

