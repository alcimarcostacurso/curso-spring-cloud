package io.github.cursospring.mscartores.infra.repository;

import io.github.cursospring.mscartores.domain.ClienteCartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteCartaoRepository extends JpaRepository<ClienteCartao, Long> {

    List<ClienteCartao> findByCpf(String cpf);
}
