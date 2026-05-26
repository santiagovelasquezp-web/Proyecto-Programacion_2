package com.example.proyectoprogramacion2.adapter;

import com.example.proyectoprogramacion2.model.Compra;

import java.util.List;

public class ReporteCSVAdapter implements ExportadorDatos{
    @Override
    public String exportar(Object datos) {
        List<Compra> compras = (List<Compra>) datos;
        StringBuilder csv = new StringBuilder();
//la clase implementa la interface, sobreescribe su metodo y añade una funcionalidad propia
        csv.append("ID Compra,Usuario,Evento,Total,Estado\n");

        for (Compra c : compras) {
            csv.append(c.getIdCompra()).append(",")
                    .append(c.getUsuario().getNombre()).append(",")
                    .append(c.getEvento().getNombre()).append(",")
                    .append(c.getTotal()).append(",")
                    .append(c.getEstado()).append("\n");
        }

        return csv.toString();
    }
}

