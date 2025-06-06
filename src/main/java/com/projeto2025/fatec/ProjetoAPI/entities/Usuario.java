package com.projeto2025.fatec.ProjetoAPI.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="USUARIOS")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false, length = 60)
    private String email;

    @Column(nullable = false, length = 60)
    private String senha;

    public Usuario(){

    }

    public Usuario(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }
}
