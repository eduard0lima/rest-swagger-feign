package br.com.eduardo.domain;

import br.com.eduardo.bancocentral.CotacaoBancoCentral;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "cotacao")
public class Cotacao {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_cotacao", sequenceName = "seq_cotacao", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cotacao")
    private Long id;

    @Column(name = "data_requisicao")
    private LocalDateTime dataHoraRequisicao;

    @Column(name = "data_cotacao")
    private LocalDate dataCotacao;

    @Column(name = "cotacao_compra")
    private String cotacaoCompra;

    @Column(name = "cotacao_venda")
    private String cotacaoVenda;

    public Cotacao(CotacaoBancoCentral cotacaoBancoCentral) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

        this.dataHoraRequisicao = LocalDateTime.now();
        this.dataCotacao = LocalDate.parse(cotacaoBancoCentral.getData(), formatter);
        this.cotacaoCompra = cotacaoBancoCentral.getCompra();
        this.cotacaoVenda = cotacaoBancoCentral.getVenda();
    }
}
