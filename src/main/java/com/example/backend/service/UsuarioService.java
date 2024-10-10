package com.example.backend.service;

import java.util.Set;

import com.example.backend.modelo.Usuario;





public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long usuarioId);
    Set<Usuario> obtenerMUsuario();
}
