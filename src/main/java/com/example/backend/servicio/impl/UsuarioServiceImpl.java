package com.example.backend.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.excepciones.UsuarioFoundException;
import com.example.backend.modelo.Usuario;
import com.example.backend.repositorio.UsuarioRepository;
import com.example.backend.service.UsuarioService;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;



    @Override
    public Usuario guardarUsuario(Usuario usuario) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioLocal != null){
            System.out.println("El usuario ya existe");
            throw new UsuarioFoundException("El usuario ya esta presente");
        }
        else{
           
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }
	

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }
    @Override
	public Set<Usuario> obtenerMUsuario() {
		
		return new LinkedHashSet<>(usuarioRepository.findAll());
	}



	
}