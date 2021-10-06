package br.com.alura.carteira.service;

import br.com.alura.carteira.dto.TransacaoDto;
import br.com.alura.carteira.dto.TransacaoFormDto;
import br.com.alura.carteira.modelo.Transacao;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransacaoService {

    private List<Transacao> transacoes = new ArrayList<>();
    private ModelMapper modelMapper = new ModelMapper();

    public List<TransacaoDto> listar() {
        return transacoes.stream()
                .map(x -> modelMapper.map(x, TransacaoDto.class))
                .collect(Collectors.toList());
    }

    public void cadastrar(TransacaoFormDto transacaoFormDto) {
        Transacao transacao = modelMapper.map(transacaoFormDto, Transacao.class);
        transacoes.add(transacao);
    }
}
