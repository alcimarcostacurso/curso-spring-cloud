package io.github.cursospring.mscartores.application;

import io.github.cursospring.mscartores.domain.Cartao;
import io.github.cursospring.mscartores.domain.ClienteCartao;
import io.github.cursospring.mscartores.representation.CartaoSaveRequest;
import io.github.cursospring.mscartores.representation.CartoesPorClienteResponse;
import io.github.cursospring.mscartores.services.CartaoService;
import io.github.cursospring.mscartores.services.ClienteCartaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cartoes")
@RequiredArgsConstructor
public class CartoesResource {

    private final CartaoService cartaoService;
    private final ClienteCartaoService clienteCartaoService;

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody CartaoSaveRequest request){
        Cartao cartao = request.toModel();
        cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartaoesRendaAteh(@RequestParam("renda") Long renda){
        List<Cartao> list = cartaoService.getCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorClienteResponse>> getCartoesByCliente(
            @RequestParam("cpf") String cpf){

        List<ClienteCartao> lista = clienteCartaoService.listCartoesByCpf(cpf);
        List<CartoesPorClienteResponse> resultList = lista.stream()
                .map(CartoesPorClienteResponse::fromModel)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resultList);
    }
}
