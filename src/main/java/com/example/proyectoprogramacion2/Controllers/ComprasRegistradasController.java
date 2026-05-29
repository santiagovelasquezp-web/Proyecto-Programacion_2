package com.example.proyectoprogramacion2.Controllers;
import com.example.proyectoprogramacion2.model.Compra;
import com.example.proyectoprogramacion2.model.SistemaConcierto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class ComprasRegistradasController implements Initializable {

    @FXML
    private TableView<Compra> tablaCompras;

    @FXML
    private TableColumn<Compra, String> colIdCompra;

    @FXML
    private TableColumn<Compra, String> colUsuario;

    @FXML
    private TableColumn<Compra, String> colEvento;

    @FXML
    private TableColumn<Compra, Double> colTotal;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colIdCompra.setCellValueFactory(new PropertyValueFactory<>("idCompra"));

        colUsuario.setCellValueFactory(cellData -> {

            if(cellData.getValue() == null ||
                    cellData.getValue().getUsuario() == null){

                return new javafx.beans.property.SimpleStringProperty();
            }

            return new javafx.beans.property.SimpleStringProperty(
                    cellData.getValue().getUsuario().getNombre()
            );
        });
        colEvento.setCellValueFactory(cellData -> {

            if(cellData.getValue() == null ||
                    cellData.getValue().getEvento() == null){

                return new javafx.beans.property.SimpleStringProperty();
            }

            return new javafx.beans.property.SimpleStringProperty(
                    cellData.getValue().getEvento().getNombre()
            );
        });

        colTotal.setCellValueFactory(
                new PropertyValueFactory<>("total")
        );

        ObservableList<Compra> compras =
                FXCollections.observableArrayList(

                        SistemaConcierto.getInstancia().getCompras()
                );

        tablaCompras.setItems(compras);
    }
}
