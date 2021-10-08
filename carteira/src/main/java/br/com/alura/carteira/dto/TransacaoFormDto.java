package br.com.alura.carteira.dto;

import br.com.alura.carteira.entities.TipoTransacao;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Digits;
import javax.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class TransacaoFormDto {

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 6)
    @Pattern(regexp = "[a-zA-Z]{4}[0-9][0-9]?")
    private String ticker;
    @Digits(integer=5, fraction=2)
    private BigDecimal preco;
    private int quantidade;

    @PastOrPresent
    @Column(name = "data")
    private LocalDate dataTransacao;
    @Column(name = "tipo")
    private TipoTransacao tipoTransacao;

    @JsonAlias("usuario_id")
    private Long usuarioId;
}
