package br.com.alura.carteira.resources;

import br.com.alura.carteira.dto.TransacaoDto;
import br.com.alura.carteira.dto.TransacaoFormDto;

import br.com.alura.carteira.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoResource {

    @Autowired
    private TransacaoService service;

    @GetMapping
    public List<TransacaoDto> listar() {
        return service.listar();
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid TransacaoFormDto transacaoFormDto) {
        service.cadastrar(transacaoFormDto);
    }
}
