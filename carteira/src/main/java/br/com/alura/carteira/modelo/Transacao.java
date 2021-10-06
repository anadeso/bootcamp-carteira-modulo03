package br.com.alura.carteira.modelo;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@ToString(exclude = { "dataTransacao", "quantidade", "tipoTransacao"})
@AllArgsConstructor()
@NoArgsConstructor
public class Transacao {

    private String ticker;
    private BigDecimal preco;
    private int quantidade;
    private LocalDate dataTransacao;
    private TipoTransacao tipoTransacao;

}
