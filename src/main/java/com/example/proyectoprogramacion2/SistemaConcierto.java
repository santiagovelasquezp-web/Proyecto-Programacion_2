package com.example.proyectoprogramacion2;
import com.example.proyectoprogramacion2.decorator.BebidaDecorator;
import com.example.proyectoprogramacion2.decorator.SeguroDecorator;
import com.example.proyectoprogramacion2.decorator.ServicioAdicional;
import com.example.proyectoprogramacion2.enums.EstadoAsiento;
import com.example.proyectoprogramacion2.enums.EstadoCompra;
import com.example.proyectoprogramacion2.enums.EstadoEvento;
import com.example.proyectoprogramacion2.model.*;
import com.example.proyectoprogramacion2.service.CompraService;
import com.example.proyectoprogramacion2.service.EventoService;
import com.example.proyectoprogramacion2.service.UsuarioService;
import com.example.proyectoprogramacion2.strategy.MetodoPago;
import com.example.proyectoprogramacion2.strategy.PagoEfectivo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SistemaConcierto {

    public static void main(String[] args) {

        EventoService eventoService = new EventoService();
        UsuarioService usuarioService = new UsuarioService();
        List<ServicioAdicional> servicios = new ArrayList<>();
        servicios.add(new SeguroDecorator());
        servicios.add(new BebidaDecorator());
        MetodoPago metodoPago = new PagoEfectivo();
        Zona zona1 = new Zona("Z1", "Zona VIP", 600, 150000, new ArrayList<>());

        Recinto recinto = new Recinto("R1", "Movistar Arena", "Estadio el campin", "Bogotá", new ArrayList<>());
        Evento evento1 = new Evento("E001", "Concierto Rock", "Rock", "Evento de rock", "Bogotá",
                LocalDate.now(), LocalTime.now(), EstadoEvento.ACTIVO, recinto, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Usuario usuario1 = new Usuario("U001", "Hitler", "Fuhrer@reich.com", "14881933");
        Asiento asiento1 = new Asiento("1161", "H", 8, EstadoAsiento.DISPONIBLE);

        usuarioService.registrarUsuario(usuario1);
        usuarioService.mostrarUsuarios();
        eventoService.crearEvento(evento1);
        eventoService.mostrarEventos();

        Evento encontrado = eventoService.buscarEventoPorId("E001");
        System.out.println(encontrado);

        CompraService compraService = new  CompraService();
        Compra compraRealizada = compraService.realizarCompra(usuario1, evento1, zona1,  asiento1, metodoPago, servicios);


        System.out.println(compraRealizada);
        System.out.println(asiento1);
    }
}