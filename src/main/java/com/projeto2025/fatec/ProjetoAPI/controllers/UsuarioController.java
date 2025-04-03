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

        // http://localhost:8080/api/usuario/criarUsuario => POST
        @PostMapping("/criarUsuario")
        public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
            usuario.setId(idCount++);
            usuarios.add(usuario);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }

        // http://localhost:8080/api/usuario/listarUsuarios => GET
        @GetMapping("/listarUsuarios")
        public List<Usuario> ListarUsuarios(){
            return usuarios;
        }

        // http://localhost:8080/api/usuario/deletarUsuario/{id} => DELETE
        @DeleteMapping("/deletarUsuario/{id}")
        public String DeletarUsuarios(@PathVariable Long id){
            for( Usuario usuario: usuarios){
                if(usuario.getId().equals(id)){
                    usuarios.remove(usuario);
                    return "Usuário removido com sucesso!";
                }
            }
            return "Não existe usuário com id: " + id;
        }

        // http://localhost:8080/api/usuario/atualizarUsuario/{id} => PUT
        @PutMapping("/atualizarUsuario/{id}")
        public ResponseEntity<String> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado){
            for( Usuario usuario: usuarios){
                if(usuario.getId().equals(id)){
                    usuario.setNome(usuarioAtualizado.getNome());
                    usuario.setEmail(usuarioAtualizado.getEmail());
    
                    logger.info("Usuário atualizado: Id={}, Nome={}, Email={}", usuario.getId(), usuario.getNome(), usuario.getEmail());
                    return ResponseEntity.ok("Usuário atualizado com sucesso!");
                }
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário com ID " + id + " não encontrado.");
        }

        // http://localhost:8080/api/usuario/buscarUsuario/{id} => GET
        @GetMapping("/buscarUsuario/{id}")
        public ResponseEntity<?> buscarUsuarioPorId(@PathVariable Long id){
            for(Usuario usuario: usuarios){
                if(usuario.getId().equals(id)){
                    return ResponseEntity.ok(usuario);
                }
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário com ID " + id + " não encontrado.");
        }

        // http://localhost:8080/swagger-ui/index.html#/
}
