package io.github.cursospring.msclientes.representation;

import io.github.cursospring.msclientes.domain.Cliente;
import lombok.Data;

@Data
public class ClienteSaveRequest {

    private String cpf;
    private String nome;
    private Integer idade;

    public Cliente toModel(){
        return new Cliente(cpf, nome, cpf);
    }

    
}
