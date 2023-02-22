package com.example.demo.controllers;

import com.example.demo.entities.Usuario;
import com.example.demo.services.UsuariosService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;
import java.net.URI;

@Component
@Path("/")
public class UsuariosController {
    private final UsuariosService usuariosService;
    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }
    @GET
    @Path("/usuarios/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario listaUno(@PathParam("nombre") String nombre){

        return usuariosService.obtenerUsuario(nombre);

    }
    @GET
    @Path("/usuarios")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)

    public Response crearUsuario(Usuario usuario){

        usuariosService.crearUsuario(usuario);

        return Response.created(
                URI.create("/usuarios/" +usuario.nombreUsuario)).build();
    }
    @DELETE
    @Path("/usuarios/{nombre}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response borrarUsuario(@PathParam("nombre") String nombre){
        usuariosService.borrarUsuario(nombre);
        return Response.ok().build();

    }

}
