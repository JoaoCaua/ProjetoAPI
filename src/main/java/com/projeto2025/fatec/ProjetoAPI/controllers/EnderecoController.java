package com.projeto2025.fatec.ProjetoAPI.controllers;

import com.projeto2025.fatec.ProjetoAPI.infrastructure.viacep.EnderecoDto;
import com.projeto2025.fatec.ProjetoAPI.infrastructure.viacep.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cep")
public class EnderecoController {

    @Autowired
    private ViaCepService viaCepService;

    @GetMapping("/{cep}")
    public EnderecoDto buscarEndereco(@PathVariable String cep) {
        return viaCepService.buscarPorCep(cep);
    }
}