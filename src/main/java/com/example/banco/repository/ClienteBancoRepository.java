package com.example.banco.repository;

import com.example.banco.entity.ClienteBanco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteBancoRepository extends JpaRepository<ClienteBanco, Long> {

    //Arg1: qual objeto quero que o méthod seja executado
    // Arg2: tipo do atributo que identifica o aluno (Long)
}
