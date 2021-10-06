package br.com.alura.carteira.services;

import br.com.alura.carteira.dto.TransacaoDto;
import br.com.alura.carteira.dto.TransacaoFormDto;
import br.com.alura.carteira.entities.Transacao;
import br.com.alura.carteira.repositories.TransacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public List<TransacaoDto> listar() {
        List<Transacao> transacoes = transacaoRepository.findAll();
        return transacoes.stream()
                .map(x -> modelMapper.map(x, TransacaoDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void cadastrar(TransacaoFormDto transacaoFormDto) {
        Transacao transacao = modelMapper.map(transacaoFormDto, Transacao.class);
        transacao.setId(null);
        transacaoRepository.save(transacao);
    }
}
