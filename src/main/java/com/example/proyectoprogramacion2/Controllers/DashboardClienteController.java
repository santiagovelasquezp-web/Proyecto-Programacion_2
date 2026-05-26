package com.example.proyectoprogramacion2.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DashboardClienteController {

    public void abrirCompraView(ActionEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/proyectoprogramacion2/CompraView.fxml")
            );

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
}
