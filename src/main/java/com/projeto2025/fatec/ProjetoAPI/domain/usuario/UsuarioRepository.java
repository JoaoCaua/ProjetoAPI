package com.projeto2025.fatec.ProjetoAPI.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto2025.fatec.ProjetoAPI.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
