package com.accenture.consumo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

import com.accenture.consumo.model.Endereco;

// @Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
