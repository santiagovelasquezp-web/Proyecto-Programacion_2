package com.example.proyectoprogramacion2.model;
import java.util.ArrayList;
import java.util.List;

public class SistemaConcierto {

    private static SistemaConcierto instancia;

    private List<Evento> eventos;

    private List<Usuario> usuarios;

    private List<Compra> compras;


    private SistemaConcierto() {

        eventos = new ArrayList<>();

        usuarios = new ArrayList<>();

        compras = new ArrayList<>();
    }


    public static SistemaConcierto getInstancia() {

        if (instancia == null) {

            instancia = new SistemaConcierto();
        }

        return instancia;
    }


    public List<Evento> getEventos() {

        return eventos;
    }

    public List<Usuario> getUsuarios() {

        return usuarios;
    }

    public List<Compra> getCompras() {

        return compras;
    }


    public void agregarEvento(Evento evento) {

        eventos.add(evento);
    }

    public void agregarUsuario(Usuario usuario) {

        usuarios.add(usuario);
    }

    public void agregarCompra(Compra compra) {

        compras.add(compra);
    }
}