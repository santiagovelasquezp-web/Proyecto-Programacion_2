package com.example.proyectoprogramacion2.Controllers;

import com.example.proyectoprogramacion2.model.Evento;
import com.example.proyectoprogramacion2.singleton.SistemaConcierto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.chart.PieChart;

import java.net.URL;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class MetricasController implements Initializable {

    @FXML
    private PieChart graficoCategorias;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SistemaConcierto sistema =
                SistemaConcierto.getInstancia();

        Map<String, Integer> conteoCategorias =
                new HashMap<>();

        for (Evento evento : sistema.getEventos()) {

            String categoria =
                    evento.getCategoria();

            conteoCategorias.put(

                    categoria,

                    conteoCategorias.getOrDefault(
                            categoria,
                            0
                    ) + 1
            );
        }

        ObservableList<PieChart.Data> datos =
                FXCollections.observableArrayList();

        for (String categoria :
                conteoCategorias.keySet()) {

            datos.add(

                    new PieChart.Data(

                            categoria,

                            conteoCategorias.get(categoria)
                    )
            );
        }

        graficoCategorias.setTitle(
                "Eventos por Categoría"
        );

        graficoCategorias.setData(datos);
    }
}
