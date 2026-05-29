package com.example.proyectoprogramacion2.model;
import com.example.proyectoprogramacion2.patterns.EventoBuilder;
import com.example.proyectoprogramacion2.enums.EstadoEvento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaConcierto {
    private static SistemaConcierto instancia;
    private List<Evento> eventos;
    private List<Usuario> usuarios;
    private List<Compra> compras;
    private Usuario usuarioActual;
    private Evento eventoActual;
    private List<Observador> observadores = new ArrayList<>();

//clase singleton que contiene las listas de eventos usuarios y compras, genera la instancia unica y la clase que quiera acceder a ella debe entrar a esta instancia
    private SistemaConcierto() {

        eventos = new ArrayList<>();
        usuarios = new ArrayList<>();
        compras = new ArrayList<>();
        usuarios.add(new Usuario("1", "Admin Sistema", "admin@eventos.com", "123", "ADMIN", "1161"));
        usuarios.add(new Usuario("2", "Juan Perez", "juan@correo.com", "456", "CLIENTE", "1488"));
        for(Usuario u : usuarios){

            if(u.getRol().equalsIgnoreCase("CLIENTE")){

                suscribir(u);
            }
        }
        Evento e1 = new EventoBuilder().setIdEvento("E101").setNombre("Concierto Juanes").setCategoria("Musica").setCiudad("Medellín").setFecha(LocalDate.of(2026, 8, 15)).setEstado(EstadoEvento.ACTIVO).build();eventos.add(e1);
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

    public void agregarUsuario(Usuario usuario) {

        usuarios.add(usuario);

        if(usuario.getRol().equalsIgnoreCase("CLIENTE")){

            suscribir(usuario);
        }
    }

    public void agregarCompra(Compra compra) {

        compras.add(compra);
    }
    public void suscribir(Observador o) {

        if(!observadores.contains(o)){

            observadores.add(o);
        }
    }


    public void notificar(String mensaje) {
        for (Observador o : observadores) {
            o.actualizar(mensaje);
        }
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public Evento getEventoActual() {
        return eventoActual;
    }

    public void setEventoActual(Evento eventoActual) {
        this.eventoActual = eventoActual;
    }

    public void agregarEvento(Evento evento) {
        eventos.add(evento);notificar("¡Nuevo evento disponible: " + evento.getNombre() + "!");
    }
}