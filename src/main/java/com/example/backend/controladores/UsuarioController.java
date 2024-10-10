package com.example.backend.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.backend.modelo.Usuario;
import com.example.backend.service.UsuarioService;

import java.util.HashSet;
import java.util.Set;
@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
// registrar usuarios normales
    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{
   
    	  usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
    	    return usuarioService.guardarUsuario(usuario);
    }

// registrar usuarios admin
  
    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
        return usuarioService.obtenerUsuario(username);
    }
    @GetMapping("/")
    public ResponseEntity<?> listarUsuario(){
        return ResponseEntity.ok(usuarioService.obtenerMUsuario());
    }
    
    

    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioService.eliminarUsuario(usuarioId);
    }

}
