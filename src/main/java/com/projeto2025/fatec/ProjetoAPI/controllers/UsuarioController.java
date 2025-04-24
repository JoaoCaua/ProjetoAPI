package com.projeto2025.fatec.ProjetoAPI.controllers;
import com.projeto2025.fatec.ProjetoAPI.entities.Usuario;
import com.projeto2025.fatec.ProjetoAPI.domain.usuario.UsuarioService;
import com.projeto2025.fatec.ProjetoAPI.exception.RecursoNaoEncontradoException;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class.getName());
    private final List<Usuario> usuarios = new ArrayList<>();
    private Long idCount = 1L;

        // http://localhost:8080/api/usuarios/criarUsuario => POST
        @PostMapping("/criarUsuario")
        public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
            Usuario novoUsuario = usuarioService.criarUsuario(usuario);
            logger.info("Recebido JSON: Nome={}, Email={}", novoUsuario.getNome(), novoUsuario.getEmail());
            return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
        }

        // http://localhost:8080/api/usuarios/listarUsuarios => GET
        @GetMapping("/listarUsuarios")
        public List<Usuario> ListarUsuarios(){
            return usuarioService.listarUsuarios();
        }

        // http://localhost:8080/api/usuarios/deletarUsuario/{id} => DELETE
        @DeleteMapping("/deletarUsuario/{id}")
        public ResponseEntity<String> DeletarUsuarios(@PathVariable Long id){
            boolean removido = usuarioService.deletarUsuario(id);
            if(removido){
                return ResponseEntity.ok("Usuário removido com sucesso!");
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe usuário com id: " + id);
            }
        }

        // http://localhost:8080/api/usuarios/atualizarUsuario/{id} => PUT
        @PutMapping("/atualizarUsuario/{id}")
        public ResponseEntity<String> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado){
            boolean atualizado = usuarioService.atualizarUsuario(id, usuarioAtualizado);
            if(atualizado){
                return ResponseEntity.ok("Usuário atualizado com sucesso!");
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário com ID " + id + " não encontrado.");
            }
        }

        // http://localhost:8080/api/usuarios/buscarUsuario/{id} => GET
        @GetMapping("/buscarUsuario/{id}")
        public ResponseEntity<?> buscarUsuarioPorId(@PathVariable Long id){
            Optional<Usuario> usuario = usuarioService.buscarUsuarioPorId(id);
            return usuario.<ResponseEntity<?>>map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário com ID: " + id + " não encontrado."));
        }

        // http://localhost:8080/swagger-ui/index.html#/
        // http://localhost:8080/h2
}
