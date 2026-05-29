package com.example.proyectoprogramacion2;
import com.example.proyectoprogramacion2.model.SistemaConcierto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SistemaConcierto.getInstancia();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Sistema de Eventos");
        stage.setScene(scene);
        stage.show();
    }
}
