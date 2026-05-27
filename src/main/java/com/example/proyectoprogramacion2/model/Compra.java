package com.example.proyectoprogramacion2.model;
import com.example.proyectoprogramacion2.decorator.ServicioAdicional;
import com.example.proyectoprogramacion2.enums.EstadoCompra;
import com.example.proyectoprogramacion2.strategy.MetodoPago;
import java.time.LocalDateTime;
import java.util.List;

public class Compra {
    private String idCompra;
    private Usuario usuario;
    private Evento evento;
    private LocalDateTime fechaCreacion;
    private EstadoCompra estado;
    private double total;
    private MetodoPago metodoPago;
    private List<Entrada> entradas;
    private List<ServicioAdicional> servicios;

    public Compra(String idCompra, Usuario usuario, Evento evento, LocalDateTime fechaCreacion, EstadoCompra estado, double total,
                  MetodoPago metodoPago, List<Entrada> entradas, List<ServicioAdicional> servicios) {
        this.idCompra = idCompra;
        this.usuario = usuario;
        this.evento = evento;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.total = total;
        this.metodoPago = metodoPago;
        this.entradas = entradas;
        this.servicios = servicios;
    }
//clase compra que contiene todos los metodos necesarios para generar una compra en el sistema
    public String getIdCompra() {

        return idCompra;
    }

    public void setIdCompra(String idCompra) {

        this.idCompra = idCompra;
    }

    public Usuario getUsuario() {

        return usuario;
    }

    public void setUsuario(Usuario usuario) {

        this.usuario = usuario;
    }

    public Evento getEvento() {

        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public EstadoCompra getEstado() {
        return estado;
    }

    public void setEstado(EstadoCompra estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public List<ServicioAdicional> getServicios() {
        return servicios;
    }

    public void setServicios(List<ServicioAdicional> servicios) {
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "idCompra='" + idCompra + '\'' +
                ", usuario=" + usuario +
                ", evento=" + evento +
                ", fechaCreacion=" + fechaCreacion +
                ", estado=" + estado +
                ", total=" + total +
                ", metodoPago=" + metodoPago +
                ", entradas=" + entradas +
                ", servicios=" + servicios +
                '}';
    }
    //metodo para calcular el valor de la entrada
    // crear metodos para el cambio en compras y demas
}