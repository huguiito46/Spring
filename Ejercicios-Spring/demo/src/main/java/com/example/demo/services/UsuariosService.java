package com.example.demo.services;


import com.example.demo.entities.Usuario;
import com.example.demo.repositories.UsuariosDB;
import com.example.demo.repositories.UsuariosDBMemoria;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {

    UsuariosDB usuariosDB = new UsuariosDBMemoria();

    public void Usuarios(UsuariosDB usuariosDB){

        this.usuariosDB = usuariosDB;

    }

    public Usuario obtenerUsuario(String username){

        Usuario usuario = new Usuario();
        usuario.nombreUsuario = username;

        return usuariosDB.buscar(usuario);

    }

    public void crearUsuario(Usuario usuario) {

        if (usuariosDB.buscar(usuario) != null) {
            return;
        }

        usuariosDB.insertar(usuario);

    }

    public void borrarUsuario(String username){

        Usuario usuario = new Usuario();


    }


}
