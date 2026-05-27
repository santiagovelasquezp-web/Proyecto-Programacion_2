package com.example.proyectoprogramacion2.Controllers;
import com.example.proyectoprogramacion2.composite.Asiento;
import com.example.proyectoprogramacion2.composite.Zona;
import com.example.proyectoprogramacion2.enums.EstadoAsiento;
import com.example.proyectoprogramacion2.enums.EstadoEvento;
import com.example.proyectoprogramacion2.model.*;
import com.example.proyectoprogramacion2.service.CompraService;
import com.example.proyectoprogramacion2.strategy.MetodoPago;
import com.example.proyectoprogramacion2.strategy.PagoEfectivo;
import com.example.proyectoprogramacion2.decorator.*;
import com.example.proyectoprogramacion2.strategy.PagoPSE;
import com.example.proyectoprogramacion2.strategy.PagoTarjeta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CompraViewController implements Initializable {
    @FXML
    private ComboBox<String> comboZona;

    @FXML
    private ComboBox<String> comboAsiento;

    @FXML
    private ComboBox<String> comboMetodoPago;

    @FXML
    private CheckBox checkVip;

    @FXML
    private CheckBox checkSeguro;

    @FXML
    private CheckBox checkBebida;

    @FXML
    private CheckBox checkParqueadero;

    private CompraService compraService = new CompraService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboZona.getItems().addAll(
                "Zona VIP",
                "Zona General",
                "Zona Preferencial"
        );
        comboAsiento.getItems().addAll(
                "A1",
                "A2",
                "A3",
                "B1",
                "B2",
                "B3"
        );
        comboMetodoPago.getItems().addAll(
                "Efectivo",
                "Tarjeta",
                "PayPal"
        );
    }

    public void confirmarCompra(ActionEvent event) {

        double precioZona = 0;

        if(comboZona.getValue().equals("Zona General")){

            precioZona = 50000;
        }

        else if(comboZona.getValue().equals("Zona Preferencial")){

            precioZona = 100000;
        }

        else if(comboZona.getValue().equals("Zona VIP")){

            precioZona = 200000;
        }

        Zona zona = new Zona("Z1", comboZona.getValue(), 500, precioZona, new java.util.ArrayList<>());

        Asiento asiento = new Asiento(comboAsiento.getValue(), "A", 1, EstadoAsiento.DISPONIBLE
        );

        MetodoPago metodoPago;

        String metodoSeleccionado =
                comboMetodoPago.getValue();

        if(metodoSeleccionado.equals("Efectivo")){

            metodoPago = new PagoEfectivo();

            abrirVentanaPago(
                    "/com/example/proyectoprogramacion2/PagoEfectivoView.fxml"
            );
        }

        else if(metodoSeleccionado.equals("Tarjeta")){

            metodoPago = new PagoTarjeta();

            abrirVentanaPago(
                    "/com/example/proyectoprogramacion2/PagoTarjetaView.fxml"
            );
        }

        else{

            metodoPago = new PagoPSE();

            abrirVentanaPago(
                    "/com/example/proyectoprogramacion2/PagoPSEView.fxml"
            );
        }

        java.util.List<ServicioAdicional> servicios = new java.util.ArrayList<>();

        if (checkVip.isSelected()) {

            servicios.add(
                    new VIPDecorator()
            );
        }

        if (checkSeguro.isSelected()) {

            servicios.add(
                    new SeguroDecorator()
            );
        }

        if (checkBebida.isSelected()) {

            servicios.add(
                    new BebidaDecorator()
            );
        }

        if (checkParqueadero.isSelected()) {

            servicios.add(
                    new ParqueaderoDecorator()
            );
        }

        Usuario usuario = new Usuario(
                "U001",
                "Cliente",
                "cliente@gmail.com",
                "123","cliente","1488"
        );

        Evento evento = new Evento(
                "E001",
                "Concierto Rock",
                "Rock",
                "Evento de rock",
                "Bogotá",
                java.time.LocalDate.now(),
                java.time.LocalTime.now(),
                EstadoEvento.ACTIVO,
                null,
                new java.util.ArrayList<>(),
                new java.util.ArrayList<>(),
                new java.util.ArrayList<>()
        );

        Compra compra = compraService.realizarCompra(
                usuario,
                evento,
                zona,
                asiento,
                metodoPago,
                servicios
        );

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle("Compra Exitosa");

        alerta.setHeaderText(null);

        alerta.setContentText(
                "Compra realizada correctamente.\n\n" +
                        "Total: $" + compra.getTotal()
        );

        alerta.showAndWait();
    }
    public void abrirVentanaPago(String rutaFXML) {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(rutaFXML)
                    );

            Parent root = loader.load();

            Stage stage = new Stage();

            stage.setScene(new Scene(root));

            stage.show();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}