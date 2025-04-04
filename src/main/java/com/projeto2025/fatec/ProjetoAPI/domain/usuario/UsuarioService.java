package com.projeto2025.fatec.ProjetoAPI.domain.usuario;
import com.projeto2025.fatec.ProjetoAPI.entities.Usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario criarUsuario(Usuario usuario){
        usuario.setId(null);
        Usuario usuarioCriado = usuarioRepository.save(usuario);
        return usuarioCriado;
    }

    public boolean atualizarUsuario(Long id, Usuario usuarioAtualizado){
        Optional<Usuario> usuarioOptional = buscarUsuarioPorId(id);
        if(usuarioOptional.isPresent()){
            Usuario usuario = usuarioOptional.get();
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setEmail(usuarioAtualizado.getEmail());
            usuarioRepository.save(usuario);
            return true;
        }
        return false;
    }

    public boolean deletarUsuario(Long id){
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Usuario> buscarUsuarioPorId(Long id){
        return usuarioRepository.findById(id);
    }
}

