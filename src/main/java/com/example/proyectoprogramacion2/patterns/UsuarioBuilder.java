package com.example.proyectoprogramacion2.patterns;

import com.example.proyectoprogramacion2.model.Usuario;
import com.example.proyectoprogramacion2.model.SistemaConcierto;

public class UsuarioBuilder {

    private String nombre;
    private String correo;
    private String telefono;
    private String contrasena;

    public UsuarioBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UsuarioBuilder correo(String correo) {
        this.correo = correo;
        return this;
    }

    public UsuarioBuilder telefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public UsuarioBuilder contrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }

    public Usuario build() {

        String id = "U" +
                (SistemaConcierto
                        .getInstancia()
                        .getUsuarios()
                        .size() + 1);

        return new Usuario(
                id,
                nombre,
                correo,
                telefono,
                "CLIENTE",
                contrasena
        );
    }
}
