package com.example.proyectoprogramacion2.service;

import com.example.proyectoprogramacion2.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

        private List<Usuario> usuarios;

        public UsuarioService() {

            usuarios = new ArrayList<>();
        }

        public void registrarUsuario(Usuario usuario) {

            usuarios.add(usuario);

            System.out.println("Usuario registrado correctamente.");
        }

        public Usuario buscarUsuarioPorId(String id) {

            for (Usuario usuario : usuarios) {

                if (usuario.getID().equals(id)) {

                    return usuario;
                }
            }

            return null;
        }

        public void mostrarUsuarios() {

            for (Usuario usuario : usuarios) {

                System.out.println(usuario);
            }
        }
    }
