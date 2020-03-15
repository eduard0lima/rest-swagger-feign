package br.com.eduardo.bancocentral;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CotacaoBancoCentral {

    @JsonProperty("cotacaoCompra")
    private String compra;

    @JsonProperty("cotacaoVenda")
    private String venda;

    @JsonProperty("dataHoraCotacao")
    private String data;

}
