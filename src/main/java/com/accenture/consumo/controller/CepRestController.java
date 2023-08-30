package com.accenture.consumo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.consumo.interfaces.CepService;
import com.accenture.consumo.model.Endereco;
import com.accenture.consumo.repository.EnderecoRepository;

@RestController
public class CepRestController {

    @Autowired
    private CepService cepService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("/{cep}")
    public ResponseEntity<Object> getCep(@PathVariable String cep) {

        Endereco endereco = cepService.buscarEnderecoPorCep(cep);

        if (endereco == null) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CEP não encontrado");

        try {
            enderecoRepository.save(endereco);
            return ResponseEntity.ok().body(endereco);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CEP não encontrado");
        }
    }
}
