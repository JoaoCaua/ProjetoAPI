package com.projeto2025.fatec.ProjetoAPI.domain.usuario;
import com.projeto2025.fatec.ProjetoAPI.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Usuario findByNome(String nome);
}
