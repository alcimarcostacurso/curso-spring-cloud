package io.github.cursospring.msclientes.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.cursospring.msclientes.domain.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    Optional<Cliente> findByCpf(String cpf);


    
}
