package br.com.alura.carteira.modelo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.ManyToOne;

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
    private LocalDate dataTransacao;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;

    @ManyToOne
    private Usuario usuario;
}
