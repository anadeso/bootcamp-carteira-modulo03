package br.com.alura.carteira.controller;

import br.com.alura.carteira.dto.TransacaoDto;
import br.com.alura.carteira.dto.TransacaoFormDto;
import br.com.alura.carteira.modelo.Transacao;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private List<Transacao> trasacoes = new ArrayList<>();
    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    public List<TransacaoDto> listar() {
        // Exemplo sem a utilizacao do modelmapper
//        List<TransacaoDto> transacoesDto = new ArrayList<>();
//
//        for (Transacao transacao : trasacoes) {
//            TransacaoDto dto = new TransacaoDto();
//            dto.setTicker(transacao.getTicker());
//            dto.setPreco(transacao.getPreco());
//            dto.setQuantidade(transacao.getQuantidade());
//            dto.setTipoTransacao(transacao.getTipoTransacao());
//
//            transacoesDto.add(dto);
//        }
        return trasacoes.stream()
                    .map(t -> modelMapper.map(t, TransacaoDto.class))
                    .collect(Collectors.toList());
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid TransacaoFormDto transacaoFormDto) {
        Transacao transacao = modelMapper.map(transacaoFormDto, Transacao.class);
        trasacoes.add(transacao);
    }
}
