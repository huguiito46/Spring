package com.example.demo.repositories;

import com.example.demo.entities.Usuario;
import java.util.ArrayList;

public abstract class UsuariosDB {
    private int totalInserciones = 0;
    private int totalEliminaciones = 0;

    protected void incrementarInserciones(){

        this.totalInserciones++;

    }
    protected void incrementarEliminaciones(){
        this.totalEliminaciones++;
    }

    abstract public ArrayList<Usuario> obtener();
    abstract public Usuario buscar(Usuario usuario);
    abstract public void insertar(Usuario usuario);
    abstract public void borrar(Usuario usuario);
}
