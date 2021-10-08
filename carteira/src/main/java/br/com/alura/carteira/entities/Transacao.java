package br.com.alura.carteira.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@ToString(exclude = { "dataTransacao", "quantidade", "tipoTransacao"})
@AllArgsConstructor()
@NoArgsConstructor
@Entity
@Table(name = "transacoes")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ticker;
    private BigDecimal preco;
    private int quantidade;
    @Column(name = "data")
    private LocalDate dataTransacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoTransacao tipoTransacao;

    @ManyToOne
    private Usuario usuario;
}
