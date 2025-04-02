package com.projeto2025.fatec.ProjetoAPI.controllers;
import com.projeto2025.fatec.ProjetoAPI.entities.Usuario;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class.getName());
    private final List<Usuario> usuarios = new ArrayList<>();
    private Long idCount = 1L;

        // http://localhost:8080/api/cliente/criarUsuario => POST
        @PostMapping("/criarUsuario")
        public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
            usuario.setId(idCount++);
            usuarios.add(usuario);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }

        // http://localhost:8080/api/cliente/listarUsuarios => GET
        @GetMapping("/listarUsuarios")
        public List<Usuario> ListarUsuarios(){
            return usuarios;
        }

}
