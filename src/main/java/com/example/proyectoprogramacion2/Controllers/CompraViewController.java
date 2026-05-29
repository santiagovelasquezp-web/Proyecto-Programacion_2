package com.example.proyectoprogramacion2.Controllers;
import com.example.proyectoprogramacion2.patterns.Asiento;
import com.example.proyectoprogramacion2.patterns.Zona;
import com.example.proyectoprogramacion2.enums.EstadoAsiento;
import com.example.proyectoprogramacion2.enums.EstadoCompra;
import com.example.proyectoprogramacion2.model.*;
import com.example.proyectoprogramacion2.model.SistemaConcierto;
import com.example.proyectoprogramacion2.patterns.MetodoPago;
import com.example.proyectoprogramacion2.patterns.PagoEfectivo;
import com.example.proyectoprogramacion2.patterns.PagoPSE;
import com.example.proyectoprogramacion2.patterns.PagoTarjeta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CompraViewController implements Initializable {
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
    @FXML
    private Label lblTotal;
    @FXML
    private Label lblAsiento;
    @FXML
    private Button  btnPreferencial;
    @FXML
    private Button  btnGeneral;
    @FXML
    private GridPane panelAsientos;
    public static String zonaSeleccionada;
    public static String asientoSeleccionado;
    private double precioZona = 0;
    public static double total= 0;
    public static Compra compraActual;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboMetodoPago.getItems().addAll("Efectivo", "Tarjeta", "Pse");

        for(int fila = 0; fila < 3; fila++) {
            for(int columna = 0; columna < 4; columna++) {
                Button asiento = new Button();
                asiento.setPrefSize(60, 60);
                String nombreAsiento =
                        "" + (char)('A' + fila) + (columna + 1);
                asiento.setText(nombreAsiento);
                asiento.setStyle("-fx-background-color: #2ECC71;" + "-fx-text-fill: white;" + "-fx-font-weight: bold;");

                asiento.setOnAction(event -> {

                    if(asiento.getStyle().contains("#E74C3C")){

                        asiento.setStyle("-fx-background-color: #2ECC71;" + "-fx-text-fill: white;" + "-fx-font-weight: bold;");

                        asientoSeleccionado = null;

                        System.out.println("Asiento deseleccionado");
                    }

                    else{
                        asientoSeleccionado = asiento.getText();

                        asiento.setStyle("-fx-background-color: #E74C3C;" + "-fx-text-fill: white;" + "-fx-font-weight: bold;");

                        System.out.println(
                                "Asiento seleccionado: " +
                                        asientoSeleccionado
                        );
                    }
                });
                panelAsientos.add(asiento, columna, fila);
            }

        }
        checkVip.setOnAction(e -> actualizarTotal());

        checkSeguro.setOnAction(e -> actualizarTotal());

        checkBebida.setOnAction(e -> actualizarTotal());

        checkParqueadero.setOnAction(e -> actualizarTotal());
    }

    @FXML
    public void seleccionarVIP() {

        zonaSeleccionada = "Zona VIP";

        precioZona = 200000;

        actualizarTotal();

        panelAsientos.setVisible(true);

    }

    @FXML
    public void seleccionarPreferencial() {

        zonaSeleccionada = "Zona Preferencial";

        precioZona = 100000;

        actualizarTotal();

        panelAsientos.setVisible(true);
    }

    @FXML
    public void seleccionarGeneral() {

        zonaSeleccionada = "Zona General";

        precioZona = 50000;
        actualizarTotal();

        panelAsientos.setVisible(true);



    }
    @FXML
    public void seleccionarAsiento(ActionEvent event) {

        Button boton = (Button) event.getSource();

        asientoSeleccionado = boton.getText();

        lblAsiento.setText("Asiento: " + asientoSeleccionado);
    }

    @FXML
    public void continuarCompra(ActionEvent event) {

        if(zonaSeleccionada == null){

            mostrarError("Debe seleccionar una zona");
            return;
        }

        if(asientoSeleccionado == null){

            mostrarError("Debe seleccionar un asiento");
            return;
        }

        if(comboMetodoPago.getValue() == null){

            mostrarError("Debe seleccionar un método de pago");
            return;
        }

        Zona zona = new Zona("Z1", zonaSeleccionada, 500, precioZona, new ArrayList<>());

        Asiento asiento = new Asiento(asientoSeleccionado, "A", 1, EstadoAsiento.DISPONIBLE);

        Usuario usuario = SistemaConcierto.getInstancia().getUsuarioActual();

        Evento evento = SistemaConcierto.getInstancia().getEventoActual();
        MetodoPago metodoPago;

        String metodoSeleccionado =
                comboMetodoPago.getValue();

        if(metodoSeleccionado.equals("Efectivo")){

            metodoPago = new PagoEfectivo();
        }

        else if(metodoSeleccionado.equals("Tarjeta")){

            metodoPago = new PagoTarjeta();
        }

        else{

            metodoPago = new PagoPSE();
        }

        String idCompra = "C00" + (SistemaConcierto.getInstancia().getCompras().size() + 1);

        compraActual = new Compra(idCompra, usuario, evento, LocalDateTime.now(), EstadoCompra.CONFIRMADA, total, metodoPago, new ArrayList<>(), new ArrayList<>());
        compraActual.setZona(zonaSeleccionada);
        if(metodoSeleccionado.equals("Efectivo")){

            abrirVentanaPago(
                    "/com/example/proyectoprogramacion2/PagoEfectivo.fxml");
        }

        else if(metodoSeleccionado.equals("Tarjeta")){

            abrirVentanaPago(
                    "/com/example/proyectoprogramacion2/PagoTarjeta.fxml");
        }

        else{

            abrirVentanaPago(
                    "/com/example/proyectoprogramacion2/PagoPse.fxml");
        }
    }
    public void abrirVentanaPago(String rutaFXML) {

        try {
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(rutaFXML));

            Parent root = loader.load();

            Stage stage = new Stage();

            stage.setScene(new Scene(root));

            stage.show();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public void mostrarError(String mensaje){

        Alert alerta = new Alert(Alert.AlertType.ERROR);

        alerta.setTitle("Error");

        alerta.setHeaderText(null);

        alerta.setContentText(mensaje);

        alerta.showAndWait();
    }
    public void actualizarTotal(){

        total = precioZona;

        if(checkVip.isSelected()){
            total += 50000;
        }
        if(checkSeguro.isSelected()){
            total += 20000;
        }
        if(checkBebida.isSelected()){
            total += 15000;
        }
        if(checkParqueadero.isSelected()){
            total += 30000;
        }
        lblTotal.setText("Total: $" + total);
    }
}