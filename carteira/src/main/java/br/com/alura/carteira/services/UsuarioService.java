package br.com.alura.carteira.services;

import br.com.alura.carteira.dto.UsuarioDto;
import br.com.alura.carteira.dto.UsuarioFormDto;
import br.com.alura.carteira.entities.Usuario;
import br.com.alura.carteira.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public List<UsuarioDto> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        return usuarios.stream()
                .map(x -> modelMapper.map(x, UsuarioDto.class))
                .collect(Collectors.toList());
    }

    public void cadastrar(UsuarioFormDto usuarioFormDto) {
        Usuario usuario = modelMapper.map(usuarioFormDto, Usuario.class);

        String senha = new Random().nextInt(999999) + "";
        usuario.setSenha(senha);

        usuarioRepository.save(usuario);
    }
}
