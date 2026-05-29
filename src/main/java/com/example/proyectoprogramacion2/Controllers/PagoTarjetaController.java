package com.example.proyectoprogramacion2.Controllers;

import com.example.proyectoprogramacion2.model.SistemaConcierto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PagoTarjetaController {

    @FXML
    private TextField txtNumeroTarjeta;

    @FXML
    private TextField txtTitular;

    @FXML
    private PasswordField txtCVV;
    @FXML
    public void initialize(){

        txtNumeroTarjeta.textProperty().addListener((observable, oldValue, newValue) -> {

            if(!newValue.matches("\\d*")){

                txtNumeroTarjeta.setText(
                        newValue.replaceAll("[^\\d]", "")
                );
            }
        });

        txtCVV.textProperty().addListener((observable, oldValue, newValue) -> {

            if(!newValue.matches("\\d*")){

                txtCVV.setText(
                        newValue.replaceAll("[^\\d]", "")
                );
            }
        });
    }

    @FXML
    public void confirmarPago(ActionEvent event) {

        if(txtNumeroTarjeta.getText().length() != 16){

            mostrarError("La tarjeta debe tener 16 números");
            return;
        }

        if(txtCVV.getText().length() != 3){

            mostrarError("El CVV debe tener 3 números");
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

    private void mostrarError(String mensaje){

        Alert alerta = new Alert(Alert.AlertType.ERROR);

        alerta.setTitle("Error");

        alerta.setHeaderText(null);

        alerta.setContentText(mensaje);

        alerta.showAndWait();
    }
}
