package com.example.proyectoprogramacion2.Controllers;

import com.example.proyectoprogramacion2.model.Compra;
import com.example.proyectoprogramacion2.model.SistemaConcierto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class MetricasController implements Initializable {

    @FXML
    private PieChart graficaZonas;

    @FXML
    private BarChart<String, Number> graficaIngresos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cargarGraficaZonas();

        cargarGraficaIngresos();
    }

    public void cargarGraficaZonas() {

        int vip = 0;
        int preferencial = 0;
        int general = 0;

        for(Compra compra :
                SistemaConcierto.getInstancia().getCompras()) {

            if(compra.getZona().contains("VIP")) {
                vip++;
            }

            else if(compra.getZona().contains("Preferencial")) {
                preferencial++;
            }

            else {
                general++;
            }
        }

        ObservableList<PieChart.Data> datos =
                FXCollections.observableArrayList(

                        new PieChart.Data("VIP", vip),
                        new PieChart.Data("Preferencial", preferencial),
                        new PieChart.Data("General", general)
                );

        graficaZonas.setData(datos);

        graficaZonas.setTitle("Compras por Zona");
    }

    public void cargarGraficaIngresos() {

        XYChart.Series<String, Number> serie =
                new XYChart.Series<>();

        Map<String, Double> ingresosEventos =
                new HashMap<>();

        for(Compra compra :
                SistemaConcierto.getInstancia().getCompras()) {

            String nombreEvento =
                    compra.getEvento().getNombre();

            double total =
                    compra.getTotal();

            ingresosEventos.put(
                    nombreEvento,

                    ingresosEventos.getOrDefault(
                            nombreEvento,
                            0.0
                    ) + total
            );
        }

        for(String evento :
                ingresosEventos.keySet()) {

            serie.getData().add(

                    new XYChart.Data<>(

                            evento,
                            ingresosEventos.get(evento)
                    )
            );
        }

        graficaIngresos.getData().add(serie);

        graficaIngresos.setTitle(
                "Ingresos por Evento"
        );
    }
}