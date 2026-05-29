package com.example.proyectoprogramacion2.Controllers;
import com.example.proyectoprogramacion2.model.SistemaConcierto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class PagoEfectivoController {

    @FXML
    private TextField txtReferencia;

    @FXML
    public void confirmarPago(ActionEvent event){

        if(txtReferencia.getText().isEmpty()){

            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setContentText(
                    "Ingrese referencia de pago"
            );

            error.showAndWait();

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

}